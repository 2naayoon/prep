package ch4;

import java.util.Scanner;

public class StudentEx4 {

  public static void main(String[] args) {
    Student3 stuArr[] = new Student3[3];

    // 클래스 배열 초기값 : null
    // System.out.println(stuArr[0]);
    // *Error : NullPointerException
    // System.out.println(stuArr[0].getId());

    // Scanner 라는 클래스 인스턴스 생성
    // System.in : 키보드
    // → 키보드에서 입력이 들어올 거다
    // sc.nextLine, ... : Scanner의 메소드를 불러 사용
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < stuArr.length; i++) {
      stuArr[i] = new Student3();

      // 아이디, 이름, 국어, 영어, 수학점수 입력 받아서 초기화
      System.out.print("Input Id : ");
      String id = sc.nextLine();
      System.out.print("Input Name : ");
      String name = sc.nextLine();
      System.out.print("Input Kor : ");
      int kor = Integer.parseInt(sc.nextLine()); // 문자 → 숫자 형변환 - "88" → 88
      System.out.print("Input Eng : ");
      int eng = Integer.parseInt(sc.nextLine());
      System.out.print("Input Math : ");
      int math = Integer.parseInt(sc.nextLine());

      stuArr[i].setId(id);
      stuArr[i].setName(name);
      stuArr[i].setKor(kor);
      stuArr[i].setEng(eng);
      stuArr[i].setMath(math);
    }

    //학생 정보 확인
    System.out.println("========================================");
    System.out.println("아이디   이름   국어 영어 수학 총점 평균");
    System.out.println("========================================");

    //  = Student3 student3 = stuArr[i];
    for (Student3 student3 : stuArr) {
      //   System.out.println(student3); → toString()
      int total = student3.getKor() + student3.getEng() + student3.getMath();

      System.out.printf(
        "%s   %s   %d   %d   %d   %d   %.2f\n",
        student3.getId(),
        student3.getName(),
        student3.getKor(),
        student3.getEng(),
        student3.getMath(),
        total,
        total / 3.0
      );
    }

    for (int i = 0; i < stuArr.length; i++) {
      int total = stuArr[i].getKor() + stuArr[i].getEng() + stuArr[i].getMath();

      System.out.printf(
        "%s   %s   %d   %d   %d   %d   %.2f\n",
        stuArr[i].getId(),
        stuArr[i].getName(),
        stuArr[i].getKor(),
        stuArr[i].getEng(),
        stuArr[i].getMath(),
        total,
        total / 3.0
      );
    }
  }
}
