<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 표현식 --%>
<%= "Hello" %> <br /><br />

<%-- 스크립틀릿 --%>
<%
	out.print("Hello<br><br>");
%>

<%-- 표현언어(el) --%>
${ "Hello" } 
</body>
</html>