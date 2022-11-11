<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.ezen.dao.MemberDAO" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
</head>
<body>
<%
	MemberDAO memDao = MemberDAO.getInstance();
	Connection conn = memDao.getConnection();
	if(conn != null){
		out.print("<h1>DBCP 연동 성공!!</h1>");	
	} else {
		out.print("<h1>DBCP 연동 실패..</h1>");
	}
	
%>
</body>
</html>