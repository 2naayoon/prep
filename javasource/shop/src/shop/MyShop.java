package shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*  List 변형
 *  타입 : 객체 (Integer, String, Member, ...)
 *  List<타입> list = new ArrayList<>();
 *  ArrayList<타입> list = new ArrayList<>();
 */

public class MyShop implements IShop {

  // private Customer customers[] = new Customer[5];
  List<Customer> customers = new ArrayList<>(10); // 왼쪽 부모 객체

  // private Product products[] = new Product[5];
  List<Product> products = new ArrayList<>(10);

  private String title;
  private int customerNo;

  // 장바구니
  // private Product carts[] = new Product[5]; // CellPhone과 SmartTv 둘 다 담아야 하기 때문에 부모로 만듦
  List<Product> carts = new ArrayList<>(10);

  Scanner sc = new Scanner(System.in);

  @Override
  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public void genUser() {
    // 고객 생성
    Customer customer = new Customer();
    customer.setName("홍길동");
    customer.setPayType(PayType.CARD);
    customers.add(customer);

    customer = new Customer();
    customer.setName("성춘향");
    customer.setPayType(PayType.CARD);
    customers.add(customer);

    customer = new Customer();
    customer.setName("이순신");
    customer.setPayType(PayType.CASH);
    customers.add(customer);

    customer = new Customer();
    customer.setName("정우성");
    customer.setPayType(PayType.CARD);
    customers.add(customer);

    customer = new Customer();
    customer.setName("이정재");
    customer.setPayType(PayType.CASH);
    customers.add(customer);
  }

  @Override
  public void genProduct() {
    // 제품 생성
    Product phone = new CellPhone("갤럭시노트", 50000, "U+");
    products.add(phone);

    phone = new CellPhone("Z플립", 50000, "SKT");
    products.add(phone);

    phone = new CellPhone("폴드", 60000, "KT");
    products.add(phone);

    SmartTv tv = new SmartTv("삼성 KQ75", 80000, "Ultra");
    products.add(tv);

    tv = new SmartTv("LG OLED", 100000, "Ultra");
    products.add(tv);
  }

  @Override
  public void start() {
    System.out.println(title + " : 메인화면 - 계정선택");
    System.out.println("=============================");
    for (int i = 0; i < customers.size(); i++) {
      System.out.printf(
        "[%d] %s(%s)\n",
        i,
        customers.get(i).getName(),
        customers.get(i).getPayType()
      );
    }
    System.out.println("[x] 종료");

    // 사용자에게 고객 번호 입력받기
    System.out.print("고객 번호 >> ");
    String cNo = sc.nextLine();
    System.out.println("### " + cNo + " 고객 선택 ###");

    customerNo = Integer.parseInt(cNo);

    if (cNo.equals("x")) {
      System.exit(0);
    } else { // 0 ~ 4번
      productList();
    }
  }

  // 상품 목록 출력
  public void productList() {
    System.out.println("\n");
    System.out.println(title + " : 상품목록 - 상품선택");
    System.out.println("=============================");
    for (int i = 0; i < products.size(); i++) {
      System.out.printf("[%d]", i);
      products.get(i).printDetail();
    }
    System.out.println("[h] 메인 화면");
    System.out.println("[c] 체크 화면");

    System.out.print("상품 번호 >> ");
    String menu = sc.nextLine(); // 0~4, x

    switch (menu) {
      case "h":
        start();
        break;
      case "c":
        checkOut();
        break;
      default: // 0~4에 해당하는 제품을 장바구니에 추가
        carts.add(products.get(Integer.parseInt(menu)));
        productList();
    }
  }

  public void checkOut() {
    System.out.println("\n");
    System.out.println(title + " : 체크아웃");
    System.out.println("================================");

    int i = 0, total = 0;
    for (Product product : carts) {
      if (product != null) {
        System.out.printf(
          "[%d] %s %d\n",
          i++,
          product.getPname(),
          product.getPrice()
        );
        total += product.getPrice();
      }
    }
    System.out.println("================================");
    System.out.println("합계 : " + total);
    System.out.println("결제방법 : " + customers.get(customerNo).getPayType());
    System.out.println("[p] 이전");
    System.out.println("[q] 결제");
    String menu = sc.nextLine();

    switch (menu) {
      case "p":
        productList();
        break;
      case "q":
        System.out.println("결제가 완료 되었습니다. 종료합니다.");
        System.exit(0);
        break;
      default:
        break;
    }
  }
}
