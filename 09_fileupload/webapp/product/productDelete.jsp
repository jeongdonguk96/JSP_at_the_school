<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/shopping.css"/>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script type="text/javascript" src="script/product.js"></script>
<h2>상품 삭제 - 관리자 페이지</h2>
<form method="post" action="productDelete.do">
	<input type="hidden" name="code" value="${product.code}">
	<table>
		<tr>
			<td style="width: 300px;">
				<c:choose>
					<c:when test="${empty product.pictureurl}">
						<img src="upload/no_image.jpg">
					</c:when>
					<c:otherwise>
						<img src="upload/${product.pictureurl}">
					</c:otherwise>
				</c:choose>
			</td>
			<td>
			<table>
			<tr>
				<th>상품명</th>
				<td>${product.name}</td>
			</tr>
			<tr>
				<th>가 &nbsp;격</th>
				<td>${product.price}원 </td>
			</tr>
			<tr>
				<th>설 &nbsp;명</th>
				<td>
					<div style="height:200px; width:100%;">
					${product.description}
					</div>
				</td>
			</tr>
			</table>
			</td>
		</tr>
	</table>
	<div id="buttons">
	<input type="submit" value="삭제"/>
	<input type="button" value="목록" onclick="location.href='productList.do'"/>
	</div>
</form>
</body>
</html>