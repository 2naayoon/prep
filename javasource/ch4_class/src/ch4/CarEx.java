package ch4;

public class CarEx {

  public static void main(String[] args) {
    // 객체 생성 : 클래스를 사용할 수 있는 상태로 만드는 개념
    Car car = new Car();

    car.company = "현대";
    car.model = "Genesis";
    car.maxSpeed = 180;
    car.backward();

    Car car2 = new Car();
    car2.company = "현대";
    car2.model = "Sonata";
    car2.maxSpeed = 190;
    car.forward();

    System.out.println(car.company);
    System.out.println(car.model);
    System.out.println(car.maxSpeed);
  }
}
