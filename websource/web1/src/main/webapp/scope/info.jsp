<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%
    request.setCharacterEncoding("utf-8");

    // id, name, age 가져오기
    String id = request.getParameter("id");
    String name = request.getParameter("name");
    String age = request.getParameter("age");

    // HttpServletRequest : 유효범위
    // request.getParameter() : 사용자의 입력값을 가지고 올 때 범위가 제한 됨
    // form action의 값으로 사용된 페이지까지만 가능

    // info.jsp 가 알고 있는 값(사용자 입력값, DB 값)을 다른 페이지랑 공유
    // 1) get/post 방식으로 넘겨준다 - 보안 x, 불편
    // 2) scope 이용
    //    (1) page : 현재 page (사용 x)
    //    (2) request : HttpServletRequest 유효범위
    //    (3) session : HttpSession 유효범위 (브라우저를 닫기 전까지 살아있음 - session에 담아놓은 건 계속 불러올 수 잇음)
    //    (4) application : 톰캣 서버 범위 (사용 x)
    //    유효범위 담기
    //    request.setAttribute("key", 값), request.getAttribute("key")
    //    setAttribute(), getAttribute()
%>
<%-- <h3>id : <%=id%></h3>
<h3>name : <%=name%></h3>
<h3>age : <%=age%></h3> --%>
<%
    // request scope 사용 - action 주소까지밖에 못 감 → foward 이용하여 전송
    // 주소는 http://localhost:8080/scope/info.jsp 요청페이지 주소 그대로 (next.jsp x)
    request.setAttribute("id", id);
    request.setAttribute("name", name);
    request.setAttribute("age", age);

    // info.jsp 에 부여된 request 를 next.jsp 에 넘겨주는 것
    // info.jsp 에서 할 수 있는 작업들을 next.jsp 에서 할 수 있게 됨
    // request 살리는 방법
    pageContext.forward("next.jsp");

    // session scope 사용 - 브라우저 닫기 전까지 지속 사용 가능
    // session.setAttribute("id", id);
    // session.setAttribute("name", name);
    // session.setAttribute("age", age);
%>

<%-- <form action="next.jsp" method="post">
      <div>
        <label for="id">id</label>
        <input type="text" name="id" id="id" value="<%=id%>" readonly/>
      </div>
      <div>
        <label for="name">name</label>
        <input type="text" name="name" id="name"  value="<%=name%>" readonly/>
      </div>
      <div>
        <label for="age">age</label>
        <input type="text" name="age" id="age"  value="<%=age%>" readonly/>
      </div>
      <div>
        <button type="submit">전송</button>
      </div>
</form> --%>

<%-- <h3>
    <a href="next.jsp?id=<%=id%>&name=<%=name%>&age=<%=age%>">다음 페이지</a>
</h3> --%>

<%-- <h3>
    <a href="next.jsp">다음 페이지</a>
</h3> --%>
