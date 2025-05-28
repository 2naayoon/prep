package shop;

public class Customer {

  private String name;
  private PayType payType;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PayType getPayType() {
    return payType;
  }

  public void setPayType(PayType payType) {
    this.payType = payType;
  }
}
