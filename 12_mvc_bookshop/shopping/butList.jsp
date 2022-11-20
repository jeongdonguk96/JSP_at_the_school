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
	<h3><b>구매목록</b></h3>
		<table>
			<tr><td align="center">구매목록이 없습니다.</td></tr>
		</table>
		<input type="button" value="메인으로" onclick="">
	<h3><b>구매목록</b></h3>
		<table>
			??
				<table>
					<tr>
						<td width="150">번호</td>
						<td width="300">책이름</td>
						<td width="100">판매가</td>
						<td width="50">수량</td>
						<td width="150">금액</td>
					</tr>
					<tr>
						<td align="center" width="150">${ buy.buy_id }</td>
						<td align="left" width="300"><img src="" border="0" width="30" height="50" align="middle">${ buy.book_title }</td>
						<td width="100"></td>
						<td width="50"></td>
						<td width="150"></td>
					</tr>
					<tr>
						<td colspan="5" align="right"><b>총 금액 : </b></td>
					</tr>
				</table>
		</table><br>
		<input type="button" value="메인으로" onclick="BookShopServlet?command=">		
</body>
</html>