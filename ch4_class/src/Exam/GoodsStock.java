package Exam;

public class GoodsStock {

  // 속성 - 상품코드(p1011) goodscode, 재고수량(300) stockNum

  private String goodsCode;
  private int stockNum;

  // 생성자
  public GoodsStock() {} // {} = default 생성자

  public GoodsStock(String goodsCode, int stockNum) {
    this.goodsCode = goodsCode;
    this.stockNum = stockNum;
  }

  // 재고수량 추가 addStock(int amount)
  int addStock(int amount) {
    stockNum = stockNum + amount;
    return stockNum;
  }

  // 재고수량 감소 subtrackStock(int amount)
  int subtrackStock(int amount) {
    stockNum = stockNum - amount;
    return stockNum;
  }
}
