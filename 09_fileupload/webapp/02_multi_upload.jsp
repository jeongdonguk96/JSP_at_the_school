<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>여러 개의 파일 업로드</h3>
<form method="post" action="multi_upload.do" enctype="multipart/form-data">
	1. 파일 지정하기 : <input type="file" name="upload1"/> <br />
	2. 파일 지정하기 : <input type="file" name="upload2"/> <br />
	3. 파일 지정하기 : <input type="file" name="upload3"/> <br /><br />
	<input type="submit" value="Send"/>
	<input type="reset" value="reset"/>
</form>
</body>
</html>