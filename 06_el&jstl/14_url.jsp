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
<h3>c:URL 예제</h3>
<c:url value="images/flower.jpg" var="pic" />
<h4>${ pic }</h4> <%-- 경로를 출력 --%>
<img src="${ pic }" width="500" height="400"/> <%-- 이미지를 출력 --%>
</body>
</html>