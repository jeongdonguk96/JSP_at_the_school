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
<h3>사용자의 관심사항은  
<c:choose>
	<c:when test="${ param.interest == 1 }">
		<span style="color:red; font-weight: bold;">수영</span>
	</c:when>
	<c:when test="${ param.interest == 2 }">
		<span style="color:blue; font-weight: bold;">헬스</span>
	</c:when>
	<c:when test="${ param.interest == 3 }">
		<span style="color:yellow; font-weight: bold;">등산</span>
	</c:when>
	<c:when test="${ param.interest == 4 }">
		<span style="color:green; font-weight: bold;">골프</span>
	</c:when>
</c:choose>
입니다.</h3>
</body>
</html>