package Exam;

public class Account {

  // 계좌번호(110-11-12345), 계좌주 이름(홍길동), 잔액(100000)
  private String accountNo;
  private String owner;
  private int balance;

  public Account() {}

  public Account(String accountNo, String name, int balance) {
    this.accountNo = accountNo;
    this.owner = owner;
    this.balance = balance;
  }

  // 예금하다
  int deposit(int amount) {
    balance += amount;
    return balance;
  }

  // 출금하다
  int withdraw(int amount) {
    balance -= amount;
    return balance;
  }
}
