package lang;

/*  extends Object는 기본 (생략)
 */

public class Value {

  int value;

  public Value(int value) {
    this.value = value;
  }

  // 값 비교로 equals 재정의
  // Object obj = value2;
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Value) {
      Value v = (Value) obj;
      if (this.value == v.value) {
        return true;
      }
    }
    return false;
  }

  // 멤버 변수들의 값을 확인하는 용도로 재정의
  @Override
  public String toString() {
    return "Valuew [value =" + value + "]";
  }
}
