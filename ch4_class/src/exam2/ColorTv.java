package exam2;

public class ColorTv extends TV {

  private int color;

  public ColorTv(int size, int color) {
    super(size);
    this.color = color;
  }

  public int getColor() {
    return color;
  }

  void printProperty() {
    System.out.println(getSize() + "인치 " + color + "컬러");
  }
}
