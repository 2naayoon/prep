package abstractclass;

public abstract class Car {

  String color;
  int door;

  // 바꿀 것은 추상으로 만들어서 내린다
  // 자식 클래스들이 다 다르게 구현하기 때문에 abstract로 만듦
  abstract void drive();

  void stop() {
    System.out.println("stop!!!");
  }
}
