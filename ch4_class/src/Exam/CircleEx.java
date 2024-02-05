package Exam;

public class CircleEx {

  public static void main(String[] args) {
    // Circle 객체 생성
    Circle circle = new Circle(3.5);
    // *circle.radius = 3.5;

    // 원의 면적 구하기 메소드 호출
    double result = circle.getArea(); // type은 메소드 type과 동일해야함
    System.out.println("원의 면적 " + result);
  }
}
