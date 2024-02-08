package inheritance;

public class CaptionTv extends Tv {

  // 컴파일러가 자동 생성 (숨어있음)
  // CaptionTv(){super();}

  boolean caption;

  public CaptionTv(boolean caption) {
    this.caption = caption;
  }

  public CaptionTv(boolean power, int channel, boolean caption) {
    super(power, channel); // 부모의 생성자 호출
    this.caption = caption; // 본인 것이기 때문에 불러서 초기화
  }

  void displayCaption(String text) {
    // if(caption != true) = if(!caption)
    // if(caption == true)
    if (caption) {
      System.out.println(text);
    }
  }
}
