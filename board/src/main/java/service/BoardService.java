package service;

import java.util.List;

import dto.BoardDto;

public interface BoardService {
    // 서비스 - dao 호출해서 결과 담는 작업

    List<BoardDto> list();

    BoardDto read(int bno);

    boolean insert(BoardDto insertDto);
}
