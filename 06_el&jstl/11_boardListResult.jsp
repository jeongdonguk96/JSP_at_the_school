<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>게시글 목록</h3> <br />
<table>
<colgroup>
	<col width="40px"/>
	<col width="50px"/>
	<col width="50px"/>
	<col width="100px"/>
	<col width="150px"/>
	<col width="100px"/>
</colgroup>
<tr style="background-color:green;">
	<th>번호</th><th>작성자</th><th>이메일</th><th>제목</th><th>내용</th><th>작성일</th>
</tr>

<c:forEach var="board" items="${boardList}">
<tr>
	<td>${board.num}</td>
	<td>${board.writer}</td>
	<td>${board.email}</td>
	<td>${board.title}</td>
	<td>${board.content}</td>
	<td>${board.writedate}</td>
</tr>
</c:forEach>
</table>
</body>
</html>