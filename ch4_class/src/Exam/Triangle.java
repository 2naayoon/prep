package Exam;

public class Triangle {

  // 밑변(baseLine), 높이(height)
  private int baseLine;
  private int height;

  // 생성자 - default, 밑변, 높이 포함
  public Triangle() {}

  public Triangle(int baseLine, int height) {
    this.baseLine = baseLine;
    this.height = height;
  }
}
