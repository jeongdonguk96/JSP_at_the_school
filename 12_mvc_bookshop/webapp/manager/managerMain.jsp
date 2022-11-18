<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/color/color.jspf" %>    
<!DOCTYPE html>
<html>
<head>
<title>책관리</title>
<link href="../../css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<form method="post" action="BookShopServlet">
		<input type="hidden" name="command" value="manager_logout" />
		<b>관리작업중..</b> <input type="submit" value="로그아웃" />
	</form>
	
	<table>
		<tr><td align="center" bgcolor="<%= bar%>">상품관련 작업</td></tr>
		<tr><td><a href="BookShopServlet?command=book_register_form&book_id=${ book.book_id }">상품 등록</a></td></tr>
		<tr><td><a href="productProcess/bookList?book_kind=all">상품 수정/삭제</a></td></tr>
	</table>
	
	<table>
		<tr><td align="center" bgcolor="<%= bar%>">구매된 상품관련 작업</td></tr>
		<tr><td><a href="orderedProduct/orderList.jsp">전체 구매목록 확인</a></td></tr>
	</table>
</body>
</html>