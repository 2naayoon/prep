package Exam;

public class GoodsStockEx {

  public static void main(String[] args) {
    GoodsStock goodsstock = new GoodsStock("p1011", 150);
    int result = goodsstock.addStock(20);
    System.out.println("현재 재고수량 " + result);

    int result1 = goodsstock.subtrackStock(100);
    System.out.println("현재 재고수량 " + result1);
  }
}
