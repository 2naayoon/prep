package ch4;

public class Person {

  // 멤버변수에 final 이 붙은 경우
  // 반드시 초기화(선언, 생성자 시) 해야 함
  // 수정불가 (getters, setters x)
  // 상수 개념

  // privat final String nation = "Korea";
  // public Person(String name, String nation){~}

  // 클래스에 final 이 붙은 경우 : 상속 금지
  // 메소드에 final 이 붙은 경우 : 오버라이딩 금지

  private String name;
  private final String nation;

  // 객체끼리 공유하는 상수
  // 상수는 대문자로 표현
  private static final double Pi = 3.141592; // final, static 위치 변경 가능

  // getter 한 개만 만들시 getNation() 자동완성
  public static double getPi() {
    return Pi;
  }

  public Person(String name, String nation) {
    this.name = name;
    this.nation = nation;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Person [name=" + name + "]";
  }
}
