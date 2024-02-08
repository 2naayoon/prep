package account;

// 기존 은행 기능 + 체크카드 기능 추가

public class CheckingAccount extends Account {

  public String cardNo;

  public CheckingAccount(
    String accountNo,
    String owner,
    int balance,
    String cardNo
  ) {
    super(accountNo, owner, balance);
    this.cardNo = cardNo;
  }

  // pay(String cardNo, int amount)
  // cardNo 가 일치하는지 확인, 사용금액이 잔액보다 적은지 확인
  // 일치하지 않으면 지불 불가
  // 일치하고, 금액이 작으면 작액 - 사용금액

  void pay(String cardNo, int amount) throws Exception {
    if (!this.cardNo.equals(cardNo) || getBalance() < amount) {
      throw new Exception("지불불가"); // return하고 같은 효과 (if문에 걸리면 실행하고 돌아감)
    }
    // 잔액 = 잔액 - 사용액
    // setBalance(getBalance() - amount); // 잔액 변경 setter (getter로 잔액 갖고옴)
    withdraw(amount);
  }
}
