package inheritance;

/*  패키지(=폴더) : 클래스 묶음
 *                 모든 클래스는 반드시 하나의 패키지에 속해야 한다
 *                 점을 구분자로 하여 계층 구조로 구성
 */

/*  상속 관계 : extends (자식이 더 큼 Child > Parent)
 *             기존의 클래스를 재사용하여 새로운 클래스 작성
 *             적은 양의 코드로 새로운 클래스를 작성할 수 있고 코드를 공통적으로
 *             관리하기 때문에 코드의 추가 및 변경이 용이함 (코드의 재사용성 증가 및 중복 제거)
 *             부모가 가진 대부분의 값을 물려받음
 *             자손 클래스는 조상 클래스의 모든 멤버를 상속 받음
 *             생성자와 초기화 블럭은 상속되지 않음
 *             단일 상속만 가능 (한 번에 하나만)
 *             모든 클래스는 Object 클래스를 상속받음 (명시하진 않지만 default값)
 *
 *      - 오버라이딩 : 부모의 메소드와 동일한 시그니처(리턴타입, 메소드명, 인자)를 가진다 (상속에서만 나옴)
 *      - 오버라이딩 메소드는 부모보다 접근 제한자를 좁게 가져서는 안됨
 *      - 새로운 예외를 throws 할 수 없음
 *      - 부모 메소드 재정의 (부모가 넘겨주는 메소드를 조금 바꿔서 쓰고 싶을 때 사용)
 *
 *  Parent : 부모 클래스, 상위(super) 클래스, base 클래스
 *  Child : 자식 클래스, 하위(sub) 클래스, 파생 클래스
 */

public class Child extends Parent {

  private String name = "성춘향";

  // default 일 때도 super 항상 포함 (숨어있음)
  // 생성자를 만들 때 super 라는 구문이 항상 들어오고 부모의 인스턴스도 생성
  // Child(){
  //   super();
  // }

  public Child(int age) {
    // 부모의 생성자 호출 (자신의 인스턴스 생성 전 부모의 인스턴스 생성)
    super(age);
  }

  void play() {
    System.out.println("play!!!");
  }

  // 어노테이션
  // 오버라이딩 (= 오버라이드 메소드) : 부모와 완전 똑같음
  // @Override
  // public void print() {
  //   super.print();
  // }
  @Override
  public void print() {
    super.print(); // 가려진 부모의 메소드도 호출
    System.out.println("내 이름은 " + name + " 입니다.");
  }
}
