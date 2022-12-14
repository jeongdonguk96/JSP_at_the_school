<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
<link rel="stylesheet" href="css/shopping.css"/>
</head>
<body>
<div id="wrap" align="center">
	<h1>게시글 상세보기</h1>
	<table>
	<tr>
		<th>작성자</th>
		<td>${board.name}</td>
		<th>이메일</th>
		<td>${board.email}</td>
	</tr>
	<tr>
		<th>작성일</th>
		<td><fmt:formatDate value="${board.writedate}"/></td>
		<th>조회수</th>
		<td>${board.readcount}</td>
	</tr>
	<tr>
		<th>제목</th>
		<td colspan="3">${board.title} </td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="3" style="height:150px;">${board.content}</td>
	</tr>
	</table>
	<br>
	<div style="text-align:center;">
		<input type="button" value="게시글 수정" onclick="open_win('BoardServlet?command=board_check_pass_form&num=${board.num}', 'update')">&nbsp;
		<input type="button" value="게시글 삭제" onclick="open_win('BoardServlet?command=board_check_pass_form&num=${board.num}', 'delete')">&nbsp;
		<input type="button" value="게시글 목록" onclick="location.href='BoardServlet?command=board_list'">&nbsp;
		<input type="button" value="게시글 등록" onclick="location.href='BoardServlet?command=board_write_form'">&nbsp;
	</div>
</div>

<script type="text/javascript" src="script/board.js"></script>
</body>
</html>