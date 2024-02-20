package util;

import java.util.TreeSet;

/*  java.util.TreeSet (Set 인터페이스 구현 클래스)
 *   : 이진검색트리라는 자료구조의 형태로 데이터를 저장
 *   이진검색(탐색)트리 : 정렬, 검색, 범위검색에 높은 성능을 보이는 자료구조
 *   모든 노드는 최대 두 개의 자식노드를 가짐
 *   왼쪽 자식 노드의 값은 부모노드의 값보다 작고 오른쪽 노드의 값을 부모 노드의 값보다 커야 한다.
 *   노드의 추가,삭제에 시간이 걸린다.
 *   검색과 정렬에 유리
 *   중복된 값을 저장하지 못함
 */

public class TreeSetEx1 {

  public static void main(String[] args) {
    TreeSet<Integer> treeSet = new TreeSet<>();

    treeSet.add(80);
    treeSet.add(75);
    treeSet.add(95);
    treeSet.add(50);
    treeSet.add(35);
    treeSet.add(45);
    treeSet.add(65);
    treeSet.add(10);
    treeSet.add(100);

    System.out.println("가장 낮은 점수 " + treeSet.first());
    System.out.println("가장 높은 점수 " + treeSet.last());
    System.out.println("50보다 작은 값(전체) " + treeSet.headSet(50));
    System.out.println("50보다 큰 값(전체) " + treeSet.tailSet(50));
    System.out.println("50보다 큰 값 " + treeSet.lower(50));
    System.out.println("50보다 큰 값 " + treeSet.higher(50));

    while (!treeSet.isEmpty()) {
      // 내림차순으로 객체 가져오기
      System.out.println(treeSet.pollLast());
    }

    System.out.println();
    TreeSet<String> treeSet2 = new TreeSet<>();
    treeSet2.add("고양이");
    treeSet2.add("사자");
    treeSet2.add("타조");
    treeSet2.add("송아지");
    treeSet2.add("악어");
    treeSet2.add("다람쥐");
    treeSet2.add("양");

    // 문자열 정렬(a=>z, ㄱ=>ㅎ)
    // 영어(공백,숫자,대문자,소문자 순으로 정렬)
    System.out.println(treeSet2); // [고양이, 다람쥐, 사자, 송아지, 악어, 양, 타조]
    System.out.println("가장 낮은 값 " + treeSet2.first());
    System.out.println("가장 높은 값 " + treeSet2.last());
    System.out.println("사자보다 작은 값(전체) " + treeSet2.headSet("사자"));
    System.out.println("사자보다 큰 값(전체) " + treeSet2.tailSet("사자"));
    System.out.println("사자보다 큰 값 " + treeSet2.lower("사자"));
    System.out.println("사자보다 큰 값 " + treeSet2.higher("사자"));
  }
}
