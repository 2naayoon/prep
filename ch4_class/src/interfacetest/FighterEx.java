package interfacetest;

public class FighterEx {

  public static void main(String[] args) {
    Fighter f = new Fighter();

    //instanceof : ClassCastException 방지
    if (f instanceof Unit) {
      System.out.println("f는 Unit 클래스 자손");
    }

    if (f instanceof Fightable) {
      System.out.println("f는 Fightable 인터페이스 구현");
    }

    if (f instanceof Movable) {
      System.out.println("f는 Movable 인터페이스 구현");
    }

    if (f instanceof Attackable) {
      System.out.println("f는 Attackable 인터페이스 구현");
    }

    if (f instanceof Object) {
      System.out.println("f는 Object 클래스 자손");
    }
  }
}
