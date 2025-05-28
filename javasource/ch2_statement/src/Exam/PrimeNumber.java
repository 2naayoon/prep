package Exam;

public class PrimeNumber {

  public static void main(String[] args) {
    // 1~100 숫자 중에서 소수 찾아서 출력, 소수의 개수 출력
    // 소수 : 1보다 큰 자연수 중에서 1과 자기 자신만을 약수로 가지는 수
    // 2, 3, 5, 7, ...
    int count = 0, total = 0;
    for (int i = 2; i < 101; i++) {
      for (int j = 1; j <= i; j++) {
        if (i % j == 0) {
          count++; // 나누어 떨어지는 숫자 개수 세기 count = 1, 2, ...
        }
      }
      if (count == 2) {
        System.out.print(i + "\t");
        total++; // total = 1, 2, 3, ... (최종 토탈값 출력↓)
      }
      count = 0;
    }
    System.out.println();
    System.out.println("1~100 소수의 개수는 " + total);
    //  System.out.println("a:  " + count); 검증
  }
}
