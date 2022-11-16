<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
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
<h1>게시글 등록</h1>
<form method="post" action="MovieServlet" enctype="multipart/form-data">
	<input type="hidden" name="command" value="movie_write">	
	<input type="hidden" name="nonmakeImg" value="${ movie.poster }">
	<table>
		<tr>
			<th>제 목</th>
			<td><input type="text" name="title" id="title"></td>
		</tr>
		<tr>
			<th>가 격</th>
			<td><input type="text" name="price" id="price"></td>
		</tr>
		<tr>
			<th>감 독</th>
			<td><input type="text" name="director" id="director"> </td>
		</tr>
		<tr>
			<th>배 우</th>
			<td><input type="text" name="actor" id="actor"></td>
		</tr>
		<tr>
			<th>설 명</th>
			<td><textarea cols="70" rows="10" name="synopsis"></textarea></td>
		</tr>
		<tr>
			<th>사 진</th>
			<td><input type="file" name="poster" id="poster"/></td>
		</tr>
	</table>
	<br>
	<div style="text-align: center;">
		<input type="submit" value="확인" onclick="location.href='MovieServlet?command=movie_write'">&nbsp;
		<input type="reset" value="취소">&nbsp;
		<input type="button" value="목록" onclick="location.href='MovieServlet?command=movie_list'"> 
	</div>
</form>
</div>
</body>
</html>