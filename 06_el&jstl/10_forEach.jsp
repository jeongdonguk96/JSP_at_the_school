<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String[] movieList = {"공조2", "수리남", "슈퍼맨", "범죄도시2"};
	pageContext.setAttribute("movieList", movieList); // 앞의 것이 속성명, 뒤의 것이 위의 변수
%>
<c:forEach var="movie" items="${ movieList }" varStatus="status"> <%-- var에는 하나씩 담을 변수, items는 위에서 속성에 담은 객체 --%>
	${ status.index+1 } &nbsp;
	${ status.count } &nbsp;
	${ movie } <br />
</c:forEach>
</body>
</html>