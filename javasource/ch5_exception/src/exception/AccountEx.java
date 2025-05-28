package exception;

public class AccountEx {

  public static void main(String[] args) {
    Account account = new Account();

    account.setBalance(100000);

    try {
      account.withdraw(200000);
    } catch (Exception e) {
      //   System.out.println(e.getMessage());
      e.printStackTrace();
    }
  }
}
