package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.BoardDto;
import dto.SearchDto;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor
public class BoardReadAction implements Action {

    private String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        int bno = Integer.parseInt(req.getParameter("bno"));

        // 페이지 나누기 개념 추가 후 들어가는 코드
        int page = Integer.parseInt(req.getParameter("page"));
        int amount = Integer.parseInt(req.getParameter("amount"));
        String criteria = req.getParameter("criteria");
        String keyword = req.getParameter("keyword");

        SearchDto searchDto = new SearchDto(page, amount, criteria, keyword);

        // BoardService 호출
        BoardService service = new BoardServiceImpl();

        // 조회수 업데이트
        // 새로고침 시 req.set~ 가 한 번씩 실행 - 조회수 계속 올라감
        // 조회수 올리기
        // 1) ip 주소 이용 +1
        // 2) updateCount 와 read 의 액션 분리
        // service.updateCount(bno);

        BoardDto dto = service.read(bno);

        // req 결과 담기
        req.setAttribute("dto", dto);
        req.setAttribute("searchDto", searchDto);

        return new ActionForward(path, false);
    }
}
