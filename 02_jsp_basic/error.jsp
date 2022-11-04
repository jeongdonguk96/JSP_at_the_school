<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	다음과 같은 오류가 발생했습니다. <br />
	<%= exception.getMessage() %> <br />
	다시 시도하세요.
</body>
</html>