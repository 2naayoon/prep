package lang;

public class Member {

  String id;

  public Member(String id) {
    this.id = id;
  }

  // 값 비교로 equals 재정의
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Member) {
      Member m = (Member) obj;
      if (this.id == m.id) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    return "Member [id=" + id + "]";
  }
}
