<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 메인 페이지</title>
</head>
<body bgcolor="yellow">
<h2><%= URLDecoder.decode(request.getParameter("user_type"), "utf-8") %>로 로그인 성공</h2>
<p><%= URLDecoder.decode(request.getParameter("user_name"), "utf-8") %>
(<%= request.getParameter("id") %>)님 환영합니다.</p>
</body>
</html>