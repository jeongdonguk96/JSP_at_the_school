
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	label {
	    display: inline-block;
	    width: 70px;
	}
	#buttons {
		width: 250px;
		text-align: center;
	}
</style>
</head>
<body>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/member.js"></script>
<h3>회원 수정</h3>
이름과 아이디는 수정이 불가능합니다. <br /><br />
<form action="memberUpdate.do" method="post" name="frm">
    <label>이름</label>
    <input type="text" name="name" id="name" value="${ memberVo.name }" readonly size="20">  <br>
    <label>아이디</label>
    <input type="text" name="userid" id="userid" size="20" value="${ memberVo.userid }" readonly id="userid">  <br>
    <label>암 호</label>
    <input type="password" name="pwd" id="pwd" size="20" >* <br>
    <label>암호 확인</label>
    <input type="password" name="pwd_check" id="pwd_check" size="20">* <br>
    <label>이메일</label>
    <input type="email" name="email" value="${ memberVo.email }" size="20"> <br>
    <label>전화번호</label>
    <input type="text" name="phone" value="${ memberVo.phone }" size="20"> <br>
    <label>등급</label>
	<c:choose>
		<c:when test="${memberVo.admin == 0}">
			<input type="radio" name="admin" value="0" checked="checked"> 일반회원 
			<input type="radio" name="admin" value="1"> 관리자 <br><br>
		</c:when>
		<c:otherwise>
			<input type="radio" name="admin" value="0"> 일반회원 
			<input type="radio" name="admin" value="1" checked="checked"> 관리자 <br><br>
		</c:otherwise>
	</c:choose>
    <div id="buttons">
        <input type="submit" value="확인" onclick="return joinCheck()">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="reset" value="취소"><br>
    </div>
    <span>${message}</span>
</form>
</body>
</html>