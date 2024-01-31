package exam;

import java.util.Scanner;

public class Salary {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("월급 입력 ");
    int salary = sc.nextInt();

    //10년 저축 금액
    int deposit = salary * 12 * 10;
    System.out.println("10년 저축 금액 " + deposit);24
  }
}
