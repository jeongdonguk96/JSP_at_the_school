<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	label {
		display: inline-block;
		width : 50px;
	}
	div#buttons {
		text-align: center;
	}
	
</style>
</head>
<body>
<h2>상품 정보 입력</h2>
<form method="post" action="04_itemWrite.jsp">
	<label>상품명</label>
	<input type="text" name="name"/> <br />
	<label>가격</label>
	<input type="text" name="price"/> <br />
	<label>설명</label>
	<textarea name="description"cols="100" rows="10"></textarea> <br />
	<div id="buttons">
		<input type="submit" value="Send" /> &nbsp;
		<input type="reset" value="reset"/>
	</div>
</form>
</body>
</html>