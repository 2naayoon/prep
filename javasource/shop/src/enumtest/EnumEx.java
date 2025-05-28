package enumtest;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class EnumEx {

  public static void main(String[] args) {
    Week today = null;
    // 오늘 날짜 가져오기
    LocalDate now = LocalDate.now();
    System.out.println(now);

    // 오늘 날짜에 맞는 숫자 리턴 (1(월요일) ~ 7(일요일))
    DayOfWeek week = now.getDayOfWeek();

    switch (week.getValue()) {
      case 1:
        today = Week.MONDAY;
        break;
      case 2:
        today = Week.TUESDAY;
        break;
      case 3:
        today = Week.WEDNESDAY;
        break;
      case 4:
        today = Week.THURSDAY;
        break;
      case 5:
        today = Week.FRIDAY;
        break;
      case 6:
        today = Week.SATURDAY;
        break;
      case 7:
        today = Week.SUNDAY;
        break;
      default:
        break;
    }

    System.out.println("오늘 요일 : " + today);
    if (today == Week.SUNDAY) {
      System.out.println("휴식을 취합니다.");
    } else {
      System.out.println("열심히 자바 공부를 합니다.");
    }
  }
}
