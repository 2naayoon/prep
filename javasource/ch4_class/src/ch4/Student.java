package ch4;

/*  main 없는 클래스
 */

public class Student {

  // 클래스 구성요소 (필수는 아님)
  //  - 멤버변수(= 인스턴스변수, property, 속성, 필드)
  //    - 학생 객체가 가져야 하는 특징
  //    - 학번(20241011), 이름(홍길동), 주소(서울시 종로구), 주민번호(071215-201123), 핸드폰(010-1234-5678)
  String id; // 학번 저장
  String name;
  String addr;
  String hp;

  //  - 멤버메소드(= 인스턴스메소드, 기능, 동작)
  //    속성을 변경시킬 수 있도록 메소드 작성
  void changeAddr() {}

  void changeHp() {}

  //  - 생성자(constructor)
  // 클래스를 객체로 생성할 때 필수로 필요
  Student() {}
}
