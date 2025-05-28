package lang;

/*  java.lang.String : 문자열 클래스
 *  - 변경 불가능(immutable)한 클래스
 */

public class StringEx1 {

  public static void main(String[] args) {
    // 인스턴스 생성
    String str = new String("abc");
    String str2 = "abc"; // 저장 방식이 다름
    String str3 = "abc";

    // == 주소 비교
    System.out.println(str2 == str3 ? "같음" : "다름");
    System.out.println(str3 == str ? "같음" : "다름"); // 서로 다른 주소

    // String equals() 오버라이딩 : 값 비교 (오버라이딩이 되어 있음)
    System.out.println("equals() 결과"); // 문자열 비교
    System.out.println(str2.equals(str3) ? "같음" : "다름");
    System.out.println(str3.equals(str) ? "같음" : "다름");

    String a = "a";
    String b = "b";
    a = a + b;
    // 문자열 결합횟수가 많다면 효율성이 떨어질 수 있음 → StringBuffer, StringBuilder 클래스 사용 (원본 수정이 불가하기 때문)
  }
}
