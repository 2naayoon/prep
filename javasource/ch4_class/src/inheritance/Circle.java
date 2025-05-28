package inheritance;

/*  상속 관계 (isa)
 *  원(Circle)은 점(Point)이다 → Circle is a Point
 */

// public class Circle extends Point{

//  int x; // 원점의 x 좌표
//  int y; // 원점의 y 좌표
//  int r; // 반지름
// }

/*  포함 관계(hasa) : 한 클래스의 멤버변수로 다른 클래스 타입의 참조 변수를 선언
 *  원(Circle)은 점(Point)을 가지고 있다 → Circle has a Point
 */

public class Circle {

  // 멤버변수 p 로 다른 클래스 포함
  Point p = new Point();
  int r;
}
