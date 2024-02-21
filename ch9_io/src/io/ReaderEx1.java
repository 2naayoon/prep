package io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

/*  Charset 표준
 *  ISO-8859-1, UTF-8, UTF-16
 *  윈도우즈 MS949 : 인코딩이 좀 달라서 한글이 깨질 수 있음
 */
public class ReaderEx1 {

  public static void main(String[] args) {
    Reader reader = null;
    Writer writer = null;
    try {
      reader = new FileReader("c:\\temp\\file1.txt", Charset.forName("utf-8"));
      // reader.read(); // 하나의 문자 읽어오기
      // reader.read(char[] cbuf); // 입력소스로부터 배열의 크기만큼 읽어서 배열에 저장
      // reader.read(char[] cbuf, int off, int len); // 입력소스로부터 len 개 만큼 읽어서 배열의 off 위치에 저장
      writer = new FileWriter("c:\\temp\\test1.txt");
      // writer.write(String str);
      // writer.write(int ch);
      // writer.write(char[] cbuf);

      int data = 0;
      char[] cbuf = new char[1024];
      while ((data = reader.read(cbuf)) != -1) {
        // System.out.print((char) data);
        writer.write(new String(cbuf));
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        reader.close();
        writer.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
