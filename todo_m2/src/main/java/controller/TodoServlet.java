package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import action.TodoListAction;
import dao.TodoDao;
import dto.TodoDto;
import service.TodoService;
import service.TodoServiceImpl;

@WebServlet("*.do")
public class TodoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        // 경로에서 요청 찾기
        String requestUri = req.getRequestURI(); // 8080 이후의 값
        String contextPath = req.getContextPath(); // 프로젝트명
        String cmd = requestUri.substring(contextPath.length()); // /create.do

        // System.out.println("requestUri " + requestUri);
        // System.out.println("contextPath " + contextPath);
        System.out.println("cmd " + cmd);

        TodoDao dao = new TodoDao();
        TodoService service = new TodoServiceImpl();

        Action action = null;

        if (cmd.equals("/list.do")) {
            // TodoListServlet 에서 했던 작업
            // Action에게 넘김
            action = new TodoListAction("/view/list.jsp");
        } else if (cmd.equals("/read.do")) {
            // TodoReadServlet 에서 했던 작업
            // 제목 클릭 시 no 가져오기
            String no = req.getParameter("no");

            // DB 연동 작업 - Dao
            TodoDto todo = service.getRow(no);

            // todo로 담았기 때문에 read.jsp 에서 todo 로 EL 작업
            req.setAttribute("todo", todo);

            // todo 를 read.jsp에 보여주기
            // RequestDispatcher rd = req.getRequestDispatcher("/view/read.jsp");
            // rd.forward(req, resp);
        } else if (cmd.equals("/modify.do")) {
            // TodoModify 에서 했던 작업
            // 제목 클릭 시 no 가져오기
            String no = req.getParameter("no");

            // DB 연동 작업 - Dao
            TodoDto todo = service.getRow(no);

            // todo로 담았기 때문에 modify.jsp 에서 todo 로 EL 작업
            req.setAttribute("todo", todo);

            // RequestDispatcher rd = req.getRequestDispatcher("/view/modify.jsp");
            // rd.forward(req, resp);
        } else if (cmd.equals("/update.do")) {
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

            boolean result = service.update(dto);

            // servlet list 경로로 이동
            // resp.sendRedirect("/list.do");
        } else if (cmd.equals("/delete.do")) {
            // no 가져오기
            String no = req.getParameter("no");

            // DB 작업
            boolean result = service.delete(no);

            // 화면이동(read)
            // resp.sendRedirect("/list.do");
        } else if (cmd.equals("/create.do")) {
            // 사용자가 입력한 todo 가져오기
            String title = req.getParameter("title");
            String description = req.getParameter("description");

            // DB 연동 작업 - Dao
            TodoDto inserDto = new TodoDto();
            inserDto.setTitle(title);
            inserDto.setDescription(description);

            boolean result = service.insert(inserDto);

            // 화면이동(list)
            // resp.sendRedirect("/list.do");
        }

        ActionForward af = null;

        try {
            af = action.execute(req);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (af.isRedirect()) {
            resp.sendRedirect(af.getPath());
        } else {
            RequestDispatcher rd = req.getRequestDispatcher(af.getPath());
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
