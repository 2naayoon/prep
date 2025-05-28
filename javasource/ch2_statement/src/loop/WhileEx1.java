package loop;

public class WhileEx1 {

  public static void main(String[] args) {
    for (int i = 0; i < 5; i++) {
      System.out.println("I can do it.");
    }

    int i = 0;
    while (i < 5) {
      System.out.println("I cant do it.");
      i++;
    }

    // 1~10 의 합계 구하기
    int sum = 0;
    for (int i0 = 1; i0 < 11; i0++) {
      sum += i0; // sum = sum + i0;
    }
    System.out.println("1 ~ 10 까지 합 " + sum);

    sum = 0;
    i = 1;
    while (i < 11) {
      sum += i;
      i++;
    }
    System.out.println("1 ~ 10 까지 합 " + sum);
  }
}
