package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*  파일의 내용 읽어오기
 */

public class FileInputStreamEx2 {

  public static void main(String[] args) {
    // InputStream in = null;
    // OutputStream out = null;

    // try {
    //   in = new FileInputStream(new File("c:\\temp\\kbs_1.mp4"));
    //   //   out = System.out;
    //   out = new FileOutputStream("c:\\temp\\kbs_1_copy.mp4"); // 파일 복제

    //   int data = 0;
    //   byte b[] = new byte[1024];
    //   while ((data = in.read(b)) != -1) {
    //     out.write(b);
    //   }
    // } catch (FileNotFoundException e) {
    //   e.printStackTrace();
    // } catch (IOException e) {
    //   e.printStackTrace();
    // } finally {
    //   try {
    //     in.close();
    //     out.close();
    //   } catch (IOException e) {
    //     e.printStackTrace();
    //   }
    // }

    // try-with-resources : try() 닫아야 할 자원들을 선언하면 자동으로 닫아줌
    try (
      InputStream in = new FileInputStream(new File("c:\\temp\\kbs_1.mp4"));
      OutputStream out = new FileOutputStream("c:\\temp\\kbs_1_copy.mp4");
    ) {
      int data = 0;
      byte b[] = new byte[1024];
      while ((data = in.read(b)) != -1) {
        out.write(b);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
