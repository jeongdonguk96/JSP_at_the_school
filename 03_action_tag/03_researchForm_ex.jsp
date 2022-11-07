<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="container">
    <h2>설문 조사</h2>
    <form method="post" action="03_research.jsp">
        <label for="name">이름:</label>
        <input type="text" name="name" id="name"><br>
        <label for="gender">성별:</label>
        <input type="radio" name="gender" id="gender" value="남자" checked>남자
        <input type="radio" name="gender" id="gender1" value="여자">여자<br>
        <label for="season">좋아하는 계절: </label>
        <input type="checkbox" name="season" id="season" value="1">봄
        <input type="checkbox" name="season" id="season" value="2">여름
        <input type="checkbox" name="season" id="season" value="3">가을
        <input type="checkbox" name="season" id="season" value="4">겨울
        <br>
        <input type="submit" value="전송" style="margin-right: 20px;">
        <input type="reset" value="취소">
     </form>
</div>

</body>
</html>