package account;

public class Account {

  private String accountNo;
  private String owner;
  private int balance;

  public Account(String accountNo, String owner, int balance) {
    this.accountNo = accountNo;
    this.owner = owner;
    this.balance = balance;
  }

  public String getAccountNo() {
    return accountNo;
  }

  public void setAccountNo(String accountNo) {
    this.accountNo = accountNo;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  public void deposit(int amount) {
    this.balance += amount;
  }

  public void withdraw(int amount) throws Exception {
    if (balance < amount) throw new Exception("잔액 확인");
    balance -= amount;
  }

  @Override
  public String toString() {
    return (
      "Account [accountNo=" +
      accountNo +
      ", owner=" +
      owner +
      ", balance=" +
      balance +
      "]"
    );
  }
}
