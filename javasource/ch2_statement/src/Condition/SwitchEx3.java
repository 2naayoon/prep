package Condition;

import java.util.Scanner;

public class SwitchEx3 {

  public static void main(String[] args) {
    // 가위 : 1, 바위 : 2, 보 : 3

    // 컴퓨터의 숫자 결정
    int com = (int) (Math.random() * 3) + 1;

    // 사용자의 숫자 결정
    System.out.print("가위(1), 바위(2), 보(3) 중 하나를 입력하세요 >>> ");

    Scanner sc = new Scanner(System.in);
    int user = sc.nextInt();

    // com - user 시 이기는 조합
    // com : 2 user : 1 - 당신이 졌습니다   1    -2   1
    // com : 2 user : 3 - 당신이 이겼습니다 -1   -1   2
    // com : 2 user : 2 - 비겼습니다        0    0    0

    switch (com - user) {
      case 0:
        System.out.println("비겼습니다");
        break;
      case -1:
      case 2:
        System.out.println("당신이 이겼습니다");
        break;
      case 1:
      case -2:
        System.out.println("당신이 졌습니다");
    }
  }
}
