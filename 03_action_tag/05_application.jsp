<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	웹 애플리케이션 컨텍스트 패스 : <%= application.getContextPath() %> <br />
	JSP 파일의 실제 경로 : <%= application.getRealPath("05_application.jsp") %> <br />
</body>
</html>