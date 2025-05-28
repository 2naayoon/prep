package util;

import java.util.Objects;

public class Member {

  private String id;
  private String name;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Member [id=" + id + ", name=" + name + "]";
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Member) {
      Member member = (Member) obj;
      return name.equals(member.name) && id.equals(member.id);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, id);
  }
}
