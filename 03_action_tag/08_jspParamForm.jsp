<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="08_jspParamTest.jsp">
	<label>아 이 디 : </label>
	<input type="text" name="id" /> <br />
	<label>비밀번호 : </label>
	<input type="password" name="pwd" /> <br />
	<input type="radio" name="user_type" value="user" checked />사용자
	<input type="radio" name="user_type" value="manager" />관리자 <br /><br />
	<input type="submit" value="로그인" />
</form>
</body>
</html>