package generics;

import lombok.ToString;

@ToString
public class Juice {

  String name;

  public Juice(String name) {
    this.name = name + "Juice";
  }
}
