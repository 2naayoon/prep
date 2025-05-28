package interfacetest;

/*  interface
 *  모든 멤버 변수는 public static final 이어야 함
 *  모든 멤버 메소드는 public abstract 임 (abstract 생략 가능)
 *  추상화가 높은 상태
 *  {}(body)를 가진 메소드는 static, default 만 가능 (1.8 버전 추가)
 *  여러 개 구현 가능
 *  public class Bonus implements Account, CheckingAccount
 *  public class Bonus extends CreditLine implements Account, CheckingAccount
 */

public interface Account {
  // *Error : accountNo; only public, static & final are permitted
  // private String accountNo; - 멤버변수 선언 불가
  public static final int SPADE = 4; // 상수만 가능

  // *Error : Abstract methods do not specify a body
  // interface 메소드는 무조건 추상 (abstract 생략 가능)
  public void deposit();

  // {}가 들어올 수 있는 경우 : static, default 이 붙은 경우
  static void getCardKind() {}

  default void getCard() {}
}
