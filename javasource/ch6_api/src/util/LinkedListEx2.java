package util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListEx2 {

  public static void main(String[] args) {
    // ArrayList 와 LinkedList 성능 차이 확인 : 시간 제기
    // 순차적으로 추가, 삭제 시 ArrayList 가 LinkedList 보다 빠르다
    // 중간 추가, 삭제 시 LinkedList 가 ArrayList 보다 빠르다

    ArrayList<String> aList = new ArrayList<>(2000000); // 추가될 데이터까지 생각하고 충분한 공간을 잡고 들어가야 효율이 좋음
    LinkedList<String> linkedList = new LinkedList<>();
    System.out.println("순차적 추가 비교");
    System.out.println("ArrayList : " + add1(aList)); // 68
    System.out.println("LinkedList : " + add1(linkedList)); //185
    System.out.println();
    System.out.println("중간 추가 비교");
    System.out.println("ArrayList : " + add2(aList)); //8376
    System.out.println("LinkedList : " + add2(linkedList)); // 18
    System.out.println();
    System.out.println("중간 삭제 비교");
    System.out.println("ArrayList : " + remove2(aList)); // 6996
    System.out.println("LinkedList : " + remove2(linkedList)); // 177
    System.out.println();
    System.out.println("순차적 삭제 비교");
    System.out.println("ArrayList : " + remove1(aList)); // 10
    System.out.println("LinkedList : " + remove1(linkedList)); // 33
  }

  // 순차적 추가 시간 확인
  public static long add1(List<String> list) {
    long start = System.currentTimeMillis(); // 현재 시간을 millisecond 단위로 돌려받음
    for (int i = 0; i < 1000000; i++) {
      list.add(i + ""); // 리스트에 순차적 추가
    }
    long end = System.currentTimeMillis(); // 끝나는 시간
    return end - start; // 걸린 시간
  }

  // 중간 추가 시간 확인
  public static long add2(List<String> list) {
    long start = System.currentTimeMillis();
    for (int i = 0; i < 10000; i++) {
      list.add(500, "X"); // 중간에 추가
    }
    long end = System.currentTimeMillis();
    return end - start;
  }

  // 순차적 삭제 시간 확인
  public static long remove1(List<String> list) {
    long start = System.currentTimeMillis();
    for (int i = list.size() - 1; i >= 0; i--) {
      list.remove(i);
    }
    long end = System.currentTimeMillis();
    return end - start;
  }

  // 중간 삭제 시간 확인
  public static long remove2(List<String> list) {
    long start = System.currentTimeMillis();
    for (int i = 0; i < 10000; i++) {
      list.remove(i);
    }
    long end = System.currentTimeMillis();
    return end - start;
  }
}
