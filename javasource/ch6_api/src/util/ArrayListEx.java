package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*  컬렉션 프레임워크 : 데이터 군을 저장하는 클래스들을 표준화한 설계
 *   - Collection
 *     - Collection 인터페이스 상속 : List   Set
 *
 *   - Map
 *
 *     List(인터페이스) : 순서가 있는 데이터의 집합 (데이터의 중복 허용)
 *      - 구현 클래스 : ArrayList, LinkedList, Stack, Vector, ...
 *        : 고정크기 → 크기 변경이 필요하다면 내부적으로 알아서 처리해줌
 *
 *      → 배열과 동일한 개념
 *        : 고정크기 → 크기 변경 시 다른 배열 생성 후 옮겨야 함
 */

public class ArrayListEx {

  public static void main(String[] args) {
    // initial capacity : 10

    // 데이터를 담을 때 int 타입만 가능 - <> 안에 담을 데이터의 타입 결정
    // List<Integer> list = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>(20);
    list.add(75);
    list.add(68);
    list.add(35);
    list.add(45);
    list.add(55);
    list.add(65);

    // toString() 오버라이딩 여부
    System.out.println(list);

    // sort() : 정렬
    // 내림차순
    list.sort(Comparator.reverseOrder());
    System.out.println(list);
    // 오름차순
    list.sort(Comparator.naturalOrder());
    System.out.println(list);

    ArrayList<String> list2 = new ArrayList<>();
    // add() : append 개념 (뒤에 덧붙임)
    list2.add("Java");
    list2.add("JSP");
    list2.add("HTML");
    list2.add("CSS");
    list2.add("JAVASCRIPT");
    list2.add("PYTHON");

    // 메소드
    // size() : ArrayList 에 저장된 객체 개수
    System.out.println("size() " + list2.size()); // 배열로 할 시 : arr.length()

    // get() : 지정된 위치에 있는 객체 반환
    System.out.println("get() " + list2.get(3)); // 배열로 할 시 : arr[3]

    // indexOf() : 지정된 객체가 저장된 위치 반환
    System.out.println("indexOf() " + list2.indexOf("Java"));
    System.out.println("indexOf() " + list2.indexOf("JAVA"));

    // remove() : 지정된 객체 제거
    System.out.println("remove() " + list2.remove("Java"));
    System.out.println(list2);
    System.out.println("remove() " + list2.remove(2)); // 제거되는 객체를 보여줌
    System.out.println(list2);

    // ArraylList → 배열로 변환
    Object[] arr = list2.toArray();
    for (Object object : arr) {
      System.out.println(object);
    }

    // 배열 → ArrayList 변환
    // Arrays
    int[] arr2 = { 3, 5, 6, 7, 9 };
    Arrays.asList(arr2);
    List<int[]> list3 = Arrays.asList(arr2);

    // isEmpty() : ArrayList가 비어 있는지 확인
    System.out.println("isEmpty() " + list2.isEmpty());

    // set() : 특정 위치에 객체 추가 (중간대체)
    list2.set(1, "Oracle");
    System.out.println(list2);
  }
}
