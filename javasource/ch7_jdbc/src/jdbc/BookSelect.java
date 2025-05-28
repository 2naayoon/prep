package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookSelect {

  public static void main(String[] args) {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null; // select 할때만 사용하는 객체

    try {
      //1. 드라이버 로드
      Class.forName("oracle.jdbc.OracleDriver");

      //2. 커넥션 얻기
      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String user = "c##test2";
      String password = "test";
      con = DriverManager.getConnection(url, user, password);

      //3. sql 구문 작성
      //String sql = "SELECT * FROM BOOKTBL WHERE code=1000";
      String sql = "SELECT * FROM BOOKTBL";
      //4. sql 구문 전송
      pstmt = con.prepareStatement(sql);
      //5. sql 구문 실행
      // executeQuery() - 실행할 sql구문이 select 일때 호출(리턴 값 ResultSet)
      rs = pstmt.executeQuery();
      // ResultSet : sql 실행 결과가 담긴 객체(테이블 모양)
      // rs.next() : true 일 때 = 읽어올 결과가 있음
      // rs.getString(컬럼번호) : 가져올 컬럼 데이터가 varchar2(nvarchar2) 일 때
      // rs.getString(컬럼명)
      // rs.getInt(컬럼번호) or rs.getInt(컬럼명) : 가져올 컬럼 데이터가 number 일 때

      while (rs.next()) {
        int code = rs.getInt(1);
        String title = rs.getString(2);
        String writer = rs.getString(3);
        int price = rs.getInt(4);
        System.out.printf("%d %s %s %d\n", code, title, writer, price);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (rs != null) rs.close();
        if (pstmt != null) pstmt.close();
        if (con != null) con.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
