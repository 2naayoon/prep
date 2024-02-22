package io;

import java.io.Serializable;

/*  *Error : java.io.NotSerializableException: io.Person
 *   객체 자체가 주고받을 수 있는 형태로 만들어줘야함 implements Serializable
 */

public class Person implements Serializable {

  private String name;
  private String job;
  private transient String tel; // transient : 직렬화 대상에서 제외

  public Person(String name, String job, String tel) {
    this.name = name;
    this.job = job;
    this.tel = tel;
  }

  @Override
  public String toString() {
    return "Person [name=" + name + ", job=" + job + ", tel=" + tel + "]";
  }
}
