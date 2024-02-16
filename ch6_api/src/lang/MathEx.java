package lang;

/*  java.lang : 기본 패키지여서 import 구문이 필요없음
 *
 *  java.lang.Math : 기본적인 수학 계산에 유용한 메소드로 구성된 클래스
 *           static 메소드, 변수 → 클래스 이름.변수, 클래스이름.메소드
 *           static final : 상수
 */

public class MathEx {

  public static void main(String[] args) {
    System.out.println(Math.PI);
    // 0 ~ 1 미만의 임의의 숫자
    System.out.println(Math.random());

    // round() : 반올림
    double val = 90.7552;
    System.out.println("round() " + Math.round(val));
    val += 100;
    System.out.println("round() " + Math.round(val));

    System.out.println("round() " + Math.round(val) / 100);
    System.out.println("round() " + Math.round(val) / 100.0);

    System.out.println();

    // ceil() : 올림
    // floor() : 버림
    // rint() : 반올림 - double 리턴 / round() : 반올림 - long or int 리턴
    System.out.printf("ceil(%3.1f) = %3.1f\n", 1.1, Math.ceil(1.1));
    System.out.printf("floor(%3.1f) = %3.1f\n", 1.5, Math.floor(1.5));
    System.out.printf("round(%3.1f) = %d\n", 1.1, Math.round(1.1));
    System.out.printf("round(%3.1f) = %d\n", 1.5, Math.round(1.5));
    System.out.printf("rint(%3.1f) = %f\n", 1.5, Math.rint(1.5));
    System.out.printf("round(%3.1f) = %d\n", -1.5, Math.round(-1.5));
    System.out.printf("rint(%3.1f) = %f\n", -1.5, Math.rint(-1.5));
    System.out.printf("ceil(%3.1f) = %f\n", -1.5, Math.ceil(-1.5));
    System.out.printf("floor(%3.1f) = %f\n", -1.5, Math.floor(-1.5));
  }
}
