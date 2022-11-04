<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 자바 코드 작성 부분 -->
<% 
	int num1 = 30;
	int num2 = 20;
	int add = num1 + num2;
	
	out.print(num1 + " + " + num2 + " = " + add); // jsp에서는 system 생략 가능
%>
</body>
</html>