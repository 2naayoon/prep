package stream;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lambda.Student;

public class StreamEx3 {

  public static void main(String[] args) {
    // 스트림 최종 연산 - 스트림의 요소를 소모해서 결과를 만들어 냄. 최종 연산 후에는 스트림 닫힘
    // forEach(), 통계 - count(), sum(), average(), max(), min()
    // collect()

    Stream<Student> stream = Stream.of(
      new Student("홍길동", 90, 80),
      new Student("송중기", 85, 70),
      new Student("김지원", 92, 81),
      new Student("정우성", 88, 87),
      new Student("송혜교", 68, 70)
    );

    // 수학점수 모으기
    // stream.map(Student::getMath).forEach(System.out::println);

    // 수학점수 모아서 리스트로 반환
    List<Integer> mathList = stream
      .map(Student::getMath)
      .collect(Collectors.toList());
    System.out.println(mathList);

    Stream<String> stream2 = Stream.of(
      "abc",
      "def",
      "apple",
      "melon",
      "text",
      "peek"
    );

    // 스트림 문자열을 대문자로 변경한 후 출력
    // stream2.map(String::toUpperCase).forEach(System.out::println);

    // 스트림 문자열을 대문자로 변경한 후 리스트로 돌려받기
    List<String> list = stream2
      .map(String::toUpperCase)
      .collect(Collectors.toList());
    System.out.println(list);

    IntStream stream3 = IntStream.rangeClosed(1, 10);
    // 짝수의 개수 출력
    long count = stream3.filter(num -> num % 2 == 0).count();
    System.out.println("짝수 개수 " + count);

    // 짝수 합계
    stream3 = IntStream.rangeClosed(1, 10);
    long sum = stream3.filter(num -> num % 2 == 0).sum();
    System.out.println("짝수 합 " + sum);

    // 전체 합계
    System.out.println("전체 합 " + IntStream.rangeClosed(1, 10).sum());

    // 평균
    // 리턴 타입 : Optional<T>, OptionalInt, OptionalDouble, OptionalLong
    // 최종 연산의 결과를 Optional 객체에 담아서 반환 → null을 체크하기 위한 if 문 사용 안 함
    // 리턴 값이 널인지 아닌지 판단하는 코드 사용 → NullPointerException 발생 막기 위해
    Optional<String> optional = Optional.of("abcde");
    System.out.println(optional.get());
    System.out.println(optional.isPresent());

    // 전체 평균
    System.out.println("전체 평균 " + IntStream.rangeClosed(1, 10).average());

    // 최대값
    System.out.println("최대값 " + IntStream.rangeClosed(1, 10).max());

    // 최소값
    System.out.println("최소값 " + IntStream.rangeClosed(1, 10).min());

    // 첫번째 값
    System.out.println("첫번째 값 " + IntStream.rangeClosed(1, 10).findFirst());
  }
}
