package array;

import java.util.Arrays;

/*  알고리즘 - 정렬
 *            선택정렬, 버블정렬, 힙정렬
 */

public class ArrayEx10 {

  public static void main(String[] args) {
    int arr[] = { 25, 85, 55, 65, 5, 3 };

    int min = arr[0];
    for (int i = 0; i < arr.length; i++) {
      if (min > arr[i]) {
        min = arr[i];
        int temp = arr[0];
        arr[0] = arr[min];
        arr[min] = temp;
      }
    }
    System.out.println(Arrays.toString(arr));

    int i = 0, j = 0;
    for (i = 0; i < arr.length; i++) {
      int min_idx = i;

      //최솟값을 갖고있는 인덱스 찾기
      for (j = 1; j < arr.length; j++) {
        if (arr[j] < arr[min_idx]) {
          min_idx = j;
        }
      }
      int temp = arr[i];
      arr[i] = arr[min_idx];
      arr[min_idx] = temp;
    }
    System.out.println(Arrays.toString(arr));

    // 자바가 제공하는 sort (오름차순)
    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
