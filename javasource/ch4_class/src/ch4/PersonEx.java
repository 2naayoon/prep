package ch4;

public class PersonEx {

  public static void main(String[] args) {
    // Person person = new Person();
    // person.setName("홍길동");
    // System.out.println("이름 : " + person.getName());

    // System.out.println(person);

    // Person person2 = new Person();
    // person2.setName("성춘향");
    // System.out.println("이름 : " + person2.getName());

    Person person = new Person("홍길동", "Korea");
    person.setName("김길동");

    Person person2 = new Person("장길동", "Korea");

    // *Error : final - 값을 못 바꿈
    // Person.PI = 1426363;
    System.out.println(Person.getPi());

    System.out.println(person == person2);
  }
}
