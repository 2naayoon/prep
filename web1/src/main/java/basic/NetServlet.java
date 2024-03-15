package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/net")
public class NetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // HttpServletRequest 객체로 알 수 있는 정보
        // 1. 사용자 입력 가져오기
        res.setContentType("text/html;charset=utf-8");
        PrintWriter out = res.getWriter();
        out.print("Request Scheme : " + req.getScheme() + "<br>");
        out.print("Server Name : " + req.getServerName() + "<br>");
        out.print("Server Address : " + req.getLocalAddr() + "<br>");
        out.print("Server Port : " + req.getServerPort() + "<br>");
        out.print("Client Address : " + req.getRemoteAddr() + "<br>");
        out.print("Client Host : " + req.getRemoteHost() + "<br>");
        out.print("Client Port : " + req.getRemotePort() + "<br>");
        out.print("RequestURI : " + req.getRequestURI() + "<br>");
        out.print("RequestURL : " + req.getRequestURL() + "<br>");
        out.print("ContextPath : " + req.getContextPath() + "<br>");
        out.print("ServletPath : " + req.getServletPath() + "<br>");

        // http://localhost:8080/net

        // Request Scheme : http
        // Server Name : localhost
        // Server Address : 0:0:0:0:0:0:0:1 - 127.0.0.1
        // Server Port : 8080
        // Client Address : 0:0:0:0:0:0:0:1 - 현재 client이자 server
        // Client Host : 0:0:0:0:0:0:0:1
        // Client Port : 51695
        // RequestURI : /net
        // RequestURL : http://localhost:8080/net
        // ContextPath : - project 명 (web1 현재 제거한 상태)
        // ServletPath : /net
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
