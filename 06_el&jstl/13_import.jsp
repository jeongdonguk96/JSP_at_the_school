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
<h3>JSTL Import 예제</h3>
<c:import url="02_elOperator.jsp" var="data" /> <%-- url의 내용을 변수 data에 넣는 것 --%>
~ <br />
~ <br />
~ <br />
~ <br />
~ <br />
${ data } <%-- url을 담은 변수를 사용하는 방법. 사용하는 위치가 적용되는 위치 --%>
~ <br />
~ <br />
~ <br />
~ <br />
~ <br />
</body>
</html>