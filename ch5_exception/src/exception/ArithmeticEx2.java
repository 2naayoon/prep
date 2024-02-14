package exception;

/*  try ~ catch 작성
 *
 *  Object
 *
 *  Throwable
 *
 *  Exception
 *  RuntimeException / IoException
 */

public class ArithmeticEx2 {

  public static void main(String[] args) {
    // try {
    //   System.out.println(args[0]);  // *Error : ArrayIndexOutOfBoundsException
    //   System.out.println(3 / 0); // 실행되지 못하고 catch로 넘어감 // ArithmeticException: / by zero
    // } catch (Exception e) { // Exception 발생 시 바로 catch 실행
    //   e.printStackTrace();
    // }

    // try {
    //   System.out.println(args[0]);
    //   System.out.println(3 / 0);
    // } catch (ArrayIndexOutOfBoundsException e) {
    //   e.printStackTrace();
    // } catch (ArithmeticException e) {
    //   e.printStackTrace();
    // }

    // try {
    //   System.out.println(args[0]);
    //   System.out.println(3 / 0);
    // } catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
    //   e.printStackTrace();
    // }

    try {
      System.out.println(args[0]);
      System.out.println(3 / 0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
