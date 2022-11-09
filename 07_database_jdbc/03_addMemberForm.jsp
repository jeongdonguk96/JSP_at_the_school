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
		width : 65px;
	}
</style>
</head>
<body>
<form method="post" action="03_addMemberEx.jsp">
	<h2>회원 정보 입력</h2>
	<label>이름</label>
	<input type="text" name="name"/> <br />
	<label>아이디</label>
	<input type="text" name="userid"/> <br />
	<label>비밀번호</label>
	<input type="password" name="pwd"/> <br />
	<label>이메일</label>
	<input type="email" name="email"/> <br />
	<label>전화번호</label>
	<input type="text" name="phone"/> <br />
	<label>등급</label>
	<input type="radio" name="admin" value="1"/>관리자
	<input type="radio" name="admin" value="0"/>일반회원 <br />
	<div id="buttons">
		<input type="submit" value="send" /> &nbsp;
		<input type="reset" value="reset" />
	</div>
</form>
</body>
</html>