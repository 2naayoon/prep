package ch4;

public class Tv {

  // private : 멤버변수에 붙여 사용, 외부클래스에서 직접 접근하는 것을 막음

  // 색상(검정, 흰색), 전원상태(on, off), 채널(6, 7, ...), 볼룸(13, 14, ...)
  // 크기(50, 46, ...)
  private String color;
  private int channel;
  private boolean power;

  // 채널을 변경하는 메소드
  // void : return 값이 없음

  void channelUp() {
    channel++;
  }

  void channelDown() {
    channel--;
  }

  // 생성자 오버로딩 : 하나의 클래스에 생성자를 여러개 만든다
  // Tv(){}

  public Tv() {}

  // this : 내가 가지고 있는, 내 것의
  public Tv(String color, int channel, boolean power) {
    this.color = color;
    this.channel = channel;
    this.power = power;
  }

  // Source action : Generate getters and setters
  public String getColor() {
    return color;
  }

  public void setColor(String color) { // 현재 컬러값 변경해주는 메소드
    this.color = color;
  }

  public int getChannel() {
    return channel;
  }

  public void setChannel(int channel) {
    this.channel = channel;
  }

  public boolean isPower() {
    return power;
  }

  public void setPower(boolean power) {
    this.power = power;
  }
}
