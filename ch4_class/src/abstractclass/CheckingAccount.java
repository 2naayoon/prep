package abstractclass;

/*  자식 클래스에서 부모의 미완성 부분을 무조건 완성해야 함
 */

public class CheckingAccount extends Account {

  @Override
  public void print() {}
}
