package ch1;

public class SamsungTv implements Tv {

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
        System.out.println("LgTv - volume up");
    }

    @Override
    public void volumeDown() {
        System.out.println("LgTv - volume down");
    }

}
