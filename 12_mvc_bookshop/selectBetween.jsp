<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 관리</title>
<link rel="stylesheet" href="css/style.css"/>
</head>
<body>
	<h2>로그인 선택 페이지</h2>
	<form method="post" action="BookShopServlet">	
		사용자 <input type="button" name="user" id="user" onclick="BookShopServlet?command=customer_login_form"/><br />
		관리자 <input type="submit" name="admin" id="admin" onclick="BookShopServlet?command=manager_login_form"/><br />
	</form>
</body>
</html>