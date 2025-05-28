package action;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import dto.BoardDto;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor
public class BoardUpdateCountAction implements Action {

    private String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        int bno = Integer.parseInt(req.getParameter("bno"));
        // 페이지 나누기 개념 추가 후
        String page = req.getParameter("page");
        String amount = req.getParameter("amount");
        String criteria = req.getParameter("criteria");
        // 한글일 경우 get 넘어올때 깨짐 => 인코딩
        String keyword = URLEncoder.encode(req.getParameter("keyword"), "utf-8");

        // BoardService 호출
        BoardService service = new BoardServiceImpl();

        // 조회수 업데이트
        // 새로고침 시 req.set~ 가 한 번씩 실행 - 조회수 계속 올라감
        // 조회수 올리기
        // 1) ip 주소 이용 +1
        // 2) updateCount 와 read 의 액션 분리
        service.updateCount(bno);

        path += "?bno=" + bno + "&page=" + page + "&amount=" + amount + "&criteria=" + criteria + "&keyword=" + keyword;

        return new ActionForward(path, true);
    }
}
