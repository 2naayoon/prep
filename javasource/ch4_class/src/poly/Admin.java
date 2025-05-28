package poly;

public class Admin extends Employee {

  public Admin(String name, String position) {
    super(name, position);
  }

  @Override
  public void work() {
    System.out.println(
      super.getPosition() + " : " + super.getName() + " 열심히 일을 합니다."
    );
  }
}
