package operator;

import java.util.Scanner;

public class ConditionEx2 {

  public static void main(String[] args) {
    // 숫자 입력 받은 후 그 숫자가 양수인지 음수인지 판별
    Scanner sc = new Scanner(System.in);

    System.out.print("숫자 입력 ");
    int num = sc.nextInt();
    System.out.println(num >= 0 ? "양수" : "음수");

    // 짝수인지 홀수인지 판별
    System.out.println(num % 2 == 0 ? "짝수" : "홀수");

    char ch1 = 'a';
    // ch1 이 영문자(A~Z, a~z) 이거나 1~9 사이의 숫자인지 판별 - true
    boolean result =
      ch1 >= 'A' &&
      ch1 <= 'Z' ||
      ch1 >= 'a' &&
      ch1 <= 'z' ||
      ch1 >= 1 &&
      ch1 <= 9;
    System.out.println(result);

    System.out.println(
      (ch1 >= 65 && ch1 <= 90) || (ch1 >= 97 && ch1 <= 122)
        ? true
        : (ch1 >= 1 && ch1 <= 9 ? true : false)
    );
  }
}
