<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%
    // id, name, age 가져오기 : info.jsp a태그가 보낸 데이터 (form 전송 x)
    // String id = request.getParameter("id");
    // String name = request.getParameter("name");
    // String age = request.getParameter("age");

    // request scope 사용 시 가져오기 - null → foward 이용하여 전송
    // 주소 info.jsp / 보여지는 건 next.jsp
    // * Error : Type mismatch: cannot convert from Object to String → 형변환 필요
    String id = (String)request.getAttribute("id");
    String name = (String)request.getAttribute("name");
    String age = (String)request.getAttribute("age");

    // session scope 사용
    // String id = (String)session.getAttribute("id");
    // String name = (String)session.getAttribute("name");
    // String age = (String)session.getAttribute("age");
%>
<h3>next.jsp</h3>
<h3>id : <%=id%></h3>
<h3>name : <%=name%></h3>
<h3>age : <%=age%></h3>

<h3>
    <a href="next2.jsp">다음 페이지</a>
</h3>