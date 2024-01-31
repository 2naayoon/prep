package exam;

import java.util.Scanner;

public class Degrees {

  public static void main(String[] args) {
    // 화씨온도 → 섭씨온도
    // T (° C) = (T (° F) -32) × 5/9

    Scanner sc = new Scanner(System.in);

    System.out.print("화씨온도 입력 ");
    int fahr = sc.nextInt();

    double cels = (double) (fahr - 32) * 5 / 9;
    // = double cels = (fahr - 32) * 5 / 9.0;
    System.out.println("섭씨온도 : " + cels);
  }
}
