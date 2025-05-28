package action;

import javax.servlet.http.HttpServletRequest;

import dto.TodoDto;
import service.TodoService;
import service.TodoServiceImpl;

public class TodoUpdateAction implements Action {
    private String path;

    public TodoUpdateAction(String path) {
        this.path = path;
    }

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {
        // no, description, completed, title 가져오기
        // value 가 없는 경우 checkbox, radio 의 경우에는 on 값을 갖고 오게 됨 (체크가 안 되면 off)
        String no = req.getParameter("no");
        String description = req.getParameter("description");
        String completed = req.getParameter("completed");
        String title = req.getParameter("title");

        // DB 작업
        TodoDto dto = new TodoDto();
        dto.setNo(Integer.parseInt(no));
        dto.setDescription(description);
        dto.setCompleted(Boolean.parseBoolean(completed));
        dto.setTitle(title);

        TodoService service = new TodoServiceImpl();
        boolean result = service.update(dto);

        // sebd/redurect - trye
        return new ActionForward(path, true);
    }

}
