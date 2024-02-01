package Condition;

import java.util.Scanner;

public class IfEx3 {

  public static void main(String[] args) {
    // 점수 입력 받은 후 짝, 홀수 출력
    Scanner sc = new Scanner(System.in);

    System.out.print("점수 입력 ");
    int score = sc.nextInt();
    if (score % 2 == 0) {
      System.out.println("짝수");
    } else {
      System.out.println("홀수");
    }
  }
}
