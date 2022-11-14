<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="upload.do" enctype="multipart/form-data">
		<label>글쓴이 : </label>
		<input type="text" name="writer" size="20"/> <br />
		<label>제&nbsp;&nbsp;&nbsp;목 : </label>
		<input type="text" name="title" size="20"/> <br /><br />
		파일 지정하기 : 
		<input type="file" name="upload_file"/> <br /><br />
		<input type="submit" value="Send"/>
	</form> 
</body>
</html>