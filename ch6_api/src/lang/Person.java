package lang;

public class Person {

  String id;
  String name;

  public Person(String id, String name) {
    this.id = id;
    this.name = name;
  }

  // id와 name 값이 같으면 true, 아니면 false
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Person) {
      Person p = (Person) obj;
      if (this.id == p.id && this.name.equals(p.name)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    return "Person [id=" + id + ", name=" + name + "]";
  }
}
