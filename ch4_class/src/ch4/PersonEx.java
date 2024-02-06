package ch4;

public class PersonEx {

  public static void main(String[] args) {
    Person person = new Person();
    person.setName("홍길동");
    System.out.println("이름 : " + person.getName());

    //
    System.out.println(person);

    Person person2 = new Person();
    person2.setName("성춘향");
    System.out.println("이름 : " + person2.getName());
  }
}
