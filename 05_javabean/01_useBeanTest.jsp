<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 자바빈 생성 --%>
	<%-- class : 패키지경로.클래스명 / id : 클래스의 객체명(참조변수의 역할) --%>
	<jsp:useBean class="com.ezen.javabeans.MemberBean" id="member" />
	
	<%  // setter로 설정
		member.setName("장보고");
		member.setUserid("jang");
	%>  <%-- getter로 호출 --%>
	이름 : <%= member.getName() %> <br />
	아이디 : <%= member.getUserid() %> <br />
</body>
</html>