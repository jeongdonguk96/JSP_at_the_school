<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   label {
   display: inline-block;
   width: 75px;
   }
   * {
   margin:0;
   padding:0;
   }
   #frm {
   margin:30px;
   }
   h3 {
   margin: 30px 0 0 30px;
   }
   #msg {
   	color: red;
   }
</style>
<script src="${ pageContext.request.contextPath }/script/member.js"></script>
</head>
<body>
	<h3>로그인</h3>
	<form method="post" action="login.do" id="frm">
	   <label for="userid">아이디:</label>
	   <input type="text" name="id" id="userid" autocomplete="off" autofocus><br>
	   <label for="userpwd">암&nbsp;&nbsp;&nbsp;호:</label>
	   <input type="password" name="pwd"id="userpwd"><br><br>
	   <input type="submit" value="로그인" onclick="return loginCheck()"> <%-- loginCheck()은 member.js에 --%>
	   <input type="reset" value="취소">
	   <input type="button" value="회원가입" onclick="location.href='join.do'"><br><br>
	   <span id="msg">${ message }<br></span>
	</form>
</body>
</html>
