<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/include/header.jsp"%>

<h1 class="mt-5">Todo List</h1>
<table class="table">
  <thead>
    <tr>
      <th scope="col">번호</th>
      <th scope="col">제목</th>
      <th scope="col">작성일</th>
      <th scope="col">완료여부</th>
    </tr>
  </thead>
  <tbody>
    <%-- 
        jstl - jsp 에서 java 코드를 태그처럼 쓸 수 있음 - EL 과 같이 사용 (<%%> 대신 ${} 사용)
        <c:forEach var="변수명" items="${setAttribute에 쓴 이름}">
        반목문
        </c:forEach> 
     --%>
    <c:forEach var="dto" items="${list}">
      <tr>
        <th scope="row">${dto.no}</th>
        <%-- c url : jdbc/ 는 자동으로 붙여줘서 이후 경로만 생각하면 됨 --%>
        <td><a href='<c:url value="/read.do?no=${dto.no}"/>' class="text-decoration-none text-reset">${dto.title}</a></td>
        <td>${dto.createdAt}</td>
        <td>
        <input type="checkbox"  id="completed" class="form-check-input" name="completed" disabled value="true" <c:out value="${dto.completed?'checked':''}"/>>
        </td>
      </tr>
    </c:forEach>
  </tbody>
</table>
<%@ include file="/include/footer.jsp"%>