package action;

import javax.servlet.http.HttpServletRequest;

import dto.BookDto;
import service.BookService;
import service.BookServiceImpl;

public class BookUpdateAction implements Action {
    private String path;

    public BookUpdateAction(String path) {
        this.path = path;
    }

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {
        BookDto dto = new BookDto();
        dto.setCode(Integer.parseInt(req.getParameter("code")));
        dto.setPrice(Integer.parseInt(req.getParameter("price")));

        BookService service = new BookServiceImpl();
        boolean result = service.update(dto);

        // 수정 내용 read.do 에 보내주기
        if (result) {
            path += "?code=" + dto.getCode();
        } else {
            path = "/view/modify.jsp";
        }
        return new ActionForward(path, true);
    }

}
