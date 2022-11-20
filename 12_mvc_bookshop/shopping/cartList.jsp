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
	<h3><b>장바구니</b></h3>
	<table>
		<tr><td>장바구니에 담긴 물품이 없습니다.</td></tr>
	</table>
	<input type="button" value="쇼핑계속" onclick="BookShopServlet?command=${ book.book_kind }">
	
	<h3><b>장바구니</b></h3>
	<form method="post" action="BookShopServlet?command=" name="inform">
	<table>
		<tr>
			<td width="50">번호</td>
			<td width="300">책이름</td>
			<td width="100">판매가</td>
			<td width="150">수량</td>
			<td width="150">금액</td>
		</tr>
		<tr>
			<td width="50"></td>
			<td width="300" align="left"><img src="" border="0" width="30" height="50" align="middle">${ cart.book_title }</td>
			<td width="100">${ cart.buy_price }</td>
			<td width="150">
				<input type="text" name="buy_count" size="5" value="${ cart.buy_count }">
				<input type="hidden" name="cart_id" size="5" value="${ cart.cart_id }">
				<input type="hidden" name="book_kind" size="5" value="${ book.book_kind }">
				<input type="submit" value="수정">
			</td>
			<td align="center" width="150">${  }${  }
			<input type="button" value="삭제" onclick="BookShopServlet?command=">
			</td>
		</tr>
		<tr>
			<td colspan="5">
				<input type="button" value="구매하기" onclick="BookShopServlet?command=">
				<input type="button" value="쇼핑계속" onclick="BookShopServlet?command=">
				<input type="button" value="장바구니 비우기" onclick="BookShopServlet?command=">
			</td>
		</tr>
	</table>	
	</form>
</body>
</html>