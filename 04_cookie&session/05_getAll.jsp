<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>세션에 저장된 모든 값 읽어오기</h3>
<%
	Enumeration<String> names = session.getAttributeNames();

	while(names.hasMoreElements()) { // 다음 항목이 있는지 확인
		String name = names.nextElement(); // 다음 항목 가져오기
		out.print(name + " : " + (String)session.getAttribute(name) + "<br>"); // (String)session.getAttribute(name)은 (name)의 value를 호출하는 매서드
	}
%>
</body>
</html>