package ch4;

public class Singleton {

  private static Singleton singleton = new Singleton();

  // 외부에서 사용 불가 : 해당 클래스를 벗어난 모든 클래스
  private Singleton() {}

  static Singleton getInstance() {
    if (singleton == null) {
      singleton = new Singleton();
    }
    return singleton;
  }
}
