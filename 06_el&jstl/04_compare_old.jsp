<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 자바코드를 이용한 문자열 비교 --%>
== 연산자 사용 결과 : <%= request.getParameter("id") == "hong" %> <br />
.equals() 연산자 사용 결과 : <%= request.getParameter("id").equals("hong") %> <br />
</body>
</html>