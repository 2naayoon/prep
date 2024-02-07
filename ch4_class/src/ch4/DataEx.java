package ch4;

public class DataEx {

  public static void main(String[] args) {
    Data d = new Data();
    // x 변수 초기화
    d.x = 15;
    // change(d.x);
    change2(d);
    System.out.println("x의 값 " + d.x);
  }

  // 메소드를 호출할 때 매개변수로 지정한 값을 메소드의 매개변수에 복사
  // 매개변수의 타입 - 1) 기본형 2) 참조형
  // 기본형 매개변수 : 변수의 값을 읽기만 가능 (값이 복사) - int, double, boolean, long, ...
  // 참조형 매개변수 : 변수의 값을 읽고 변경 가능 (주소를 공유) - 클래스, 배열

  // int x = 기본형 매개변수
  static void change(int x) {
    x = 20;
  }

  // 참조형 매개변수
  static void change2(Data obj) {
    obj.x = 20;
  }
}
