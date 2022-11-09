<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int num1 = Integer.parseInt(request.getParameter("num1"));
	int num2 = Integer.parseInt(request.getParameter("num2"));
	// 기본적으로 EL에서는 변수를 사용할 수 없음	
	// 하지만 위의 변수를 EL에서 사용하고 싶을 땐 내장 객체에 자바 변수의 값을 저장한 후 사용 가능
	request.setAttribute("number1", num1); // 변수 num1을 다시 EL의 내장객체에 속성값으로 저장
	request.setAttribute("number2", num2); // 위 방식으로 EL에서 변수를 우회해서 사용 가능
%>
고전적인 방식 : <%= num1 %> + <%= num2 %> = <%= num1+num2 %> <br /><br />
EL 방식 : ${ param.num1 } + ${ param.num2 } = ${ param.num1 + param.num2 }  <br /><br />
EL에서 변수 사용 : ${ number1 } + ${ number2 } = ${ number1 + number2 } <br /><br />
</body>
</html>