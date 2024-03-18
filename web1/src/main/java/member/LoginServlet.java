package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 가져오는 데이터 한글 처리
        req.setCharacterEncoding("utf-8");

        // 사용자가 전송한 데이터 가져오기
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        String name = req.getParameter("name");

        // 이 과정에서 DB 작업
        // DB 작업 완료 후 확인하고 담긴 객체
        MemberDTO dto = new MemberDTO(userId, password, name);

        // dto 를 세션에 담기(add, add2, ... 불러오기 위해 requset / session 중 session에 담아야함)
        HttpSession session = req.getSession();
        session.setAttribute("loginDto", dto);

        // 페이지 이동
        resp.sendRedirect("/index.jsp"); // session 담기 - sendRedirect 필수!
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
