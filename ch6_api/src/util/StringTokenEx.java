package util;

import java.util.StringTokenizer;

public class StringTokenEx {

  public static void main(String[] args) {
    String result = "100,200,300,400";
    String[] delimiter = result.split(",");
    for (String string : delimiter) {
      System.out.println(string);
    }

    StringTokenizer st = new StringTokenizer("100,200,300,400", ",");

    while (st.hasMoreTokens()) {
      System.out.println(st.nextToken());
    }
  }
}
