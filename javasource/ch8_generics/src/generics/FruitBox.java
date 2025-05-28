package generics;

/*  제한된 지네릭 클래스
 *  <T extends Fruit> : 특정 타입의 자손들만 대입
 *  ? super T : 특정 타입과 그 타입의 부모들만 대입
 *
 *  sort(List<T> list, Comparator<? super T> c)
 *  sort(List<Apple> list, Comparator<? super Apple> c) : Apple과 그 조상들만 가능
 *  Comparator<Apple>, Comparator<Fruit>, Comparator<Object>
 *
 *  sort(List<Toy> list, Comparator<? super Toy> c)
 *  Comparator<Toy>, Comparator<Object>
 */

public class FruitBox<T extends Fruit> extends Box3<T> {}
