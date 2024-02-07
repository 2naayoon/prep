package ch4;

import java.util.Scanner;

public class StudentEx3 {

  public static void main(String[] args) {
    Student2 stuArr[] = new Student2[3];

    // 정보를 아는 경우
    // stuArr[0] = new Student2("st1014", "홍길동", "서울");
    // stuArr[1] = new Student2("st1015", "김유신", "부산");
    // stuArr[2] = new Student2("st1016", "성춘향", "대구");

    // // 첫번째 학생 휴대폰 번호 등록
    // stuArr[0].setHp("010-1234-5678");

    // // 세번째 학생 주소 변경
    // stuArr[2].setAddr("서울");

    // 학생 정보 입력 받기
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < stuArr.length; i++) {
      System.out.print("Input Id : ");
      String id = sc.nextLine();
      System.out.print("Input Name : ");
      String name = sc.nextLine();
      System.out.print("Input Addr : ");
      String addr = sc.nextLine();
      stuArr[i] = new Student2(id, name, addr);
    }

    // 학생 정보 확인
    for (Student2 student2 : stuArr) {
      System.out.println(student2);
    }
  }
}
