package loop;

public class ForEx6 {

  public static void main(String[] args) {
    // 1~100까지 숫자 중에서 3의 배수만 더하기
    int sum = 0;
    for (int i = 1; i < 101; i++) {
      if (i % 3 == 0) {
        sum += i;
      }
    }
    System.out.println("1~100 숫자 중에서 3의 배수의 합 " + sum);

    // i++ → i = i + 1,    i += 3 == i = i + 3
    for (int i = 1; i < 101; i += 3) {
      System.out.println(i + "\t");
    }
    System.out.println();
  }
}
