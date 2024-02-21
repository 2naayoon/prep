package io;

import java.io.File;

public class FileEx2 {

  public static void main(String[] args) {
    // 사용자한테 폴더를 입력 받아 폴더 안 정보 출력
    if (args.length != 1) {
      System.out.println("사용법 : java FileEx3 디렉토리명");
      System.exit(0);
    }
    // E:\source\javasource\ch9_io
    File f = new File(args[0]);

    if (!f.exists() || !f.isDirectory()) {
      System.out.println("유효하지 않은 디렉토리");
      System.exit(0);
    }

    File[] files = f.listFiles();
    for (File file : files) {
      String fileName = file.getName();
      System.out.println(file.isDirectory() ? "[" + fileName + "]" : fileName);
    }
  }
}
