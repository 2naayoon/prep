package ch4;

public class Card {

  // 인스턴스 변수
  private String kind; // 무늬 (하트, 클로버, ...)
  private int number; // 숫자

  // 값이 일정할 때 인스턴스 변수 선언 x
  // 클래스 변수 : 공유 (static 사용)
  //              클래스가 로딩될 때 생성되고 프로그램이 종료될 때 소멸
  static int width; // 카드의 크기
  static int height;

  public Card(String kind, int number) {
    this.kind = kind;
    this.number = number;
  }
}
