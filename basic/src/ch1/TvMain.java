package ch1;

public class TvMain {
    public static void main(String[] args) {
        // tv 객체 생성 (범위 차이 존재)
        // 1. 기본 객체 생성 방법
        // SamsungTv samsungTv = new SamsungTv();

        // 2. 왼쪽 부모 = 오른쪽 자식 방법 (조금 더 선호)

        LgTv tv = new LgTv();
        // Tv tv = new LgTv();
        tv.setSpeaker(new BritzSpeaker());

        tv.powerOn();
        tv.volumeUp();
        tv.volumeDown();
        tv.PowerOff();

    }
}
