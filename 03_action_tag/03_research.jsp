<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	span {
		font-size: 1.2em;
		font-weight: bold;
		color: blue;
	}
</style>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
String[] seasons = request.getParameterValues("season");
String[] season_name = {"", "봄", "여름", "가을", "겨울"};
%>
<h2>설문조사 결과</h2>
이름 : <span><%= request.getParameter("name") %></span><br />
성별 : <span><%= request.getParameter("gender") %></span><br />
선호 계절 : <span> 
<% 
	for(int i=0; i<seasons.length; i++) {
		int index = Integer.parseInt(seasons[i]); 
		out.print(season_name[index] + " ");
	}
%>
</span>입니다.<br />
<a href="javascript:history.go(-1)">뒤로 가기</a>
</body>
</html>