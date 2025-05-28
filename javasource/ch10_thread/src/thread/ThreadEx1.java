package thread;

public class ThreadEx1 {

  public static void main(String[] args) {
    // 싱글 쓰레드
    long start = System.currentTimeMillis();
    for (int i = 0; i < 300; i++) {
      System.out.printf("%s", new String("-"));
    }
    long end = System.currentTimeMillis();
    System.out.println("소요시간 1 : " + (end - start));
    for (int i = 0; i < 300; i++) {
      System.out.printf("%s", new String("|"));
    }
    System.out.println("소요시간 2 : " + (System.currentTimeMillis() - start));
  }
}
