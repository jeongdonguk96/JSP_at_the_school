<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나요?</title>
<script type="text/javascript" src="js/param.js"></script>
</head>
<body>
	<form method="post" action="ParamServlet">
		<label>
		아이디 : <input type="text" name="id" id="id"/>
		</label><br>
		<label>
		나  이 : <input type="text" name="age" id="age"/>
		</label><br><br>
		<input type="submit" value="SEND" onclick="return check()"/>
											  <!-- return을 적여줘야 에러화면이 나타나지 않음 -->
	</form>
</body>
</html>