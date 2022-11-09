<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
사용자가 입력한 정보입니다. (JAVA 표현식 사용) <br />
아이디 : <%= request.getParameter("id") %> <br />
비밀번호 : <%= request.getParameter("pwd") %> <br /><br />

사용자가 입력한 정보입니다. (EL 사용) <br />
아이디 : ${ param.id } <br />
비밀번호 : ${ param["pwd"] } <br />
</body>
</html>