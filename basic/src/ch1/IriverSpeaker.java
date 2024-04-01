package ch1;

public class IriverSpeaker implements Speaker {
    public IriverSpeaker() {
        System.out.println("BritzSpeaker 생성");
    }

    @Override
    public void volumeUp() {
        System.out.println("BritzSpeaker volume up");
    }

    @Override
    public void volumeDown() {
        System.out.println("BritzSpeaker volume down");
    }

}
