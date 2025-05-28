package poly;

public class Ceo extends Employee {

  public Ceo(String name, String position) {
    super(name, position);
  }

  @Override
  public void work() {
    System.out.println(super.getPosition() + " : " + super.getName());
  }
}
