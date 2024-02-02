package loop;

public class BreakEx1 {

  public static void main(String[] args) {
    // break; → switch

    int sum = 0, i = 0;
    while (true) { // true → 무한루프 (빠져나오도록 break; 와 같이 사용)
      if (sum > 100) break; // 속해있는 반복문을 빠져나오도록 함
      ++i;
      sum += i;
    }
    System.out.printf("i = %d, sum = %d\n", i, sum);
  }
}
