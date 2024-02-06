package Exam;

public class AccountEx {

  public static void main(String[] args) {
    Account account = new Account("110-11-12345", "홍길동", 100000);

    // 입금
    account.deposit(20000);

    // 인출
    int balance = account.withdraw(60000);

    System.out.println("현재 잔액 " + balance);
  }
}
