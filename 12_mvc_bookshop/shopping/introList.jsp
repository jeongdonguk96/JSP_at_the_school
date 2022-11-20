<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../color/color.jspf" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Shopping Mall</title>
<link href="../../css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body bgcolor="<%= bodyback_c %>">
	<font size="+1"><b>분류의 신간목록 : 
	<a href="">더보기</a>
	</b></font>
	
	<table>
		<tr height="30" bgcolor="<%= value_c %>">
			<td rowspan="4" wigth="100">
				<a href=""><img src="../images/" border="0" width="60" height="90"></a>
			</td>
			<td width="350"><font size="+1"><b>
				<a href=""><></a></b></font>
			</td>
			<td rowspan="4" width="100"><><b>일시품절</b>
			</td>
		</tr>
		
		<tr height="30" bgcolor="<%= value_c %>">
			<td width="350">출판사 : ${ }</td>
		</tr>
				<tr height="30" bgcolor="<%= value_c %>">
			<td width="350">저자 : ${ }</td>
		</tr>
		<tr height="30" bgcolor="<%= value_c %>">
			<td width="350">정가 : ${ }원<br>
			판매가 : <b><font color="red"> ${ }</font></b>원</td>
		</tr>
	</table>
</body>
</html>