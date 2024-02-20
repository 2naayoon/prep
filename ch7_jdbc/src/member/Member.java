package member;

import lombok.Data;

/*  ~DTO : 생성자, getter, setter, toString
 *   - lombok : 자동 처리를 도와줌
 *     - @Data : toString, Getter, Setter, default 생성자, equals, hashcode 생성
 *     - 개별 생성 가능 : @Getter, @Setter, @ToString, @NoArgsConstructor (default 생성자), @AllArgsConstructor (멤버변수 모두 포함 생성자)
 */

@Data
public class Member {

  private String id;
  private String name;
  private String password;
}
