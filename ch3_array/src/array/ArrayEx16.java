package array;

public class ArrayEx16 {

  public static void main(String[] args) {
    // 고정 배열
    int[][] score = new int[5][3];

    //가변 배열
    int[][] score2 = new int[3][];
    score2[0] = new int[3];
    score2[1] = new int[4];
    score2[2] = new int[5];

    int[][] score3 = {
      { 100, 100, 95 },
      { 85, 78 },
      { 99, 86, 35 },
      { 15, 35, 45, 55, 65 },
    };
  }
}
