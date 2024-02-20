package member;

import book.BookDAO;
import java.util.List;
import java.util.Scanner;

public class MemberMain {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean run = true;
    MemberDAO memberDAO = new MemberDAO();

    while (run) {
      System.out.println("=======================");
      System.out.println("1. 전체 회원 조회");
      System.out.println("2. 개별 회원 조회");
      System.out.println("3. 회원 추가");
      System.out.println("4. 회원 정보 수정");
      System.out.println("5. 회원 삭제");
      System.out.println("6. 종료");
      System.out.println("=======================");

      System.out.print("메뉴 입력 >> ");
      int menu = Integer.parseInt(sc.nextLine());

      switch (menu) {
        case 1:
          System.out.println("\n**** 전체 회원 조회 ****");
          System.out.println("아이디\t비밀번호\t이름\t이메일");
          System.out.println("=====================================");
          List<MemberDTO> list = memberDAO.getRows();
          for (MemberDTO memberDTO : list) {
            System.out.print(memberDTO.getUserid() + "\t");
            System.out.print(memberDTO.getPassword() + "\t");
            System.out.print(memberDTO.getName() + "\t");
            System.out.println(memberDTO.getEmail());
          }
          System.out.println();
          break;
        case 2:
          // 아이디, 비밀번호 입력받은 후 dao 메소드 호출 결과 출력
          System.out.println("\n**** 회원 조회 ****");
          System.out.print("아이디 : ");
          String userid = sc.nextLine();
          System.out.print("비밀번호 : ");
          String password = sc.nextLine();

          //   MemberDTO readDto = new MemberDTO();
          //   readDto.setUserid(userid);
          //   readDto.setPassword(password);

          //   MemberDTO row = memberDAO.getRow(readDto);
          MemberDTO row = memberDAO.getRow(userid, password);

          System.out.println("\n\n==== 조회 회원 정보 ====");
          System.out.println("아이디 : " + row.getUserid());
          System.out.println("비밀번호 : " + row.getPassword());
          System.out.println("이름 : " + row.getName());
          System.out.println("이메일 : " + row.getEmail());
          System.out.println();
          break;
        case 3:
          System.out.println("\n**** 회원 추가 ****");
          System.out.print("아이디 >> ");
          String newId = sc.nextLine();
          System.out.print("비밀번호 >> ");
          String newPassword = sc.nextLine();
          System.out.print("이름 >> ");
          String newName = sc.nextLine();
          System.out.print("이메일 >> ");
          String newEmail = sc.nextLine();

          MemberDTO insertDto = new MemberDTO(
            newId,
            newPassword,
            newName,
            newEmail
          );
          System.out.println(
            memberDAO.insert(insertDto) > 0 ? "입력성공" : "입력실패"
          );
          break;
        case 4:
          System.out.println("\n**** 회원 정보 수정 ****");
          System.out.print("아이디 입력 >> ");
          String updateID = sc.nextLine();
          System.out.print("기존 비밀번호 >> ");
          String updatePassword = sc.nextLine();

          // 아이디와 기존 비밀번호로 조회 시 회원이 존재하면 수정
          MemberDTO rowMem = memberDAO.getRow(updateID, updatePassword);
          if (rowMem == null) {
            System.out.println("입력한 아이디와 비밀번호를 확인해 주세요");
          } else {
            System.out.print("변경할 비밀번호 입력 >> ");
            String changePassword = sc.nextLine();
            int result = memberDAO.update(updateID, updatePassword);
            System.out.println(result > 0 ? "수정성공" : "수정실패");
          }
          break;
        case 5:
          System.out.println("\n**** 회원 삭제 ****");
          System.out.print("아이디 입력 >> ");
          String deleteID = sc.nextLine();
          System.out.print("비밀번호 >> ");
          String deletePassword = sc.nextLine();

          MemberDTO rowDel = memberDAO.getRow(deleteID, deletePassword);
          if (rowDel == null) {
            System.out.println("입력한 아이디와 비밀번호를 확인해 주세요");
          } else {
            int result = memberDAO.delete(deleteID);
            System.out.println(
              result > 0 ? "회원 탈퇴 성공" : "회원 탈퇴 실패"
            );
          }
          break;
        case 6:
          run = false;
          break;
        default:
          break;
      }
    }
  }
}
