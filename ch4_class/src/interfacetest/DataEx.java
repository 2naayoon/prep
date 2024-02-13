package interfacetest;

public class DataEx {

  public static void main(String[] args) {
    // DataAccessObject obj = new Oracle();
    // dbWork(obj);
    // obj = new MySql();
    // dbWork(obj);
    dbWork(new Oracle());
    dbWork(new MySql());

    // 익명 클래스 : 일회용 클래스 (선언과 생성 동시)
    DataAccessObject object = new DataAccessObject() {
      @Override
      public void select() {
        System.out.println("PostgreSQL 검색");
      }

      @Override
      public void insert() {
        System.out.println("PostgreSQL 삽입");
      }

      @Override
      public void update() {
        System.out.println("PostgreSQL 수정");
      }

      @Override
      public void delete() {
        System.out.println("PostgreSQL 삭제");
      }
    };

    dbWork(object);
  }

  public static void dbWork(DataAccessObject dao) {
    dao.select(); // Oracle DB에서 검색 or MySql DB에서 검색
    dao.insert(); // Oracle DB에서 삽입 or MySql DB에서 삽입
    dao.update(); // Oracle DB에서 수정 or MySql DB에서 수정
    dao.delete(); // Oracle DB에서 삭제 or MySql DB에서 삭제
  }
}
