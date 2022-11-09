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
<h3>문자열 분리 : 구분자(, )</h3>
<c:forTokens var="city" items="서울.대전,대구.광주" delims=",">
	${ city } <br />
</c:forTokens>
<hr />

<h3>문자열 분리 : 구분자(. ,)</h3>
<c:forTokens var="city" items="서울.대전,대구.광주" delims=",.">
	${ city } <br />
</c:forTokens>
</body>
</html>