package action;

import javax.servlet.http.HttpServletRequest;

import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor
public class BoardUpdateCountAction implements Action {

    private String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {
        int bno = Integer.parseInt(req.getParameter("bno"));

        BoardService service = new BoardServiceImpl();

        // 조회수 업데이트
        // 새로고침 시 req.set~ 가 한 번씩 실행 - 조회수 계속 올라감
        // 조회수 올리기
        // 1) ip 주소 이용 +1
        // 2) updateCount 와 read 의 액션 분리
        service.updateCount(bno);

        path += "?bno=" + bno;

        return new ActionForward(path, true);
    }
}
