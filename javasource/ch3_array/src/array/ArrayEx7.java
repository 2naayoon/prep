package array;

import java.util.Arrays;

public class ArrayEx7 {

  public static void main(String[] args) {
    int numArr[] = new int[10];

    for (int i = 0; i < numArr.length; i++) {
      numArr[i] = i;
    }
    System.out.println(Arrays.toString(numArr));

    //무작위로 숫자의 위치 변경
    for (int i = 0; i < 100; i++) {
      int pos = (int) (Math.random() * 10); // 0 ~ 9에서 임의의 숫자 추출

      int temp = numArr[0]; // 1번, 2번 변경 시 임시로 방을 하나 더 만들어 1번 방의 값을 넣어뒀다가 가져옴
      numArr[0] = numArr[pos];
      numArr[pos] = temp;
    }
    System.out.println(Arrays.toString(numArr));
  }
}
