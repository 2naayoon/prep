package member;

import static member.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*  DAO 메소드 작성
 *  - 실행할 sql 구문 작성
 *    insert, update, delete → executeUpdate() → int
 *    select
 *      1) 결과 값 하나라면 : excuteQuery() → ~~DTO
 *      2) 결과 값 여러개라면 → List<~~DTO>
 */

public class MemberDAO {

  private Connection con;
  private PreparedStatement pstmt;
  private ResultSet rs;

  public int insert(MemberDTO dto) {
    String sql = "INSERT INTO MEMBERTBL(userid, password, name, email) "; // sql문 작성 시 항상 끝에 한 칸 띄기
    sql += "values(?,?,?,?)";
    int result = 0;

    con = getConnection();
    try {
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, dto.getUserid());
      pstmt.setString(2, dto.getPassword());
      pstmt.setString(3, dto.getName());
      pstmt.setString(4, dto.getEmail());
      result = pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      close(con, pstmt);
    }
    return result;
  }

  public MemberDTO getRow(String userid, String password) {
    // 개별 회원 조회
    con = getConnection();
    MemberDTO memberDTO = null;

    String sql =
      "SELECT * FROM MEMBERTBL m  WHERE  USERID = ? AND  PASSWORD  = ?";

    try {
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, userid);
      pstmt.setString(2, password);
      rs = pstmt.executeQuery();
      if (rs.next()) {
        memberDTO = new MemberDTO();
        memberDTO.setUserid(rs.getString("userid"));
        memberDTO.setPassword(rs.getString("password"));
        memberDTO.setName(rs.getString("name"));
        memberDTO.setEmail(rs.getString("email"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      close(con, pstmt, rs);
    }
    return memberDTO;
  }

  //   public MemberDTO getRow(MemberDTO dto) {
  //     // 개별 회원 조회
  //     con = getConnection();
  //     MemberDTO memberDTO = null;
  //     String sql =
  //       "SELECT * FROM MEMBERTBL m  WHERE  USERID = ? AND  PASSWORD  = ?";
  //     try {
  //       pstmt = con.prepareStatement(sql);
  //       pstmt.setString(1, dto.getUserid());
  //       pstmt.setString(2, dto.getPassword());
  //       rs = pstmt.executeQuery();
  //       if (rs.next()) {
  //         memberDTO = new MemberDTO();
  //         memberDTO.setUserid(rs.getString("userid"));
  //         memberDTO.setPassword(rs.getString("password"));
  //         memberDTO.setName(rs.getString("name"));
  //         memberDTO.setEmail(rs.getString("email"));
  //       }
  //     } catch (SQLException e) {
  //       e.printStackTrace();
  //     } finally {
  //       close(con, pstmt, rs);
  //     }
  //     return memberDTO;
  //   }

  public List<MemberDTO> getRows() {
    List<MemberDTO> list = new ArrayList<>();

    con = getConnection();
    String sql = "SELECT * FROM MEMBERTBL";

    try {
      pstmt = con.prepareStatement(sql);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        MemberDTO dto = new MemberDTO();
        dto.setUserid(rs.getString("userid"));
        dto.setPassword(rs.getString("password"));
        dto.setName(rs.getString("name"));
        dto.setEmail(rs.getString("email"));

        list.add(dto);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close(con, pstmt, rs);
    }
    return list;
  }

  public int update(String userid, String password) {
    String sql = "UPDATE  MEMBERTBL ";
    sql += "SET PASSWORD = ? WHERE USERID = ?";
    int result = 0;

    try {
      con = getConnection();
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, password);
      pstmt.setString(2, userid);
      result = pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      close(con, pstmt);
    }
    return result;
  }

  public int delete(String userid) {
    String sql = "DELETE FROM MEMBERTBL WHERE USERID = ?";
    int result = 0;
    try {
      con = getConnection();
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, userid);
      result = pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      close(con, pstmt);
    }
    return result;
  }
}
