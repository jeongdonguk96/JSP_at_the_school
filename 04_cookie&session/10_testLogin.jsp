<%@page import="java.net.URLEncoder"%>
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
	request.setCharacterEncoding("utf-8");

	session.setAttribute("id", "hong");
	session.setAttribute("pwd", "1234");
	session.setAttribute("name", "홍길동");

	String id = (String)session.getAttribute("id");
	String pwd = (String)session.getAttribute("pwd");
	String name = (String)session.getAttribute("name");
		
	if(id.equals(request.getParameter("id")) && pwd.equals(request.getParameter("pwd"))) {
		session.setAttribute("loginUser", name);
		response.sendRedirect("10_main.jsp");
	} else {
		response.sendRedirect("10_loginForm.jsp");
	}
%>
</body>
</html>