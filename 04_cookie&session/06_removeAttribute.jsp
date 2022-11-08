<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>세션에서 속성 제거</h3>
<%
	session.removeAttribute("pwd"); // 세션 설정값 제거
%>
<a href="05_getAll.jsp">세션 목록 확인</a>
</body>
</html>