<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	
	/* // 자바빈 객체의 프로퍼티 이름과 화면에서 name속성의 값이 같을 경우 자동저장 가능함.
	String name = request.getParameter("name");
	String userid = request.getParameter("userid");
	String nickname = request.getParameter("nickname");
	String pwd = request.getParameter("pwd");
	String email = request.getParameter("email");
	String phone = request.getParameter("phone");
	*/
%>
<jsp:useBean class="com.ezen.javabeans.MemberBean" id="member" />
<%--
<jsp:setProperty name="member" property="name" value="<%= name %>" />
<jsp:setProperty name="member" property="userid" value="<%= userid %>" />
<jsp:setProperty name="member" property="nickname" value="<%= nickname %>" />
<jsp:setProperty name="member" property="pwd" value="<%= pwd %>" />
<jsp:setProperty name="member" property="email" value="<%= email %>" />
<jsp:setProperty name="member" property="phone" value="<%= phone %>" />
--%>
<!-- 화면에 나오는 각 필드의 내용이 자바빈 필드에 자동 저장됨 -->
<jsp:setProperty name="member" property="*" />
<h2>입력 완료된 회원 정보</h2>
	<label>이름</label>
	<jsp:getProperty name="member" property="name" /><br />
	<label>아이디</label>
	<jsp:getProperty name="member" property="userid" /><br />
	<label>별명</label>
	<jsp:getProperty name="member" property="nickname" /><br />
	<label>비밀번호</label>
	<jsp:getProperty name="member" property="pwd" /><br />
	<label>이메일</label>
	<jsp:getProperty name="member" property="email" /><br />
	<label>전화번호</label>
	<jsp:getProperty name="member" property="phone" /><br />
</body>
</html>
