<%-- vscode는 아직 java의 메소드를 자동으로 못 가져와서 import 구문을 직접 넣어줘야함 --%>
<%@ page import = "java.time.LocalTime" %>
<%@ page import = "java.util.Date" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>현재 시간</h1>
    <%-- 1. 자바스크립트 2. 자바 --%>
    <%
        Date date = new Date();
        out.print(date+"<br>");

        LocalTime currTime = LocalTime.now();
        out.print(currTime);
    %>
</body>
</html>