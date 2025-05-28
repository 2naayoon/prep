package Exam;

import java.util.Scanner;

public class BankApp {

  // 클래스 변수
  static Scanner sc = new Scanner(System.in);
  static Account accArr[] = new Account[100];

  public static void main(String[] args) {
    boolean run = true;

    while (run) {
      System.out.println("-------------------------------------------------");
      System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
      System.out.println("-------------------------------------------------");
      System.out.print("메뉴 선택 >> ");

      int menu = Integer.parseInt(sc.nextLine());
      switch (menu) {
        case 1:
          createAccount();
          break;
        case 2:
          accountList();
          break;
        case 3:
          deposit();
          break;
        case 4:
          withdraw();
          break;
        case 5:
          System.out.println("종료");
          run = false;
          break;
      }
    }
  }

  static void createAccount() {
    System.out.print("Input ACCOUNTNO : ");
    String accountNo = sc.nextLine();
    System.out.print("Input OWNER : ");
    String owner = sc.nextLine();
    System.out.print("Input BALANCE : ");
    int balance = Integer.parseInt(sc.nextLine());

    for (int i = 0; i < accArr.length; i++) {
      if (accArr[i] == null) {
        accArr[i] = new Account(accountNo, owner, balance);
        System.out.println("계좌가 생성되었습니다.");
        break;
      }
    }
  }

  static void accountList() {
    // 생성된 계좌목록 보여주기
    for (Account account : accArr) {
      if (account != null) {
        System.out.println(account);
      }
    }
  }

  // 예금하다
  // 배열에서 입력받은 계좌번호와 일치한 배열요소 찾기 (계좌번호)
  // 찾은 요소의 잔액 + 예금액
  static void deposit() {
    System.out.print("Input ACCOUNTNO : ");
    String accountNo = sc.nextLine();
    System.out.print("예금액 입력 : ");
    int amount = Integer.parseInt(sc.nextLine());

    Account account = findAccount(accountNo);

    if (account != null) {
      System.out.println("잔액 : " + account.deposit(amount));
    }
  }

  static void withdraw() {
    System.out.print("Input ACCOUNTNO : ");
    String accountNo = sc.nextLine();
    System.out.print("출금액 입력 : ");
    int amount = Integer.parseInt(sc.nextLine());

    Account account = findAccount(accountNo);

    if (account != null) {
      System.out.println("잔액 : " + account.withdraw(amount));
    }
  }

  // 배열에서 특정 요소 찾는 메소드
  static Account findAccount(String accountNo) {
    for (Account account : accArr) {
      if (account != null) {
        if (account.getAccountNo().equals(accountNo)) {
          return account; // 찾은 배열 요소를 갖고 deposit, withdraw로 돌아가!
        }
        break;
      }
    }
    return null; // 참조형 - 줄 값이 없으면 return null;
  }
}
