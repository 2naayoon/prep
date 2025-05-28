package Exam;

public class TriangleEx {

  public static void main(String[] args) {
    Triangle triangle = new Triangle(4, 8);
    double area = triangle.getArea();
    System.out.println("삼각형 넓이 " + area);

    System.out.println("삼각형 넓이 : " + triangle.getArea());
  }
}
