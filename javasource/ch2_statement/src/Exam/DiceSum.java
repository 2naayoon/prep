package Exam;

public class DiceSum {

  public static void main(String[] args) {
    // 주사위 2개를 굴려 나오는 숫자를 (숫자1, 숫자2) 형태로 출력
    // 주사위 2개의 합이 5일 때 중단

    while (true) {
      int dice1 = (int) (Math.random() * 6) + 1;
      int dice2 = (int) (Math.random() * 6) + 1;
      System.out.printf("(%d, %d)\n", dice1, dice2);
      if (dice1 + dice2 == 5) break;
    }
    System.out.println("두 주사위의 합이 5입니다.");
  }
}
