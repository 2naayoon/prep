package Condition;

import java.util.Scanner;

public class IfEx4 {

  public static void main(String[] args) {
    // 점수가 >= 90 이면 A, >= 80 B, >= 70 C, >= 60 D, 나머지 F
    int score = 75;
    char grade;
    // char grade = ' '; 비어있는 문자 하나로 초기화 시 공백 필요
    if (score >= 90) {
      // System.out.println("등급은 A 입니다.");
      grade = 'A';
    } else if (score >= 80) {
      // System.out.println("등급은 B 입니다.");
      grade = 'B';
    } else if (score >= 70) {
      // System.out.println("등급은 C 입니다.");
      grade = 'C';
    } else if (score >= 60) {
      // System.out.println("등급은 D 입니다.");
      grade = 'D';
    } else {
      // System.out.println("등급은 F 입니다.");
      grade = 'F';
    }

    System.out.println("등급은 " + grade + " 입니다.");
    System.out.printf("등급은 %c 입니다\n", grade);
  }
}
