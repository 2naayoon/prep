package ch4;

public class SingletonEx {

  public static void main(String[] args) {
    // *Error : not visible
    // 보이지 않음 - private
    // Singleton singleton = new Singleton();

    // 선언된 객체 받기
    Singleton singleton = Singleton.getInstance();
    Singleton singleton2 = Singleton.getInstance();
    System.out.println(singleton == singleton2);
  }
}
