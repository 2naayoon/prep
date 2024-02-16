package util;

import java.util.Scanner;

/*  java.lang
 *  java.util
 *
 *  java.util.Scanner : 화면, 파일, 문자열과 같은 입력소스로부터 문자 데이터 읽어오기
 *  System.in : 키보드
 *  System.out : 화면
 */

public class ScannerEx {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] argArr = null;

    while (true) {
      String prompt = ">>";
      System.out.println(prompt);
      String input = sc.nextLine();

      input = input.trim();
      // 정규식 (Regular expression) = regExp : 특정한 규칙을 가진 문자열의 집합을 표현하는 형식
      argArr = input.split(" +"); // "공백+"" : 공백이 최소 1~무제한

      String command = argArr[0].trim();

      if ("".equals(command)) continue;

      command = command.toLowerCase();

      if (command.equals("q")) {
        System.exit(0); // while 문을 빠져나가기 위한 구문 필요 (강제 종료 코드)
      } else {
        for (int i = 0; i < argArr.length; i++) {
          System.out.println(argArr[i]);
        }
      }
    }
  }
}
