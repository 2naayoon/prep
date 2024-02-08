package account;

// 은행 기본 기능 + 체크카드 기능 + 교통카드 기능
//  Account + CheckingAccount + ~
// 예금, 출금 → 부모(Account)
// 카드 사용금액 지불 → pay() 부모 CheckingAccount
// 교통비 지불한다

public class CheckingTrafficCardAccount extends CheckingAccount {

  private boolean hasTrafficCard;

  public CheckingTrafficCardAccount(
    String accountNo,
    String owner,
    int balance,
    String cardNo,
    boolean hasTrafficCard
  ) {
    super(accountNo, owner, balance, cardNo);
    this.hasTrafficCard = hasTrafficCard;
  }

  // payTrafficCard(), cardNo, amount, hasTrafficCard
  void payTrafficCard(String cardNo, int amount) throws Exception {
    if (!hasTrafficCard) {
      throw new Exception("교통카드 기능이 없습니다");
    }
    // 교통카드 기능이 존재한다면 cardNo, amount 확인
    pay(cardNo, amount);
  }
}
