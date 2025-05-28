package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferedStreamEx1 {

  public static void main(String[] args) {
    try (
      FileInputStream fis = new FileInputStream("c:\\temp\\test1.txt");
      BufferedInputStream bis = new BufferedInputStream(fis);
      FileOutputStream fos = new FileOutputStream("c:\\temp\\output3.txt");
      BufferedOutputStream bos = new BufferedOutputStream(fos)
    ) {
      int data = 0;
      while ((data = bis.read()) != -1) {
        bos.write(data);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
