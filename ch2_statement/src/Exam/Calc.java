package Exam;

import java.util.Scanner;

public class Calc {

  public static void main(String[] args) {
    // 숫자, 문자 입력
    Scanner sc = new Scanner(System.in);
    System.out.print("+, -, *, /, % 중에서 하나를 입력하세요 >>> ");
    String op = sc.nextLine(); // + 입력 시 "+" 문자열로 입력
    // System.out.println("입력한 문자는 " + op);
    System.out.print("첫번째 숫자 >>> ");
    int num1 = sc.nextInt();
    // System.out.println(num1);
    System.out.print("두번째 숫자 >>> ");
    int num2 = sc.nextInt();

    int result = 0;
    switch (op) {
      case "+":
        result = num1 + num2;
        break;
      case "-":
        result = num1 - num2;
        break;
      case "*":
        result = num1 * num2;
        break;
      case "/":
        result = num1 / num2;
        break;
      case "%":
        result = num1 % num2;
        break;
    }
    System.out.printf("%d %s %d = %d\n", num1, op, num2, result);
  }
}
