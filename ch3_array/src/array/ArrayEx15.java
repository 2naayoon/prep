package array;

public class ArrayEx15 {

  public static void main(String[] args) {
    int[][] score = {
      { 100, 95, 98 },
      { 20, 20, 18 },
      { 30, 30, 38 },
      { 40, 55, 45 },
      { 50, 48, 67 },
    };

    // 학생들의 점수 총점과 평균 출력
    // 번호 국어 영어 수학 총점 평균
    // 1  100  95  98  293  97

    int korTotal = 0, engTotal = 0, mathTotal = 0;

    System.out.println("번호 국어 영어 수학 총점 평균");
    System.out.println("===========================");

    for (int i = 0; i < score.length; i++) {
      System.out.printf("%3d", (i + 1));

      korTotal += score[i][0];
      engTotal += score[i][1];
      mathTotal += score[i][2];

      int sum = 0; // 개인별 총점
      float avg = 0.0f; // 개인별 평균

      for (int j = 0; j < score[i].length; j++) {
        System.out.printf("%5d", score[i][j]);
        sum += score[i][j];
        avg = sum / score[i].length;
      }
      System.out.printf("%5d %5.1f\n", sum, avg);
    }
    System.out.println("===========================");
    System.out.printf("총점 %3d %4d %4d\n", korTotal, engTotal, mathTotal);
  }
}
