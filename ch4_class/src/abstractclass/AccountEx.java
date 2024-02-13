package abstractclass;

public class AccountEx {

  public static void main(String[] args) {
    // *Error : Cannot instantiate the type Account - 인스턴스 생성 불가
    // Account account = new Account();

    Account account = new CheckingAccount();
  }
}
