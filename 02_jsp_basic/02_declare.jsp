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
	
	<%-- JSP의 스크립틀릿 : 해당 스크립틀릿 안에서만 적용--%>
	<%
		String x = "10"; // lv
		out.println("str = " + str + "<br>");
		out.println(a + "의 절댓값 = " + abs(a) + "<br>");
		out.println(b + "의 절댓값 = " + abs(b) + "<br>");
	%>

</body>
</html> 