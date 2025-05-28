package account;

// 은행 + 보너스 포인트 (예금시마다 포인트 제공)

public class BonusPointAccount extends Account {

  // 보너스포인트
  // 생성자

  private int bonuspoint;

  public BonusPointAccount(
    String accountNo,
    String owner,
    int balance,
    int bonuspoint
  ) {
    super(accountNo, owner, balance);
    this.bonuspoint = bonuspoint;
  }

  // 예금하다 오버라이딩
  // 예금 + 보너스포인트 적립
  @Override
  public void deposit(int amount) {
    super.deposit(amount);
    this.bonuspoint += (int) (amount * 0.001);
  }

  public int getBonuspoint() {
    return bonuspoint;
  }
}
