package thread;

public class BigLetters3 {

  public static void main(String[] args) {
    // 익명 구현 방식 : 1회성이라면 굳이 클래스를 만들지 않고 작성 가능
    Runnable r = new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 101; i++) {
          System.out.print(i + " ");
        }
      }
    };
    Thread t = new Thread(r);
    t.start(); // thread 실행

    Thread t2 = new SmallLetters2();
    t2.start();

    for (char ch = 'A'; ch <= 'Z'; ch++) {
      System.out.println(ch + " ");
    }
  }
}
