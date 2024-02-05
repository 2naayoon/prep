package ch4;

/*  main 없는 클래스
 */

public class Student2 {

  // 클래스 구성요소 (필수는 아님)
  //  - 멤버변수(= 인스턴스변수, property, 속성, 필드)
  //    - 학생 객체가 가져야 하는 특징
  //    - 학번(20241011), 이름(홍길동), 주소(서울시 종로구), 주민번호(071215-201123), 핸드폰(010-1234-5678)
  private String id; // 학번 저장
  private String name;
  private String addr;
  private String hp;

  //  - 멤버메소드(= 인스턴스메소드, 기능, 동작)
  //    속성을 변경시킬 수 있도록 메소드 작성
  //    - 메소드(함수) 작성 규칙
  //      리턴타입 메소드명(){}
  //      return type : 정수형, 실수형, 불린형, 문자형, String, 배열, void

  // 멤버변수 addr의 값을 변경
  // 리턴 값은 없음
  void changeAddr(String addr) {
    this.addr = addr; // this.addr = 'private String addr' / addr = 'String addr'
  }

  void changeHp(String hp) {
    this.hp = hp;
  }

  //  - 생성자(constructor) : 멤버변수의 값을 초기화 목적 (안하면 기본값)
  //    클래스를 객체로 생성할 때 필수로 필요
  //    여러개를 만들 수 있지만 ()안은 달라야함
  Student2() {}

  // source 자동생성
  public Student2(String id, String name, String addr) {
    this.id = id;
    this.name = name;
    this.addr = addr;
  }

  // private String id, ... 와는 다른 id, name, ...
  Student2(String id, String name, String addr, String hp) {
    this.id = id;
    this.name = name;
    this.addr = addr;
    this.hp = hp;
  }

  @Override
  public String toString() {
    return (
      "Student2 [id=" +
      id +
      ", name=" +
      name +
      ", addr=" +
      addr +
      ", hp=" +
      hp +
      "]"
    );
  }
}
