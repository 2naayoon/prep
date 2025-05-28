package operator;

public class ConditionEx1 {

  public static void main(String[] args) {
    // 조건(삼항) 연산자 : 조건식? 식1 : 식2;
    // x가 y보다 크면 x 값을 변수에 담고, 그게 아니면 y 값을 담기
    int x = 5, y = 3;
    int result = (x > y) ? x : y;
    System.out.printf("result = %d\n", result);

    // 점수가 90 이상이면 A, F
    int score = 80;
    System.out.println(score >= 90 ? 'A' : 'F');

    // 점수가 90 이상이면 A, 80 이상이면 B, 나머지는 F
    System.out.println(score >= 90 ? 'A' : (score >= 80 ? 'B' : 'F'));
  }
}
