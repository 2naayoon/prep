package lambda;

public class AnimalEx {

  public static void main(String[] args) {
    // 인터페이스 활용 방법
    Animal animal = new Lion();
    animal.eat();

    // 람다식 활용 방법
    Animal animal2 = () -> System.out.println("풀을 먹는다");
    animal2.eat();
  }
}
