package stream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lambda.Student;

public class FromCollectionEx {

  static int sum = 0;

  public static void main(String[] args) {
    List<Student> students = Arrays.asList(
      new Student("홍길동", 90, 80),
      new Student("강호동", 80, 70),
      new Student("송진호", 70, 60)
    );

    // Stream 객체 변환
    Stream<Student> stream = students.stream();

    stream.forEach(student ->
      System.out.println(
        student.getName() + ": " + student.getKor() + ", " + student.getMath()
      )
    );
    // 처리해야 할 코드가 많은 경우 {} 사용
    // stream.forEach(student -> {});

    // java.nio.file : io 패키지를 향상
    Path path = Paths.get("c:\\temp");

    try (Stream<Path> stream2 = Files.list(path)) {
      // 파일명 출력
      stream2.forEach(file -> System.out.println(file.getFileName()));
    } catch (Exception e) {
      e.printStackTrace();
    }

    // 1~100까지의 합
    // int sum = 0;
    // for (int i = 1; i < 101; i++) {
    //   sum += i;
    // }
    // System.out.println("1~100 합 : " + sum);

    // 특정 범위의 정수를 스트림으로 생성
    IntStream.range(0, 10).forEach(i -> System.out.print(i + " "));
    System.out.println();
    IntStream.rangeClosed(0, 10).forEach(i -> System.out.println(i + " "));

    IntStream.rangeClosed(1, 100).forEach(i -> sum += i);
    System.out.println("sum = " + sum);
  }
}
