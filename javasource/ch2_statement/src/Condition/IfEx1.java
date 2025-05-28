package Condition;

/*  제어문 - 1) 조건문 2) 반복문
 *  1) 조건문 : 조건에 따라 다음 문장 수행 여부 결정
 *     if, switch
 */

public class IfEx1 {

  public static void main(String[] args) {
    // if (조건식) {
    //     조건식이 참일 때 수행될 문장들 나열
    // }
    // * 조건식은 true 혹은 false 가 나와야 함
    // {} : 수행될 문장이 한 줄이면 생략 가능

    int x = 0;

    if (x == 0) {
      System.out.println("x == 0");
    }

    if (x != 0) {
      System.out.println("x != 0");
    }

    if (!(x == 0)) {
      System.out.println("!(x == 0)");
    }

    if (!(x != 0)) System.out.println("!(x != 0)");
  }
}
