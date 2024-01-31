package operator;

/*  단항 연산자 : 부호 - 양수, 음수, 증감연산자(++, --)
 *               ++ = 변수 + 1 / -- = 변수 - 1
 */

public class IncDecEx1 {

  public static void main(String[] args) {
    int x = 10, y = 20;
    System.out.println("x = " + (x++)); // 후행연산자 : x = x; (1차 실행) x = x+1; (2차 실행)
    System.out.println("y = " + (y++));

    System.out.printf("x = %d, y = %d\n", x, y);

    System.out.println("x = " + (++x)); // 선행연산자 : x = x+1; (1차 실행)
    System.out.println("y = " + (++y));
    System.out.printf("x = %d, y = %d\n", x, y);
  }
}
