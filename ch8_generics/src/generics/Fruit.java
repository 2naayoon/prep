package generics;

/*  한 개의 파일에 여러 개의 클래스를 작성 가능
 *  public 키워드는 한 개의 클래스에만 붙임
 *  파일명은 public 클래스명으로 작성
 */

public class Fruit {

  @Override
  public String toString() {
    return "Fruit";
  }
}

class Apple extends Fruit {

  @Override
  public String toString() {
    return "Apple";
  }
}

class Grape extends Fruit {

  @Override
  public String toString() {
    return "Grape";
  }
}

class Toy {

  @Override
  public String toString() {
    return "Toy";
  }
}
