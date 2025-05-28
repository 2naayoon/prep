package abstractclass;

import interfacetest.Cat;
import interfacetest.Dog;
import interfacetest.Soundable;

public class SoundableEx {

  public static void main(String[] args) {
    // Cat cat = new Cat();
    // parintSound(cat);
    parintSound(new Cat());
    parintSound(new Dog());
  }

  public static void parintSound(Soundable soundable) {
    System.out.println(soundable.sound());
  }
}
