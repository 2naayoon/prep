package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BookDelete {

  public static void main(String[] args) {
    Connection con = null;
    PreparedStatement pstmt = null;

    try {
      //1. 드라이버 로드
      Class.forName("oracle.jdbc.OracleDriver");

      //2. 커넥션 얻기
      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String user = "c##test2";
      String password = "test";
      con = DriverManager.getConnection(url, user, password);

      String sql = "DELETE FROM BOOKTBL WHERE code = 1004";

      // 3. sql 문 전송
      pstmt = con.prepareStatement(sql);

      //4. sql 구문 실행
      // executeUpdate() - 실행할 sql구문이 insert,update,delete 일때 호출(리턴 값 int)
      int result = pstmt.executeUpdate();
      if (result > 0) {
        System.out.println("삭제 성공");
      } else {
        System.out.println("삭제 실패");
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (pstmt != null) {
          pstmt.close();
        }
        if (con != null) {
          con.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
