<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>숫자 형식 변환</h3>
<fmt:setLocale value="ko_KR" />
<fmt:formatNumber value="1234567.89" /> <br />
<fmt:formatNumber value="0.11" type="percent" /> <br />
<fmt:formatNumber value="10000" type="currency" /> <br />
<fmt:formatNumber value="123456789.123" /> <br />
<fmt:formatNumber value="123456789.123" pattern="#,#00.0#" /> <br />
<fmt:formatNumber value="123456789" pattern="#,#00.#" /> <br /><br />

<h3>날짜 형식 변환</h3>
<c:set var="now" value="<%= new java.util.Date() %>" />
\${ now } : ${ now } <br />
날짜 표시 : <fmt:formatDate type="date" value="${ now }" /> <br />
시간 표시 : <fmt:formatDate type="time" value="${ now }" /> <br />
날짜와 시간 표시 : <fmt:formatDate type="both" value="${ now }" dateStyle="long" timeStyle="long" /> <br />
패턴 사용 : <fmt:formatDate value="${ now }" pattern="y년 M월 d일 h시 m분 s초" /> <br />
문자열을 날짜로 변환 : <fmt:parseDate type="date" var="date1" value="2022-11-09" pattern="yyyy-MM-dd" /> <br />
                  <fmt:formatDate value="${ date1 }" pattern="y년 M월 d일" />
</body>
</html>