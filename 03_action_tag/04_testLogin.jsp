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
	String id = "gdhong"; // 서버에 저장된 아이디
	String pwd = "1234"; // 서버에 저장된 패스워드
	String name = "홍길동"; // 서버에 저장된 사용자명
	
	request.setCharacterEncoding("utf-8");
	
	if(id.equals(request.getParameter("id")) && pwd.equals(request.getParameter("pwd"))) {
							// 아래의 redirect URL은 사용자가 입력한 요청과 같은 효과
		response.sendRedirect("04_main.jsp?name=" + URLEncoder.encode(name, "UTF-8")); // 정상적으로 로그인 -> main.jsp로 이동
	} else {
		response.sendRedirect("04_loginForm.jsp"); // 로그인 실패시 -> loginForm.jsp로 이동
	}
%>
</body>
</html>