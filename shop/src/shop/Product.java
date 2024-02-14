package shop;

public abstract class Product {

  private String pname;
  private int price;

  public Product(String pname, int price) {
    this.pname = pname;
    this.price = price;
  }

  public void printDetail() {
    System.out.println("모델명 : " + pname);
    System.out.println("가격 : " + price);
    printExtra();
  }

  public abstract void printExtra();

  public String getPname() {
    return pname;
  }

  public int getPrice() {
    return price;
  }
}
