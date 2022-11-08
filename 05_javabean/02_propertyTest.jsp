<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean class="com.ezen.javabeans.MemberBean" id="member" />
	<h3>자바빈의 프로퍼티 설정 테스트</h3>
	<jsp:setProperty name="member" property="name" value="장보고"/>
	<jsp:setProperty name="member" property="userid" value="jang"/>
	
	이름 : <jsp:getProperty name="member" property="name"/> <br />
	사용자ID : <jsp:getProperty name="member" property="userid"/>
</body>
</html>