package loop;

/*  continue : continue; 이후의 구문을 건너뛰게 함 (특정 구문을 실행하지 않도록 함)
 */

public class ContinueEx1 {

  public static void main(String[] args) {
    for (int i = 0; i < 11; i++) {
      if (i % 3 == 0) continue;
      System.out.println(i);
    }
    System.out.println("\n\n");

    for (int i = 0; i < 11; i++) {
      if (i % 2 != 0) continue;
      System.out.println(i);
    }
  }
}
