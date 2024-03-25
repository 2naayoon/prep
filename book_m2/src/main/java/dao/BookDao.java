package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.BookDto;
import dto.ChangeDto;
import dto.MemberDto;

public class BookDao {

    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;

    // JDBC 단계
    // 1. 드라이버 로드
    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 2. 커넥션 얻어오기
    public Connection getConnection() {
        // String url = "jdbc:oracle:thin:@localhost:1521:xe";
        // String user = "c##test2";
        // String password = "test";

        // try {
        // con = DriverManager.getConnection(url, user, password);
        // } catch (SQLException e) {
        // e.printStackTrace();
        // }

        // return con;

        // Tomcat
        Context initContext;
        try {
            initContext = new InitialContext();
            // java:/comp/env : 등록된 이름 관리
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
            con = ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    // 3. CRUD
    // Read
    public List<BookDto> getList() {
        List<BookDto> list = new ArrayList<>();
        con = getConnection();
        String sql = "select * from booktbl order by code desc";
        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                BookDto dto = new BookDto();
                dto.setCode(rs.getInt("code"));
                dto.setTitle(rs.getString("title"));
                dto.setWriter(rs.getString("writer"));
                dto.setPrice(rs.getInt("price"));

                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con, pstmt, rs);
        }
        return list;
    }

    public BookDto getRow(int code) {
        BookDto dto = null;
        con = getConnection();
        String sql = "select * from booktbl where code=?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, code);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                dto = new BookDto();
                dto.setCode(rs.getInt("code"));
                dto.setTitle(rs.getString("title"));
                dto.setWriter(rs.getString("writer"));
                dto.setPrice(rs.getInt("price"));
                dto.setDescription(rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con, pstmt, rs);
        }
        return dto;
    }

    // Update
    public int update(BookDto updateDto) {
        int result = 0;
        con = getConnection();
        String sql = "UPDATE BOOKTBL SET PRICE = ? WHERE CODE = ?";
        try {
            pstmt = con.prepareStatement(sql);
            // ? 해결
            pstmt.setInt(1, updateDto.getPrice());
            pstmt.setInt(2, updateDto.getCode());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con, pstmt, rs);
        }
        return result;
    }

    // Create
    public int insert(BookDto insertDto) {
        int result = 0;

        con = getConnection();
        String sql = "INSERT INTO BOOKTBL(code, title, writer, price, description) VALUES(?,?,?,?,?)";
        try {
            pstmt = con.prepareStatement(sql);
            // ? 해결
            pstmt.setInt(1, insertDto.getCode());
            pstmt.setString(2, insertDto.getTitle());
            pstmt.setString(3, insertDto.getWriter());
            pstmt.setInt(4, insertDto.getPrice());
            pstmt.setString(5, insertDto.getDescription());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con, pstmt, rs);
        }
        return result;
    }

    // SerachList
    public List<BookDto> getSearchList(String criteria, String keyword) {
        List<BookDto> list = new ArrayList<>();
        con = getConnection();
        String sql = "";

        // 검색기준(criteria)이 code 라면
        // SELECT * FROM BOOKTBL WHERE code=?;
        // 검색기준(criteria)이 writer 라면
        // SELECT * FROM BOOKTBL WHERE writer=?;

        if (criteria.equals("code")) {
            sql = "SELECT * FROM BOOKTBL WHERE code=?";
        } else {
            sql = "SELECT * FROM BOOKTBL WHERE writer=?";
        }

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, keyword);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                BookDto dto = new BookDto();
                dto.setCode(rs.getInt("code"));
                dto.setTitle(rs.getString("title"));
                dto.setWriter(rs.getString("writer"));
                dto.setPrice(rs.getInt("price"));

                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con, pstmt, rs);
        }
        return list;
    }

    // Delete
    public int delete(int code) {
        int result = 0;
        con = getConnection();
        String sql = "delete booktbl where code=?";

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, code);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con, pstmt, rs);
        }
        return result;
    }

    // member 작업
    // 로그인
    // SELECT userid, name FROM MEMBERTBL m WHERE USERID = 'hon123' AND PASSWORD =
    // 'hong123';
    public MemberDto isLogin(MemberDto loginDto) {
        MemberDto dto = null;
        con = getConnection();
        String sql = "SELECT userid, name FROM MEMBERTBL m  WHERE  USERID = ? AND  PASSWORD  = ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, loginDto.getUserid());
            pstmt.setString(2, loginDto.getPassword());
            rs = pstmt.executeQuery();

            if (rs.next()) {
                dto = new MemberDto();
                dto.setUserid(rs.getString("userid"));
                dto.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con, pstmt, rs);
        }
        return dto;
    }

    // 비밀번호 변경
    // UPDATE MEMBERTBL SET PASSWORD = 'hong456' WHERE USERID = 'hong123';
    public int passwordChange(ChangeDto changeDto) {
        int result = 0;
        con = getConnection();
        String sql = "UPDATE  MEMBERTBL SET PASSWORD = ? WHERE USERID = ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, changeDto.getNewPassword());
            pstmt.setString(2, changeDto.getUserid());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con, pstmt, rs);
        }
        return result;
    }

    // 회원가입
    // INSERT INTO MEMBERTBL m (userid, password, name, email) values('hong123',
    // 'hong123', '홍길동', 'hong123@gmail.com');
    public int register(MemberDto insertDto) {
        int result = 0;
        con = getConnection();
        String sql = "INSERT INTO MEMBERTBL m (userid, password, name, email) values(?,?,?,?)";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, insertDto.getUserid());
            pstmt.setString(2, insertDto.getPassword());
            pstmt.setString(3, insertDto.getName());
            pstmt.setString(4, insertDto.getEmail());
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, pstmt, rs);
        }
        return result;
    }

    public int leave(MemberDto leaveDto) {
        int result = 0;
        con = getConnection();
        String sql = "delete membertbl where password=?";

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, leaveDto.getPassword());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con, pstmt, rs);
        }
        return result;
    }

    // 4. 자원 정리
    public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
            if (pstmt != null)
                pstmt.close();
            if (con != null)
                con.close();
        } catch (Exception e) {
        }
    }
}
