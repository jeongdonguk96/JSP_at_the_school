<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../color/color.jspf" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Shopping Mall</title>
<link href="../../css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body bgcolor="<%= bodyback_c %>">
	<h3><b>주문목록</b></h3>
	<table>
		<tr><td>구매목록이 없습니다.</td></tr>
	</table>
	<a href="BookShopServlet?command=manager_main">관리자 메인으로</a>

	<table>
		<tr>
			<td>주문번호</td>
			<td>주문자</td>
			<td>책 이름</td>
			<td>주문가격</td>
			<td>주문수량</td>
			<td>주문일</td>
			<td>결제계좌</td>
			<td>배송명</td>
			<td>배송지전화</td>
			<td>배송지주소</td>
			<td>배송상황</td>
		</tr>
		<c:forEach var="buy" items="${ buyList }">
			<tr>
				<td>${ buyList.buy_id }</td>
				<td>${ buyList.buyer }</td>
				<td>${ buyList.book_title }</td>
				<td>${ buyList.buy_price }</td>
				<td>${ buyList.buy_count }</td>
				<td>${ buyList.buy_date }</td>
				<td>${ buyList.account }</td>
				<td>${ buyList.deliveryName }</td>
				<td>${ buyList.deliveryTel }</td>
				<td>${ buyList.deliveryAddress }</td>
				<td>${ buyList.sanction }</td>
			</tr>
		</c:forEach>			
	</table>
	<a href="BookShopServlet?command=manager_main">관리자 메인으로</a>
</body>
</html>