package exception;

/*  Exception(예외)
 *  1) 컴파일 예외(CheckedException)
 *      컴파일 시에 발생하는 예외 (컴파일러가 바로 알려줌)
 *  2) 런타입 예외
 *      실행 시에 발생하는 예외(ArrayIndexOutOfBoundsException, ClassCastException, NullPointerException, ArithmeticException, ...)
 *  3) 논리적 예외
 *      실행은 되나, 의도와는 다르게 동작
 *
 *  - 예외 핸들링
 *  1) try ~ catch 사용
 *  2) throws : 예외를 메소드에 선언하는 방법 → 해당 메소드를 호출하는 측에 exception 이 전달됨
 */

public class CheckedException {

  public static void main(String[] args) throws ClassNotFoundException {
    // try {
    //   Class.forName("java.jang.String2");
    // } catch (ClassNotFoundException e) {
    //   //   e.printStackTrace(); // 개발할 때 주로 사용
    //   //   System.out.println(e.getMessage());
    //   System.out.println("해당하는 클래스는 없습니다.");
    // }

    Class.forName("java.jang.String2");
  }

  public static void method1() {}

  public static void method2() {}
}
