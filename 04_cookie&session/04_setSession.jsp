<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>세션에 값 저장하고 읽어오기</h3>
<%
	session.setAttribute("id", "hong"); // session은 내장객체. 따로 객체 생성할 필요 없음
	session.setAttribute("pwd", "1234");
	session.setAttribute("name", "홍길동");
	
	String id = (String)session.getAttribute("id");
	String pwd = (String)session.getAttribute("pwd");
	String name = (String)session.getAttribute("name");
%>
id : <%= id %> <br />
pwd : <%= pwd %> <br />
name : <%= name %> <br />
</body>
</html>