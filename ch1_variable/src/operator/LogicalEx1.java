package operator;

/*  && : 피연산자 양쪽 모두 true 여야 true 결과를 얻음
 *  || : 피연산자 중 어느 한 쪽만 true 여도 true 결과를 얻음
 */

public class LogicalEx1 {

  public static void main(String[] args) {
    // x 는 10 보다 크고, 20보다 작다
    int x = 15;
    System.out.println(x > 10 && x < 20);

    int charCode = 'A'; // 자동형변환

    if ((charCode >= 65) && (charCode <= 90)) {
      System.out.println("대문자");
    }

    char charCode2 = 'a';
    System.out.println(charCode2 >= 'a' && charCode2 <= 'z');
    if ((charCode2 >= 'a') && (charCode2 <= 'z')) {
      System.out.println("소문자");
    }

    // i 는 2의 배수 또는 3의 배수이다
    // i % 2 == 0 || i % 3 == 0
    int i = 6;
    System.out.println(i % 2 == 0 || i % 3 == 0);

    // i 는 2의 배수 또는 3의 배수이지만, 6의 배수는 아니다
    System.out.println((i % 2 == 0 || i % 3 == 0) && i % 6 != 0);
  }
}
