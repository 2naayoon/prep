package io;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

/*  자바를 통해 윈도우에 접근하여 폴더, 파일 생성
 */

public class FileEx3 {

  public static void main(String[] args) throws IOException {
    File temp = new File("c:\\temp");
    File dir = new File("c:\\temp\\dir");
    File file1 = new File("c:\\temp\\file1.txt");
    File file2 = new File(temp, "file2.txt");
    File file3 = new File("c:\\temp\\dir\\file3.txt");
    File file4 = new File("c:\\temp\\dir\\file4.txt");

    // 존재하지 않을 때 새로 생성
    if (!dir.exists()) dir.mkdirs();
    if (!file1.exists()) file1.createNewFile();
    if (!file2.exists()) file2.createNewFile();
    if (!file3.exists()) file3.createNewFile();
    if (!file4.exists()) file4.createNewFile();

    // temp 폴더 읽어오기
    File[] files = temp.listFiles();

    // yyyy : 년도 4자리, MM : 월 2자리, dd : 일자 2자리, a(am/pm), HH : 시, mm : 분
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");

    // 날짜  시간  형태  크기  이름
    System.out.println("==============================");
    System.out.println("  날짜  시간  형태  크기  이름  ");
    System.out.println("==============================");
    for (File file : files) {
      String fileName = file.getName();
      // lastModified() : 1970-1-1 시작으로 현재날짜까지의 시간을 밀리세컨드로 돌려줌
      // 1708498371715  →  2024-02-21 오후 12:48
      //   Date date = new Date(file.lastModified());
      //   // System.out.println(date);
      //   System.out.print(sdf.format(date));
      System.out.println(sdf.format(new Date(file.lastModified())));

      if (file.isDirectory()) {
        System.out.println("\t<DIR>\t\t\t" + fileName);
      } else {
        System.out.println("\t\t\t" + file.length() + "\t" + fileName);
      }
    }
  }
}
