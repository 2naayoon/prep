package ch4;

public class Tv {

  // 색상(검정, 흰색), 전원상태(on, off), 채널(6, 7, ...), 볼룸(13, 14, ...)
  // 크기(50, 46, ...)
  String color;
  int channel;
  boolean power;

  // 채널을 변경하는 메소드
  void channelUp() {
    channel++;
  }

  void channelDown() {
    channel--;
  }
  // 생성자
  // Tv(){}
}
