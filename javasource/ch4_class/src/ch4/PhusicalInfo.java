package ch4;

public class PhusicalInfo {

  // name(0>), age, / double : height, weight
  private String name;
  private int age;
  private double height;
  private double weight;

  public PhusicalInfo(String name, int age, double height, double weight) {
    this.name = name;
    this.age = age;
    this.height = height;
    this.weight = weight;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    if (age < 0) return;
    this.age = age;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    if (height < 0) return;
    this.height = height;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    if (weight < 0) return;
    this.weight = weight;
  }

  // 메소드 오버로딩
  void update(int age) {
    this.age = age;
  }

  void update(int age, double height) {
    // this.age = age;
    update(age);

    this.height = height;
  }

  void update(int age, double height, double weight) {
    // this.age = age;
    // this.height = height;
    update(age, height); // 메소드 (메소드) 가능

    this.weight = weight;
  }
}
