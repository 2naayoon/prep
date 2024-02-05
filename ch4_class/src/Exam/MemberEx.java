package Exam;

public class MemberEx {

  public static void main(String[] args) {
    // 회원 객체 생성 (생성자 호출)
    // 아이디, 비밀번호, 이름 필수
    // 아이디, 비밀번호, 이름, 나이, 직업

    // grade, point - 마트 규칙에 따라 변경

    Member member1 = new Member("efg", "e1234", "김철수");
    Member member2 = new Member("abcd", "a1234", "홍길동", 23, "선생님");
    // Member member3 = new Member(); - default 생성자 = 없다
    System.out.println(member1);
    System.out.println(member2);
  }
}
