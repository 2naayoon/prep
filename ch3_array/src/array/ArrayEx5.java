package array;

import java.util.Arrays;

public class ArrayEx5 {

  public static void main(String[] args) {
    // 배열명 arr 선언, 생성
    // 1, 2, 3, 4, 5
    int arr[] = { 1, 2, 3, 4, 5 };

    // 기존 배열의 arr 크기의 2배를 가지는 새로운 배열 생성 tmp
    int tmp[] = new int[arr.length * 2];

    // 배열 복사
    // 1) for문
    for (int i = 0; i < arr.length; i++) {
      tmp[i] = arr[i];
    }

    // 2) arraycopy : 매소드 이용
    // arraycopy (원본 배열명, 원본 배열 시작위치, 복사할 새 배열명, 새 배열의 붙여넣을 위치, 길이)
    int tmp2[] = new int[arr.length * 2];
    System.arraycopy(arr, 0, tmp2, 5, arr.length);
    System.out.println(Arrays.toString(tmp2));
  }
}
