package Condition;

/*  Math.random() : 0.0 <= Math.random() < 1.0
 */

public class IfEx6 {

  public static void main(String[] args) {
    System.out.println((int) (Math.random() * 6)); // 0 ~ 5
    System.out.println((int) (Math.random() * 6) + 1); // 1 ~ 6

    int dice = (int) (Math.random() * 6) + 1;

    // 주사위 1 번 나옴
    if (dice == 1) {
      System.out.println("주사위 1번이 나옴");
    } else if (dice == 2) {
      System.out.println("주사위 2번이 나옴");
    } else if (dice == 3) {
      System.out.println("주사위 3번이 나옴");
    } else if (dice == 4) {
      System.out.println("주사위 4번이 나옴");
    } else if (dice == 5) {
      System.out.println("주사위 5번이 나옴");
    } else if (dice == 6) {
      System.out.println("주사위 6번이 나옴");
    }

    if (dice == 1) {} else if (dice == 2) {} else if (dice == 3) {} else if (
      dice == 4
    ) {} else if (dice == 5) {} else if (dice == 6) {}
    System.out.println("주사위 " + dice + "번이 나옴");
  }
}
