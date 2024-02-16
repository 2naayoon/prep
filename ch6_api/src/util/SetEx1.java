package util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*  java.util.Set : 중복을 허용하지 않음
 *                  저장 순서가 유지되지 않음
 *   - HashSet, TreeSet 구현
 */

public class SetEx1 {

  public static void main(String[] args) {
    Set<Integer> set = new HashSet<>();

    set.add(1);
    set.add(11);
    set.add(12);
    set.add(13);
    set.add(1);

    System.out.println("size() " + set.size());
    System.out.println("isEmpty() " + set.isEmpty());
    System.out.println("remove() " + set.remove(11));
    System.out.println(set);

    // 배열 전환
    Object[] arr = set.toArray();
    System.out.println(Arrays.toString(arr));
  }
}
