package inheritance;

public class CaptionTvEx {

  public static void main(String[] args) {
    CaptionTv cTv = new CaptionTv(false, 10, false);

    // cTv.channel = 10;
    cTv.channelUp();
    System.out.println("현재 채널 " + cTv.getChannel());

    cTv.displayCaption("Hello World");
    cTv.caption = true;
    cTv.displayCaption("Hello World");
  }
}
