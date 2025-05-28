package exception;

/*  사용자 정의 예외
 */

public class BalanceInsufficientException extends Exception {

  public BalanceInsufficientException() {
    super();
  }

  public BalanceInsufficientException(String message) {
    super(message);
  }
}
