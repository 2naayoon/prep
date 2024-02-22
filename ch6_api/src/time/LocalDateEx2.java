package time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/*  java.time.LocalDate
 *  java.time.LocalTime
 *  java.time.LocalDateTime
 */

public class LocalDateEx2 {

  public static void main(String[] args) {
    // 오늘 날짜
    LocalDate today = LocalDate.now();
    // 현재 날짜
    LocalTime now = LocalTime.now();

    System.out.println(today); // 2024-02-22
    System.out.println("윤년/평년 " + today.isLeapYear()); // 윤년이면 true
    System.out.println(now); // 15:00:45.443600700

    // 특정 날짜 지정
    LocalDate birth = LocalDate.of(1950, 11, 23);
    LocalTime birthTime = LocalTime.of(23, 11, 58);

    // 날짜 덧셈
    System.out.println(birth.plusDays(1));
    System.out.println(birth.minusDays(3));

    LocalDateTime date = LocalDateTime.now();
    System.out.println(date); // 2024-02-22T15:09:27.040776800 (ISO-8601)
    System.out.println(date.getHour());
    System.out.println(date.getMinute());
    System.out.println(date.getSecond());
    System.out.println(date.getYear());
    System.out.println(date.getMonth()); // FEBRUARY
    System.out.println(date.getMonth().getValue()); // 2
    System.out.println(date.getDayOfMonth()); // 22
    System.out.println();
  }
}
