package array;

import java.util.Arrays;

/*  알고리즘 - 정렬
 *            선택정렬, 버블정렬, 힙정렬
 *
 *
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
  }
}
