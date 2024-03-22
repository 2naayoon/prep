package action;

import javax.servlet.http.HttpServletRequest;

import dto.TodoDto;
import service.TodoService;
import service.TodoServiceImpl;

public class TodoCreateAction implements Action {
    private String path;

    public TodoCreateAction(String path) {
        this.path = path;
    }

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {
        // 사용자가 입력한 todo 가져오기
        String title = req.getParameter("title");
        String description = req.getParameter("description");

        // DB 연동 작업 - Dao
        TodoDto inserDto = new TodoDto();
        inserDto.setTitle(title);
        inserDto.setDescription(description);

        TodoService service = new TodoServiceImpl();
        boolean result = service.insert(inserDto);

        return new ActionForward(path, true);
    }

}
