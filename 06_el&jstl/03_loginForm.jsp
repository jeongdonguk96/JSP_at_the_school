<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<style>
label {
	display: inline-block;
	width: 80px;
}
</style>
</head>
<body>
<form method="post" action="04_compare_new.jsp">
	<label>아 이 디  </label>
	<input type="text" name="id"/><br />
	<label>패스워드  </label>
	<input type="password" name="pwd" /><br />
	<input type="submit" value="로그인" />
</form>
</body>
</html>