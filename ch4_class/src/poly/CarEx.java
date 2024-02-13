package poly;

public class CarEx {

  public static void main(String[] args) {
    Car car = null;

    FireEngine fe1 = new FireEngine();
    FireEngine fe2 = null;

    Ambulance ambulance = null;
    // 상속관계가 아닌 클래스는 형변환 불가
    // ambulance = fe1;

    // 자동 형변환
    // 자손타입 → 조상타입
    fe1.water();

    car = fe1; // Car car = new FireEngine();

    // cast : 강제 형변환
    // 같은 FireEngine에 들어있기 때문에 형변환 가능
    // 조상타입 → 자손타입
    fe2 = (FireEngine) car;
    fe2.water();

    Car car2 = new Car();
    // *Error : ClassCastException - Car와 FireEngine은 다르기 때문에 형변환해도 안 됨
    // FireEngine fe3 = (FireEngine) car2;
    // fe3.water();
  }
}
