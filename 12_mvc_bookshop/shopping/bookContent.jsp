<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../color/color.jspf" %>         
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Shopping Mall</title>
<link href="../../css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body bgcolor="<%= bodyback_c %>">
	<form method="post" name="inform" action="BookShopServlet">
		<table>
			<tr height="30">
				<td rowspan="6" width="150">
					<img src="" border="0" width="150" height="200">
				</td>
				<td width="500"><font size="+1"><b>${ book.book_title }</b></font>
				</td>
			</tr>
			<tr><td width="500">저자 : ${ book.author }</td></tr>
			<tr><td width="500">출판사 : ${ book.publishing_com }</td></tr>
			<tr><td width="500">출판일 : ${ book.publishing_date }</td></tr>
			<tr><td width="500">정가 : ${ book.price }원<br>
			판매가 : <b><font color="red">${ }원</font></b>
			</td></tr>
			<tr>
				<td width="500">수량 : <input type="text" size="5" name="buy_count" value="1">개
				<input type="hidden" name="book_id" value="${ book.book_id }">
				<input type="hidden" name="book_image" value="${ book.book_image }">
				<input type="hidden" name="book_title" value="${ book.book_title }">
				<input type="hidden" name="buy_price" value="${ buy.buy_price }">
				<input type="hidden" name="book_kind" value="${ book_book_kind }">
				<input type="submit" value="장바구니에 담기">
				<input type="button" value="목록으로" onclick="BookShopServlet?command=">
				<input type="button" value="메인으로" onclick="BookShopServlet?command=">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="left">
					<br>${ book.book_content }
				</td>
			</tr>	
		</table>
	</form>
</body>
</html>