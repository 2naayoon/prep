package loop;

public class ForEx5 {

  public static void main(String[] args) {
    // *
    // **
    // ***
    // ****
    // *****

    for (int j = 1; j <= 1; j++) {
      System.out.print("*");
    }
    System.out.println();

    for (int j = 1; j <= 2; j++) {
      System.out.print("*");
    }
    System.out.println();

    for (int j = 1; j <= 3; j++) {
      System.out.print("*");
    }
    System.out.println();

    for (int j = 1; j <= 4; j++) {
      System.out.print("*");
    }
    System.out.println();

    for (int j = 1; j <= 5; j++) {
      System.out.print("*");
    }
    System.out.println();

    System.out.println("\n\n\n");

    for (int i = 0; i < 6; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
