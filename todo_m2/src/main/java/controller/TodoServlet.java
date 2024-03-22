package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import action.TodoCreateAction;
import action.TodoDeleteAction;
import action.TodoListAction;
import action.TodoReadAction;
import action.TodoUpdateAction;

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

        Action action = null;

        if (cmd.equals("/list.do")) {
            // TodoListServlet 에서 했던 작업
            // Action에게 넘김
            action = new TodoListAction("/view/list.jsp");
        } else if (cmd.equals("/read.do")) {
            // TodoReadAction 에 넘김 - 갈 곳만 지정해주면 됨
            action = new TodoReadAction("/view/read.jsp");
        } else if (cmd.equals("/modify.do")) {
            // TodoReadAction 과 똑같은 작업
            // path 만 따로 잡으면 되니 동일한 action 불러오면 됨
            action = new TodoReadAction("/view/modify.jsp");
        } else if (cmd.equals("/update.do")) {
            action = new TodoUpdateAction("/list.do");
        } else if (cmd.equals("/delete.do")) {
            action = new TodoDeleteAction("/list.do");
        } else if (cmd.equals("/create.do")) {
            action = new TodoCreateAction("/list.do");
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
