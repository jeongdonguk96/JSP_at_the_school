<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../color/color.jspf" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록된 책 목록</title>
<link href="../../css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body bgcolor="<%= bodyback_c %>">
	<a href="BookShopServlet?command=manager_main">관리자 메인으로</a> &nbsp;
	<p>분류의 목록 : </p>
	<!-- <p>book_kindName 분류의 목록 : </p>  -->
	<table>
		<tr>
			<td align="right" bgcolor="<%= value_c %>"><a href="BookShopServlet?command=book_register_form&book_id=${ book.book_id }">책 등록</a></td>
		</tr>
	</table>
	
	<table>
		<tr>
			<td align="center">등록된 책이 없습니다.</td>
		</tr>
	</table>
	
	<table>
		<tr height="30" bgcolor="<%= value_c %>">
			<td align="center" width="30">번호</td>
			<td align="center" width="30">책분류</td>
			<td align="center" width="100">제목</td>
			<td align="center" width="50">가격</td>
			<td align="center" width="50">수량</td>
			<td align="center" width="70">저자</td>
			<td align="center" width="70">출판사</td>
			<td align="center" width="50">출판일</td>
			<td align="center" width="50">책이미지</td>
			<td align="center" width="30">할인율</td>
			<td align="center" width="70">등록일</td>
			<td align="center" width="50">수정</td>
			<td align="center" width="50">삭제</td>
		</tr>
		<c:forEach var="book" items="${ bookList }">
			<tr height="30">
				<td width="30">${ book.book_id }</td> 
				<td width="30">${ book.book_kind }</td>
				<td width="100">${ book.book_title }</td>
				<td width="50">${ book.book_price }</td>
				<td width="50">${ book.book_count }</td>
				<td width="70">${ book.author }</td>
				<td width="70">${ book.publishing_com }</td>
				<td width="50">${ book.publishing_date }</td>
				<td width="50">${ book.book_image }</td>
				<td width="50">${ book.discount_rate }</td>
				<td width="50">${ book.reg_date }</td>
				<td width="50"><a href="bookUpdateForm.jsp?book_id=${ book.book_id } & book_kind=${ book.book_kind }">수정</a></td>
				<td width="50"><a href="bookDeleteForm.jsp?book_id=${ book.book_id } & book_kind=${ book.book_kind }">삭제</a></td>
			</tr>
		</c:forEach>
	</table><br />
	<a href="BookShopServlet?command=manager_main">관리자 메인으로</a>
</body>
</html>