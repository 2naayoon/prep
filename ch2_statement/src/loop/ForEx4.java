package loop;

public class ForEx4 {

  public static void main(String[] args) {
    // 행과 열이 있는 형태는 무조건 for문 중첩
    // 5행 10열의 별(*)
    // **********
    // **********
    // **********
    // **********
    // **********

    // 1) int i = 1;
    // 2) i < 6;
    // 3) int j = 1;
    // 4) j < 11;
    // 5) System.out.print("*");
    // 6) j++
    // 7) j < 11
    // 8) System.out.print("*");
    // 9) j++
    // .............
    // 10) j == 11 안쪽 for 문 종료
    // 11) System.out.println();
    // 12) 바깥쪽 for i++
    // 13) i < 6
    // 14) 안쪽 for 10번 수행
    // 중첩된 for문은 바깥쪽 for문이 참일 때까지 반복 수행
    for (int i = 1; i < 6; i++) {
      for (int j = 1; j < 11; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
