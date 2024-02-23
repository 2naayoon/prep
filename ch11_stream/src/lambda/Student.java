package lambda;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor // default 생성자
@Getter
@ToString
@AllArgsConstructor
public class Student {

  private String name;
  private int math;
  private int kor;
}
