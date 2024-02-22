package thread;

public class Calculator {

  private int memory;

  public int getMemory() {
    return memory;
  }

  // 쓰레드 진행하는 동안 다른 쓰레드는 멈춰 있음 → 값의 침해 X
  public /*synchronized*/void setMemory(int memory) {
    // 동기화 블럭
    synchronized (this) {
      this.memory = memory;

      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(
        Thread.currentThread().getName() + " : " + this.memory
      );
    }
  }
}
