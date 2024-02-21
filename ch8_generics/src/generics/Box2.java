package generics;

/*  Generics(지네릭스)
 *  다양한 타입의 객체들을 다루는 메소드나 컬렉션 클래스 컴파일 시 타입 체크를 해주는 기능
 *  장점
 *  타입 안정성 제공 / 타입체크와 형변환 생략 가능하므로 코드 간결
 */

public class Box2<T> {

  private T item;

  public T getItem() {
    return item;
  }

  public void setItem(T item) {
    this.item = item;
  }
}
