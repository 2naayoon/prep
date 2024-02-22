package thread;

public class UserMain {

  public static void main(String[] args) {
    Calculator calculator = new Calculator();

    Thread t1 = new User1(calculator);
    Thread t2 = new User2(calculator);

    t1.start();
    t2.start();
  }
}
