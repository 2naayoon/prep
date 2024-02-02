package loop;

public class BreakEx2 {

  public static void main(String[] args) {
    // break; → switch

    // 주사위를 굴려서 6이 나올 때 반복문 종료
    int i = 0;
    while (true) {
      i = (int) (Math.random() * 6) + 1;
      System.out.println(i);
      if (i == 6) break;
    }
    System.out.println("종료");
  }
}
