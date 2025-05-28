package shop;

public class SmartTv extends Product {

  private String resolution;

  public SmartTv(String pname, int price, String resolution) {
    super(pname, price);
    this.resolution = resolution;
  }

  @Override
  public void printExtra() {
    System.out.println("해상도 : " + resolution);
  }
}
