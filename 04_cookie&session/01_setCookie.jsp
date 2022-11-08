<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 생성 과정</title>
</head>
<body>
<%
	Cookie cookie = new Cookie("id", "hong"); // 1. 쿠키 객체 생성
	cookie.setMaxAge(60*60*24*365); // 2. 쿠키 유효시간 설정
	response.addCookie(cookie); // 3. 클라이언트로 전송
	
	response.addCookie(new Cookie("pwd", "1234")); // 혹은 한번에 할 수 있다.
	response.addCookie(new Cookie("name", "홍길동")); // 이 경우 세션의 유효시간과 똑같다
%>
<h3>쿠키 생성 과정</h3>
</body>
</html>