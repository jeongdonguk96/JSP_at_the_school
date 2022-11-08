<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String name = (String)session.getAttribute("loginUser");
%>
<%= name %>님 안녕하세요! <br />
저희 홈페이지에 방문해주셔서 감사합니다. <br />
그럼 즐거운 시간 보내세요~ <br />
<form action="10_logout.jsp">
	<input type="submit" value="로그아웃" />
</form>
</body>
</html>