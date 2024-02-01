package Condition;

/*  switch : if ~ else if 처리 대체
 *  switch () {case _ : break; default: break}
 *  () = case _
 */

public class SwitchEx1 {

  public static void main(String[] args) {
    char ch1 = 'a';
    switch (ch1) {
      case 'a':
        System.out.println("a 입니다.");
        break;
      case 'b':
        System.out.println("b 입니다.");
        break;
      default:
        System.out.println("a 도 b 도 아닙니다.");
        break;
    }
  }
}
