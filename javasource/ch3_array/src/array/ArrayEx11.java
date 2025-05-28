package array;

public class ArrayEx11 {

  public static void main(String[] args) {
    // String 배열
    String[] names = { "Kim", "Park", "Choi" };

    for (String str : names) {
      System.out.println(str);
    }

    // lenth(x) : 문자열의 x번째 문자

    for (int i = 0; i < names.length; i++) {
      String str = names[i];

      for (int j = 0; j < str.length(); j++) {
        char ch = str.charAt(j);
        System.out.printf("str.charAt(%d) : %c\n", j, ch);
      }
    }

    String src = "ABCED";

    // toCharArray() : 캐릭터 배열로 바뀜
    char[] chArr = src.toCharArray();
    System.out.println(chArr);
  }
}
