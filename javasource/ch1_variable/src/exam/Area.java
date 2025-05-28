package exam;

public class Area {

  public static void main(String[] args) {
    // 사다리꼴의 넙이를 구한 후 출력
    // (윗변 + 아랫변) * 높이 /2
    // 소수점 2자리까지 출력

    int a = 7;
    int b = 10;
    int h = 3; // int → double 로 바꾸면 나머지로 나눔
    // double area = (double) (a + b) * h / 2;   // 25.50
    double area = (double) (a + b) * h / 2.0; // 상수 → double 변경 : 소수점 붙이기

    System.out.printf("사다리꼴 넓이 : %.2f\n", area);
  }
}
