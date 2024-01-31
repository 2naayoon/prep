package exam;

public class Pencil {

  public static void main(String[] args) {
    // 534자루의 연필을 30명의 학생들에게 똑같은 개수로
    // 나눌 때 학생 한 명당 몇 개를 가질 수 있고, 최종적으로 몇 개가 남는지 출력하시오
    // 변수 사용

    int pencils = 534;
    int student = 30;

    System.out.println("학생 한 명당 연필수 : " + pencils / student);
    System.out.println("남는 연필수 : " + pencils % student);
  }
}
