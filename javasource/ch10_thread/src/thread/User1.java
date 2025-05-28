package thread;

public class User1 extends Thread {

  private Calculator cal;

  public User1(Calculator cal) {
    this.cal = cal;
    super.setName("User 1");
  }

  @Override
  public void run() {
    cal.setMemory(100);
  }
}
