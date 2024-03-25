package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dto.MemberDto;
import lombok.AllArgsConstructor;
import service.BookService;
import service.BookServiceImpl;

@AllArgsConstructor
public class BookLeaveAction implements Action {
    private String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {
        MemberDto dto = new MemberDto();
        dto.setUserid(req.getParameter("userid"));
        dto.setPassword(req.getParameter("password"));

        BookService service = new BookServiceImpl();
        boolean result = service.leave(dto);

        if (!result) {
            path = "/view/leave.jsp";
        }
        HttpSession session = req.getSession();
        session.invalidate();

        return new ActionForward(path, true);
    }

}
