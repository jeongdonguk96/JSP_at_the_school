<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<style>
table {
    border-collapse: collapse;
}
th {
    background: #bbb;
    width: 80px;
}
</style>
</head>
<body>
    <h3>게시판 글쓰기</h3>
    <form method="post" action="04_boardWrite.jsp">
        <table border="1" style="border-collapse:collapse;">
        <tr>
            <th>작성자</th>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <th>비밀번호</th>
            <td><input type="password" name="pass">(게시물 수정 삭제시 필요합니다.)</td>
        </tr>
        <tr>
            <th>이메일</th>
            <td><input type="email" name="email" size="30"></td>
        </tr>
        <tr>
            <th>글제목</th>
            <td><input type="text" name="title" size="40"></td>
        </tr>
        <tr>
            <th>글 내용</th>
            <td><textarea name="content" rows="10" cols="50"></textarea></td>
        </tr>
        </table>
        <br>
        <input type="submit" value="등록">&nbsp;
        <input type="reset" value="다시작성">
    </form>
</body>
</html>