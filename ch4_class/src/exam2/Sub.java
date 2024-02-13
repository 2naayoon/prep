package exam2;

public class Sub extends Calc {

  @Override
  void setValue(int a, int b) {}

  @Override
  int calculate() {
    return a - b;
  }
}
