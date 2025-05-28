package io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BufferedStreamEx2 {

  public static void main(String[] args) {
    // InputStream 사용 시
    try (FileInputStream fis = new FileInputStream("c:\\temp\\kbs_1.mp4")) {
      long start = System.currentTimeMillis();
      while (fis.read() != -1) {}
      long end = System.currentTimeMillis();

      System.out.println("FileInputStream 만 사용 시 " + (end - start));
    } catch (Exception e) {
      e.printStackTrace();
    }
    // 266521 ms

    // BufferedInputStream 사용 시
    try (
      FileInputStream fis = new FileInputStream("c:\\temp\\kbs_1.mp4");
      BufferedInputStream bis = new BufferedInputStream(fis)
    ) {
      byte data[] = new byte[4096];
      long start = System.currentTimeMillis();
      while (bis.read(data) != -1) {}
      long end = System.currentTimeMillis();

      System.out.println(
        "FileInputStream + byte 배열 + BufferedInputStream 사용 시 " +
        (end - start)
      );
    } catch (Exception e) {
      e.printStackTrace();
    }
    // bis : 2645 ms / bis + 배열 : 74 ms
  }
}
