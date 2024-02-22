package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*  직렬화(Serialization)
 *  객체를 주고 받는 개념
 *  ObjectInputStream (스트림에서 객체 입력 - 역직렬화) / ObjectOutputStream (스트림에 객체 출력 - 직렬화)
 */

public class SerialEx {

  public static void main(String[] args) {
    Person person1 = new Person("홍길동", "엔지니어", "010-1234-1234");
    Person person2 = new Person("김유신", "선생님", "010-4567-4567");

    try (
      FileOutputStream fos = new FileOutputStream("c:\\temp\\serial.dat");
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      FileInputStream fis = new FileInputStream("c:\\temp\\serial.dat");
      ObjectInputStream ois = new ObjectInputStream(fis);
    ) {
      oos.writeObject(person1);
      oos.writeObject(person2);

      for (int i = 0; i < 2; i++) {
        Person p = (Person) ois.readObject();
        System.out.println(p);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
