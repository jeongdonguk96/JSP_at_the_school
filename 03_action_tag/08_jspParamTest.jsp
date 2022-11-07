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
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String userType = request.getParameter("user_type");
	
	if(userType.equals("user")) {
%>
	<jsp:forward page="08_userMain.jsp">
		<jsp:param name="user_name" value='<%= URLEncoder.encode("김고객", "utf-8") %>' />
	</jsp:forward>
<%	} else {
%>
	<jsp:forward page="08_managerMain.jsp">
		<jsp:param name="user_name" value='<%= URLEncoder.encode("박관리", "utf-8") %>' />
	</jsp:forward>
<%	}
%>
</body>
</html>