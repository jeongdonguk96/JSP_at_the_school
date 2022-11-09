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
<%-- c:set을 이용해 속성값 설정 1 --%>
<%-- pageContext.setAttribute("msg", "Hello"); 를 jstl의 core와 set으로 작성한 것 --%>
<c:set var="msg" value="Hello" />
\${ msg } : ${ msg } <br /><br />

<%-- c:set을 이용해 속성값 설정 2 --%>
<%-- pageContext.setAttribute("age", "25"); 를 jstl의 core와 set으로 작성한 것 --%>
<c:set var="age">
25				<%-- value로 설정하지 않고 이런 방식으로도 가능, 하지만 거의 쓰지 않음 --%>
</c:set>

<%-- c:set을 이용해 자바빈 객체 설정  --%>
<c:set var="member" value="<%= new com.ezen.javabeans.MemberBean() %>" />

<%-- 위에서 설정한 자바빈 객체 멤버에 값 설정 --%>
<c:set target="${ member }" property="name" value="이순신" />
<c:set target="${ member }" property="userid">
lee
</c:set>

<%-- 위의 자바빈 객체의 내용 출력 --%>
${ member } <br /><br />

<%-- 계산 결과 저장 --%>
<c:set var="sum" value="${ 10 + 20 }" />
sum의 내용은 ${ sum } <br /><br />
<c:set var="flag" value="${ 10>20 }" />
flag의 내용은 ${ flag } <br /><br />

<%-- 설정된 변수 값 제거 --%>
<c:remove var="age" />
\${ age } : ${ age } <br /><br />
</body>
</html>