<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<link rel="stylesheet" href="css/shopping.css"/>
<style>
td {
text-align: center;
}
</style>
</head>
<body>
<div id="wrap" >
	<h1>영화 목록</h1>
	<table>
		<tr>
			<td colspan="5" style="border: white; text-align:right;">
				<a href="MovieServlet?command=movie_write_form">정보 등록</a>
			</td>
		</tr>
		<tr>
			<th>제목</th><th>감독</th><th>배우</th><th>가격</th><th>수정</th><th>삭제</th>
		</tr>
		<c:forEach var="movie" items="${ movieList }">
			<tr>
				<td><a href="MovieServlet?command=movie_view&code=${ movie.code }">${ movie.title }</a></td>
				<td>${ movie.director }</td>
				<td>${ movie.actor }</td>
				<td>${ movie.price }</td>
				<td><a href="MovieServlet?command=movie_update_form&code=${ movie.code }">정보 수정</a></td>
				<td><a href="MovieServlet?command=movie_delete_form&code=${ movie.code }">정보 삭제</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>

