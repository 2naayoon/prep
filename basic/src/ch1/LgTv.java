package ch1;

public class LgTv implements Tv {

    // *Error : NullPointerException: Cannot invoke "ch1.BritzSpeaker.volumeUp()"
    // because
    // "this.britzSpeaker" is null
    // 객체 생성하고 사용 가능
    // 멤버 변수 초기화
    // - 기본형 : int, long, boolean, ...
    // 1) 정수타입 : 0
    // 2) 불린타입 : false
    // 3) 실수타입 : 0.0
    // - 참조형(대문자 시작, 배열) : null 로 초기화

    // 브리츠스피커의 스피커 사용
    private Speaker speaker; // = private BritzSpeaker britzSpeaker = null;

    // 멤버 변수 초기화 방법
    // 1) setter 메서드 이용
    // 2) 생성자 이용

    public LgTv() {
    }

    public LgTv(Speaker speaker) {
        this.speaker = speaker;
    }

    @Override
    public void powerOn() {
        System.out.println("LgTv - 전원 On");
    }

    @Override
    public void PowerOff() {
        System.out.println("LgTv - 전원 Off");
    }

    @Override
    public void volumeUp() {
        // System.out.println("LgTv - volume up");
        speaker.volumeUp();
    }

    @Override
    public void volumeDown() {
        System.out.println("LgTv - volume down");
        speaker.volumeDown();
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }
}
