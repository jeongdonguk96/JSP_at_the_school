<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 연산자</title>
</head>
<body>
역슬래시 \가 붙은 \${ }는 값이 아니라 문자열로 출력 <br /><br />
\${ 5 + 2 } : ${ 5 + 2 } <br /><br />
\${ 5 / 2 } : ${ 5 / 2 } <br /><br />
\${ 5 div 2 } : ${ 5 div 2 } <br /><br />
\${ 5 mod 2 } : ${ 5 mod 2 } <br /><br />
\${ 5 > 2 } : ${ 5 > 2 } <br /><br />
\${ 5 gt 2 } : ${ 5 gt 2 } <br /><br /> 
\${ 5>2 ? 5 : 2 } : ${ 5>2 ? 5 : 2 } <br /><br />
\${ (5>2) || (2<10) } : ${ (5>2) || (2<10) } <br /><br /> 
<%
	String name = null;
%>
name = 
<%= name %> <br /><br />
name = ${ name } <br /><br />
\${ empty name } : ${ empty name } <br /><br />
</body>
</html>