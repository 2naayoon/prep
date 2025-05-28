package poly;

public class Product {

  int price;
  int bonusPoint;

  public Product(int price) {
    this.price = price;
    this.bonusPoint = (int) (price / 10.0); // 보너스 점수 = 가격의 10%
  }
}
