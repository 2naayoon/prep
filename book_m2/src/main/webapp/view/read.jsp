<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/include/header.jsp"%>
<h3 class="border-bottom mb-3">도서상세보기</h3>
<div class="mb-3">
  <label for="code" class="form-label">code</label>
  <input type="text" class="form-control" id="code" name="code" readonly value="${dto.code}">
</div>
<div class="mb-3">
  <label for="title" class="form-label">title</label>
  <input type="text" class="form-control" id="title" name="title" readonly value="${dto.title}">
</div>
<div class="mb-3">
  <label for="writer" class="form-label">writer</label>
  <input type="text" class="form-control" id="writer" name="writer" readonly value="${dto.writer}">
</div>
<div class="mb-3">
  <label for="price" class="form-label">price</label>
  <input type="text" class="form-control" id="price" name="price" readonly value="${dto.price}">
</div>
<div class="mb-3">
  <label for="description" class="form-label">description</label>
  <textarea class="form-control" id="description" rows="3" name="description" readonly>${dto.description}</textarea>
</div>
<div class="mb-3">
    <a href='<c:url value="/list.do"/>' class="btn btn-primary">목록</a>
</div>
<%@ include file="/include/section.jsp"%>
<%@ include file="/include/footer.jsp"%>
