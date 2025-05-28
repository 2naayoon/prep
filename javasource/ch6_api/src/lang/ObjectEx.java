package lang;

/*  java.lang.* : 기본 패키지 (import 구문 없이 사용 가능)
 *  java.lang.Object : 모든 클래스의 부모 (조상)
 *            Object에서 넘겨 받을 시 : equals() = '==' 과 같은 역할
 *            toString() : 객체 자신의 정보를 문자열로 반환
 */

public class ObjectEx {

  public static void main(String[] args) {
    // 인스턴스 생성
    Object obj1 = new Object();
    Object obj2 = new Object();

    if (obj1.equals(obj2)) {
      System.out.println("두 객체는 같다");
    } else {
      System.out.println("두 객체는 다르다"); // 주소 물어보는 것이라 다르다
    }

    if (obj1 == obj2) {
      System.out.println("두 객체는 같다");
    } else {
      System.out.println("두 객체는 다르다"); // 주소 물어보는 것이라 다르다
    }

    // obj1.toString() java.lang.Object@7a81197d
    // obj2.toString() java.lang.Object@3f99bd52
    System.out.println("obj1.toString() " + obj1.toString());
    System.out.println("obj2.toString() " + obj2.toString());

    Value value1 = new Value(10);
    Value value2 = new Value(10);
    if (value1.equals(value2)) {
      System.out.println("두 객체는 같다");
    } else {
      System.out.println("두 객체는 다르다");
    }

    // value1.toString() lang.Value@3a71f4dd - 오버라이딩 필요
    System.out.println("value1.toString() " + value1.toString());

    Member member1 = new Member("hong123");
    Member member2 = new Member("hong123");

    // 오버라이딩으로 equals 재정의
    // equals() : 값 비교
    // == : 주소비교
    System.out.println(member1.equals(member2) ? "같다" : "다르다");
    System.out.println(member1 == member2 ? "같다" : "다르다");

    Person person1 = new Person("1234", "1234");
    Person person2 = new Person("1234", "1234");

    System.out.println(person1.equals(person2));
  }
}
