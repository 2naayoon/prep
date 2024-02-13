package exam2;

import java.util.Scanner;

public class CalcEx {

  public static void main(String[] args) {
    Calc calc = new Mul();
    Scanner scanner = new Scanner(System.in);
    System.out.print("Input Num1 : ");
    int a = scanner.nextInt();
    System.out.print("Input Num2 : ");
    int b = scanner.nextInt();
    System.out.print("Input operator : ");
    String x = scanner.nextLine();
    System.out.println(calc.calculate());
  }
}
