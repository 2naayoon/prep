package ch4;

public class MyMath {

  private long num1, num2;

  // 생성자
  public MyMath(long num1, long num2) {
    this.num1 = num1;
    this.num2 = num2;
  }

  // setter
  long add() {
    return num1 + num2;
  }

  long subtract() {
    return num1 - num2;
  }

  long multiply() {
    return num1 * num2;
  }

  long divide() {
    return num1 / num2;
  }

  static long add(long num1, long num2) {
    return num1 + num2;
  }

  static long subtract(long num1, long num2) {
    return num1 - num2;
  }

  static long multiply(long num1, long num2) {
    return num1 * num2;
  }

  static long divide(long num1, long num2) {
    return num1 / num2;
  }
}
