<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
<link rel="stylesheet" href="css/shopping.css"/>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script type="text/javascript" src="script/board.js"></script>
<div id="wrap">
<h1>영화 삭제</h1>
<form method="get" action="MovieServlet">
	<input type="text" name="code" value="${ movie.code }">
	<input type="hidden" name="command" value="movie_delete">	
	<table>
		<tr>
			<td>
				<c:choose>
					<c:when test="${empty movie.poster}">
						<img src="images/no_image.jpg">
					</c:when>
					<c:otherwise>
						<img src="images/${movie.poster}">
					</c:otherwise>
				</c:choose>
			</td>
		</tr>		
		<tr>
			<th>제 목</th>
			<td>${ movie.title }</td>
		</tr>
		<tr>
			<th>가 격</th>
			<td>${ movie.price }</td>
		</tr>
		<tr>
			<th>감 독</th>
			<td>${ movie.director }</td>
		</tr>
		<tr>
			<th>배 우</th>
			<td>${ movie.actor }</td>
		</tr>
		<tr>
			<th>설 명</th>
			<td>${ movie.synopsis }</td>
		</tr>
	</table>
	<br>
	<div style="text-align: center;">
		<input type="submit" value="삭제">&nbsp;
		<input type="button" value="목록" onclick="location.href='MovieServlet?command=movie_list'"> 
	</div>
</form>
</div>
</body>
</html>