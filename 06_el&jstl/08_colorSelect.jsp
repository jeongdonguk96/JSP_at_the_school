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
<c:if test="${ param.color == 1 }">
	<span style="color:red; font-weight: bold;">REDDDDDDDDDDDDDDDDDDDDDD</span>
</c:if>
<c:if test="${ param.color == 2 }">
	<span style="color:blue; font-weight: bold;">BLUEEEEEEEEEEEEEEEEEEEEEEEEEE</span>
</c:if>
<c:if test="${ param.color == 3 }">
	<span style="color:green; font-weight: bold;">GREENNNNNNNNNNNNNNNNNNNNNNNN</span>
</c:if>
</body>
</html>