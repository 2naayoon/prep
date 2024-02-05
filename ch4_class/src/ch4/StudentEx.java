package ch4;

/*  main이 있는 클래스
 */

public class StudentEx {

  public static void main(String[] args) {
    // 객체(인스턴스) 생성
    // 생성자 호출
    Student student = new Student();
    System.out.println(student); // ch4.Student@24d46ca6
    System.out.println(student.id); // null
    System.out.println(student.name); // null
    System.out.println(student.addr); // null
    System.out.println(student.hp); // null

    // 생성된 인스턴스에 값 할당
    student.id = "20241212";
    student.name = "홍길동";
    student.addr = "서울시 종로구";
    student.hp = "010-1234-5678";

    System.out.println(student);
    System.out.println(student.id);
    System.out.println(student.name);
    System.out.println(student.addr);
    System.out.println(student.hp);

    Student student2 = new Student();
    student2.id = "20241213";
    student2.name = "성춘향";
    student2.addr = "서울시 구로구";
    student2.hp = "010-4567-5678";
  }
}
