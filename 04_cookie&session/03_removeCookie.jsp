<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pwd 쿠키 삭제</title>
</head>
<body>
<%
	Cookie cookie = new Cookie("pwd", "");
	cookie.setMaxAge(0); // 유효시간을 0으로 하면 삭제됨
	response.addCookie(cookie); // 클라이언트에 전송까지 완료해야 적용됨
%>
<a href="02_getCookie.jsp">쿠키 목록 확인</a>
</body>
</html>