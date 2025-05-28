package Exam;

import java.util.Scanner;

public class AccountEx2 {

  public static void main(String[] args) {
    // Account 객체를 담을 배열 생성 3개
    Account accArr[] = new Account[3];

    // 입력
    Scanner sc = new Scanner(System.in);

    for (int i = 0; i < accArr.length; i++) {
      System.out.print("Input ACCOUNTNO : ");
      String accountNo = sc.nextLine();
      System.out.print("Input OWNER : ");
      String owner = sc.nextLine();
      System.out.print("Input BALANCE : ");
      int balance = Integer.parseInt(sc.nextLine());

      accArr[i] = new Account(accountNo, owner, balance);
    }

    // 확인
    System.out.println("=======================");
    System.out.println("AccountNo Owner Balance");
    System.out.println("=======================");

    for (Account account : accArr) {
      System.out.println(account);
    }
  }
}
