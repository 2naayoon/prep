package Exam;

/* 선언된 생성자가 하나도 없다면
 * 컴파일러는 default 생성자를 만들어줌
 */

public class Circle {

  // 반지름(3.5) - double, radius

  private double radius;

  public Circle() {}

  public Circle(double radius) {
    this.radius = radius;
  }

  // 반지름 * 반지름 * 3.14 결과값 리턴
  double getArea() {
    return this.radius * this.radius * 3.14;
  }
}
