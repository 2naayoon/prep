package exception;

public class FinallyEx {

  public static void main(String[] args) {
    try {
      System.out.println(args[0]);
      System.out.println("예외 발생 시 미처리");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // 예외의 발생 여부와 상관없이 무조건 실행되어야 하는 구문 작성
      System.out.println("무조건 실행");
    }
    // try {} finally {}
    // try {} catch (Exception e) {}
    // try {} catch (Exception e) {} finally {}
  }
}
