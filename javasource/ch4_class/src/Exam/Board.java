package Exam;

import java.time.LocalDateTime;

public class Board {

  // 번호, 제목, 내용, 작성자, 작성날짜, 수정날짜
  private int bno;
  private String title;
  private String content;
  private String writer;
  private LocalDateTime regDate;
  private LocalDateTime lastModifiedDate;

  // default
  Board() {}

  // 4개
  Board(int bno, String tilte, String content, String writer) {
    this.bno = bno;
    this.title = title;
    this.content = content;
    this.writer = writer;
  }
}
