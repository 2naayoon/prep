package thread;

public class BigLetters2 {

  public static void main(String[] args) {
    Thread t = new SmallLetters2();
    t.start();

    for (char ch = 'A'; ch <= 'Z'; ch++) {
      System.out.println(ch + " ");
    }
  }
}
