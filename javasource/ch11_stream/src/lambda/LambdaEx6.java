package lambda;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/*  메소드 참조
 *  람다식을 더욱 간결하게 사용
 *  람다식이 하나의 메소드만 호출하는 경우 사용
 *  클래스이름::메소드명
 */

public class LambdaEx6 {

  public static void main(String[] args) {
    // "5698" → 5698 + 30 → 5728 리턴
    // Function<String, Integer> f2 = s1 -> Integer.parseInt(s1);
    Function<String, Integer> f2 = Integer::parseInt;

    // 두 개의 문자열을 받아서 문자열이 동일한지 리턴
    // BiFunction<String, String, Boolean> f1 = (s1, s2) -> s1.equals(s2);
    BiFunction<String, String, Boolean> f1 = String::equals;

    // Supplier<Student> s = () -> new Student();
    Supplier<Student> s = Student::new;
  }
}
