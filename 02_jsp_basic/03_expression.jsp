<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- HTML의 주석 -->
	<%-- JSP의 주석 --%>
	
	<%-- JSP의 선언문 : JSP 어디서나 적용 --%> 
	<%! 
		String str = "안녕하세요!";
		int a = 5, b = -5;
		
		public int abs(int n) {
			if(n<0) {
				n = -n;
			} 
			return n;
		}
	%>
	
	<%-- JSP의 표현식 --%>
	<%= str %><br>
	<%= a %>의 절대값 = <%= abs(a) %><br>
	<%= b %>의 절대값 = <%= abs(b) %><br>
</body>
</html> 