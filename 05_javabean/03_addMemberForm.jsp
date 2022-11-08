<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
label {
	display : inline-block;
	width : 70px;
}
</style>
</head>
<body>
<form method="post" action="03_addMember.jsp">
	<label>이름</label>
	<input type="text"name="name" /><br />
	<label>아이디</label>
	<input type="text" name="userid"/><br />
	<label>별명</label>
	<input type="text" name="nickname"/><br />
	<label>비밀번호</label>
	<input type="password" name="pwd"/><br />
	<label>이메일</label>
	<input type="text" name="email" /><br />
	<label>전화번호</label>
	<input type="text" name="phone" /><br /><br />
	<input type="submit" value="전송" /> &nbsp;
	<input type="reset" value="취소" />
</form>
</body>
</html>