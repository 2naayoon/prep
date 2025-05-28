package ch4;

public class TimeEx {

  public static void main(String[] args) {
    Time time = new Time();

    // 타임 객체에 인스턴스 2개 생성
    // 인스턴스 변수 : 인스턴스마다 다른 값 저장
    //                참조변수가 없을 때 가비지 컬렉터에 의해 자동 제거됨
    time.setHour(36);
    time.setMinute(20);
    time.setSecond(11.12f);
    System.out.println(time.getMinute());

    Time time2 = new Time();
    time2.setHour(16);
    time2.setMinute(38);
    time2.setSecond(13.12f);
  }
}
