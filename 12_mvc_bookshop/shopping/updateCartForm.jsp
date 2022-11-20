<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../color/color.jspf" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Shopping Mall</title>
<link href="../../css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body bgcolor="<%= bodyback_c %>">
	<form method="post" action="BookShopServlet" name="">
		변경할 수량 : 
		<input type="text" name="buy_count" size="5" value="${ cart.buy_count }">
		<input type="hidden" name="cart_id" value="${ cart.cart_id }">
		<input type="hidden" name="book_kind" value="${ book.book_kind }">
		<input type="submit" value="변경">
	</form>
</body>
</html>