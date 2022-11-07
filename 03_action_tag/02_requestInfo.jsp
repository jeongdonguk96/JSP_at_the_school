<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="get">
		<input type="text" name="name" />
		<input type="submit" value="SEND~~"/><br />
	</form>
	컨텍스트 패스 : <%= request.getContextPath() %> <br />
	요청 방식 : <%= request.getMethod() %> <br />
	요청 URL : <%= request.getRequestURL() %> <br />
	요청 URI : <%= request.getRequestURI() %> <br />
	서버의 이름 : <%= request.getServerName() %> <br />
</body>
</html>