<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="dao.TodoDao"%>
<%@ page import="dto.TodoDto"%>
<%
    // 한글 처리
    request.setCharacterEncoding("utf-8");

    // modify 가져오기
    // value 가 없는 경우 checkbox, radio 의 경우에는 on 값을 갖고 오게 됨 (체크가 안 되면 off)
    String no = request.getParameter("no");
    String description = request.getParameter("description");
    String completed = request.getParameter("completed");
    String title = request.getParameter("title");
    
    // DB 연동 작업 - Dao
    TodoDao dao = new TodoDao();

    // update 에 TodoDto를 만들어서 넘김
    TodoDto dto = new TodoDto();
    dto.setNo(Integer.parseInt(no));
    dto.setDescription(description);
    dto.setCompleted(Boolean.parseBoolean(completed));
    dto.setTitle(title);

    int result = dao.update(dto);

    // 화면이동(read)
    response.sendRedirect("list.jsp");
%>