<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성 결과</title>
<style>
label {
	display : inline-block;
	width : 70px;
	font-weight: bold;
}
</style>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean class="com.ezen.javabeans.BoardBean" id="board" />
 <!-- BoardBean에서 프로퍼티 이름과 입력받은 name속성의 이름이 같은 경우 value가 자동 설정되고
 	  자바빈 setProperty를 각 변수마다가 아닌 한번에 설정 가능 -->
<jsp:setProperty name="board" property="*" />
<h2>입력 완료된 정보</h2>
<label>작성자</label>
<jsp:getProperty name="board" property="name" /><br />
<label>비밀번호</label>
<jsp:getProperty name="board" property="pass" /><br />
<label>이메일</label>
<jsp:getProperty name="board" property="email" /><br />
<label>글 제목</label>
<jsp:getProperty name="board" property="title" /><br />
<label>글 내용</label>
<jsp:getProperty name="board" property="content" /><br />
</body>
</html>