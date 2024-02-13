package interfacetest;

public abstract class Calculator implements Calc {

  // times, divide 는 구현 x 여전히 추상메소드

  @Override
  public int add(int num1, int num2) {
    return num1 + num2;
  }

  @Override
  public int substract(int num1, int num2) {
    return num1 - num2;
  }
}
