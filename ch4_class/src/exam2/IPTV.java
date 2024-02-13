package exam2;

public class IPTV extends ColorTv {

  private String ip;

  public IPTV(int size, int color, String ip) {
    super(size, color);
    this.ip = ip;
  }

  void printProperty() {
    System.out.println(
      "나의 IPTV는 " +
      ip +
      "주소의 " +
      getSize() +
      "인치 " +
      getColor() +
      "컬러"
    );
  }
}
