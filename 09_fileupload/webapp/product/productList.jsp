<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/shopping.css" rel="stylesheet">
<style>
td {
text-align: center;
}
</style>
</head>
<body>
<h1>관리자 페이지</h1>
	<a id="link" href="productWrite.do" target="_blank" >상품등록</a>
<table border="1">
	<tr>
		<td>번호</td>	<td>이름</td>	<td>가격</td>	<td>수정</td>	<td>삭제</td>
	</tr>
	<c:forEach var="productList" items="${ productList }">
	<tr>
		<td class="item">${ productList.code }</td>
		<td>${ productList.name }</td>
		<td class="item">${ productList.price }원</td>
		<td class="item"><a href="productUpdate.do?code=${ productList.code }">상품 수정</a></td>
		<td class="item"><a href="productDelete.do?code=${ productList.code }">상품 삭제</a></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>