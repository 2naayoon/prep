// 패키지 문
package com.project.book;

// import 구문 : 다른 패키지에 있는 클래스 사용 시
// java가 제공하는 클래스 패키지
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
// import java.util.Date;
// import java.util.Scanner;

// util 밑의 클래스를 전부 포함
import java.util.*;

// 클래스 선언
public class Book {

  public static void main(String[] args) {
    // 현재 시스템 날짜 출력

    Date date = new Date();
    System.out.println(date.toString());
    System.out.println(date);

    // 원하는 형태로 출력
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    System.out.println(sdf.format(date));

    LocalDateTime dateTime = LocalDateTime.now();
    System.out.println(dateTime);

    Scanner sc = new Scanner(System.in);
  }
}
