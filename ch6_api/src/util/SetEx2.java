package util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetEx2 {

  public static void main(String[] args) {
    Set<Integer> set = new HashSet<>();

    for (int i = 0; i < 6; i++) {
      // 1 ~ 45 사이의 숫자를 임의로 생성
      int num = (int) (Math.random() * 45) + 1;
      set.add(num);
    }
    System.out.println(set);

    // Set → List
    List<Integer> list = new ArrayList<>(set);
    list.sort(Comparator.naturalOrder());
    System.out.println(list);

    ArrayList<Integer> list2 = new ArrayList<>();
    list2.add(35);
    list2.add(45);
    list2.add(55);
    list2.add(55);

    Set<Integer> set2 = new HashSet<>(list2);
    System.out.println(set2);

    // 중복을 판별하기 위한 코드 필요
    // equals(), hashCode() 오버라이딩 해야 함
    // Member에는 중복 판별 코드 X 선언 필요
    Set<Member> set3 = new HashSet<>();

    Member member = new Member();
    member.setId("hong123");
    member.setName("홍길동");
    set3.add(member);

    member = new Member();
    member.setId("hong123");
    member.setName("홍길동");
    set3.add(member);

    for (Member mem : set3) {
      System.out.println(mem);
    }
  }
}
