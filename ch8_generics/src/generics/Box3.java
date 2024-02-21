package generics;

import java.util.ArrayList;

public class Box3<T> {

  ArrayList<T> list = new ArrayList<>();

  void add(T item) {
    list.add(item);
  }

  T get(int i) {
    return list.get(i);
  }

  ArrayList<T> getList() {
    return list;
  }

  int size() {
    return list.size();
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
