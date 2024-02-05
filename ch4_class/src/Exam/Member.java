package Exam;

public class Member {

  private String id;
  private String password;
  private String name;
  private int age;
  private String job;
  private String grade;
  private int point;

  public Member(String id, String password, String name) {
    this.id = id;
    this.password = password;
    this.name = name;
  }

  public Member(String id, String password, String name, int age, String job) {
    this.id = id;
    this.password = password;
    this.name = name;
    this.age = age;
    this.job = job;
  }

  @Override
  public String toString() {
    return (
      "Member [id=" +
      id +
      ", password=" +
      password +
      ", name=" +
      name +
      ", age=" +
      age +
      ", job=" +
      job +
      "]"
    );
  }
}
