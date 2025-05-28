package loop;

public class WhileEx2 {

  public static void main(String[] args) {
    // 구구단 출력
    // 3 * 1 =3
    for (int i = 1; i < 10; i++) {
      System.out.printf("%d * %d = %2d\n", 3, i, (3 * i));
    }

    int i = 1;
    while (i < 10) {
      System.out.printf("%d * %d = %2d\n", 3, i, (3 * i));
      i++;
    }
  }
}
