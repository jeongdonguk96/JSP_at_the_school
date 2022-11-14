<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/shopping.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="${ pageContext.request.contextPath }/script/product.js"></script>
</head>
<body>
<div id="wrap">
	<form method="post" action="productWrite.do" enctype="multipart/form-data">
		<h1>상품 등록 - 관리자 페이지</h1>
		<table border="1">
			<tr>
			<td>상품명</td><td><input type="text" name="name" id="name" size="50"/></td>
			</tr>
			<tr>
			<td>가 &nbsp;격</td><td><input type="text" name="price" id="price"/>원</td>
			</tr>	
			<tr>
			<td>사 &nbsp;진</td><td><input type="file" name="pictureurl" id="prod_image"/> <br />(주의사항 : 이미지를 변경하고자 할 때만 선택하세요.)</td>
			</tr>
			<tr>
			<td>설 &nbsp;명</td><td> <textarea name="description" id="description" cols="30" rows="10"></textarea> </td>
			</tr>
		</table> <br />
		<input type="submit" value="등록" onclick="return productCheck()"/>
		<input type="reset" value="재작성"/>
		<input type="button" value="목록" onclick="location.href='productList.do'"/>
	</form>
</div>
</body>
</html>