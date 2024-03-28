package service;

import java.util.List;

import dto.BoardDto;
import dto.SearchDto;

public interface BoardService {
    // 서비스 - dao 호출해서 결과 담는 작업
    List<BoardDto> list(SearchDto searchDto);

    BoardDto read(int bno);

    boolean insert(BoardDto insertDto);

    boolean update(BoardDto updateDto);

    boolean delete(BoardDto deleteDto);

    boolean reply(BoardDto replyDto);

    boolean updateCount(int bno);

    List<BoardDto> searchlist(SearchDto searchDto);

    int getTotalRows(String criteria, String keyword);
}
