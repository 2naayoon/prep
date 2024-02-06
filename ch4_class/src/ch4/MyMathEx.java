package ch4;

public class MyMathEx {

  public static void main(String[] args) {
    MyMath math = new MyMath(15, 5);

    // non static 메소드 호출
    System.out.println("add() " + math.add());
    System.out.println("subtract() " + math.subtract());
    System.out.println("multiply() " + math.multiply());
    System.out.println("divide() " + math.divide());

    // static 메소드 호출
    System.out.println("static add() " + MyMath.add(300L, 200L));
    System.out.println("static subtract() " + MyMath.subtract(300L, 200L));
    System.out.println("static multiply() " + MyMath.multiply(300L, 200L));
    System.out.println("static divide() " + MyMath.divide(300L, 200L));
  }
}
