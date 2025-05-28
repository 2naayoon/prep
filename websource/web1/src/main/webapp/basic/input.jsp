<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%-- jsp 주석 --%>

<%-- 
    자바코드는 <% %> 안에 작성 (작성 위치는 상관 없음) - 자동완성 x 
    자바코드 화면 출력 <%= %>
--%>

 <% 
    // for(int i = 1; i < 11 ; i++){
    //     out.print(i);
    // }

    // JSP 내장객체 : 선언할 필요 없이 그냥 사용 가능
    // 1) HttpServletRequest request (변수명 고정, 변경 x)
    // 2) HttpServletResponse response (변수명 고정, 변경 x)
    // 3) JspWriter out

    request.setCharacterEncoding("utf-8");

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String[] dogs = request.getParameterValues("dog");
 %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <ul>
        <li>id : <%=id%></li>
        <li>name : <%=name%></li>
        <li>name : <% out.print(name); %></li>
        <%
            for (String dog : dogs) {
                out.print("<li>dog : " + dog + "</li>");
            }
        %>
    </ul>
</body>
</html>