package poly;

/*  다형성(Polymorphism)
 *  부모 클래스 타입의 참조변수로 자손 클래스의 인스턴스 참조
 *  형변환 : 참조 변수의 타입을 변환하는 것으로 참조할 수 있는 범위를 조절
 *          자손타입 → 조상타입 (자동형변환)
 *          조상타입 → 자손타입 (강제형변환)
 */

public class ChildEx {

  public static void main(String[] args) {
    Child child = new Child();
    // child 로 접근 가능한 범위
    // field1, method1(), method2(), field2, method3()

    // 상속관계라면 - 왼쪽에 부모가 오는게 가능
    Parent child1 = new Child();
    // child1 으로 접근 가능한 범위
    // field1, method1(), method2()

    child1.method2(); // 오버라이딩 된 메소드라면 자식 메소드가 실행
  }
}
