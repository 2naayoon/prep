package ch4;

public class FactorialEx {

  // f(n) = n * f(n-1) 단, f(1) = 1
  // 팩토리얼 메소드 만들기

  public static void main(String[] args) {
    System.out.println(factorial(4));
  }

  // 재귀호출 : 메소드 안에서 자기 자신을 호출
  static int factorial(int n) {
    int result = 0;
    if (n == 1) result = 1; else result = n * factorial(n - 1);
    return result;
  }
}
