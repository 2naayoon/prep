package loop;

public class ForEx7 {

  public static void main(String[] args) {
    // 1~100까지 숫자 중에서 3의 배수만 더하기 (단, 9의 배수는 제외)
    int sum = 0;
    for (int i = 1; i < 101; i++) {
      if (i % 3 == 0 && i % 9 != 0) {
        sum += i;
      }
    }
    System.out.println("1~100 숫자 중에서 3의 배수의 합 " + sum);

    // 3의 배수와 5의 배수의 합
    sum = 0;
    for (int i = 1; i < 101; i++) {
      if (i % 3 == 0 || i % 5 == 0) {
        sum += i;
      }
    }
    System.out.println("1~100 숫자 중에서 3과 5의 배수의 합 " + sum);
  }
}
