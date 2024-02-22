package thread;

public class SmallLetters implements Runnable {

  @Override
  public void run() {
    // 쓰레드로 실행할 코드 작성
    for (char ch = 'a'; ch <= 'z'; ch++) {
      System.out.println(ch + " ");
    }
  }
}
