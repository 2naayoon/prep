package operator;

public class CompareEx1 {

  public static void main(String[] args) {
    // 비교 연산자 결과는 true or false 로 나옴
    int num1 = 10, num2 = 10;

    System.out.println(num1 == num2);
    System.out.println(num1 != num2);
    System.out.println(num1 <= num2);

    char ch1 = 'A', ch2 = 'B';
    System.out.println(ch1 == ch2); // 65 == 66
    System.out.println(ch1 <= ch2);
    System.out.println(ch1 != ch2);

    float f1 = 0.1f;
    double d1 = 0.1d;
    System.out.printf("f1 == d1 = %b\n", f1 == d1); // false
    System.out.printf("f1 == d1 = %b\n", f1 == (float) d1); // true (강제형변환)
  }
}
