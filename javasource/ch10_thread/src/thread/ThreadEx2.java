package thread;

public class ThreadEx2 {

  static long start = 0;

  public static void main(String[] args) {
    // 멀티 쓰레드
    Thread t = new DashThread();
    t.start();

    start = System.currentTimeMillis();
    for (int i = 0; i < 300; i++) {
      System.out.printf("%s", new String("|"));
    }
    System.out.println("소요시간 1 : " + (System.currentTimeMillis() - start));
  }
}
