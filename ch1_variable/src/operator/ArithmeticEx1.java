package operator;

/*  산술연산자 : +, -, *, / : 몫만 나옴, %(나머지)
 */

public class ArithmeticEx1 {

  public static void main(String[] args) {
    int num1 = 5, num2 = 2;
    int result1 = num1 + num2;
    System.out.printf("%d + %d = %d\n", num1, num2, result1);

    result1 = num1 - num2;
    System.out.printf("%d - %d = %d\n", num1, num2, result1);

    result1 = num1 * num2;
    System.out.printf("%d * %d = %d\n", num1, num2, result1);

    result1 = num1 / num2;
    System.out.printf("%d / %d = %d\n", num1, num2, result1);

    result1 = num1 % num2;
    System.out.printf("%d %% %d = %d\n", num1, num2, result1); // % 하나만 사용하면 뒤에 다른 게 올 거라 생각, %를 사용한다고 하려면 %% 작성

    double d1 = 6.0d;
    int d2 = 4;
    double result2 = d1 / d2;
    System.out.printf("%f / %d = %f\n", d1, d2, result2);

    result2 = d1 % d2;
    System.out.printf("%f %% %d = %f\n", d1, d2, result2);

    char ch1 = 'A' + 1;

    // * Error : Type mismatch: cannot convert from int to char
    // char ch2 = ch1 + 1;
    System.out.printf("ch = %c", ch1);
  }
}
