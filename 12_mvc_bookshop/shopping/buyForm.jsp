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
	<form method="post" action="BookShopServlet" name="inform">
		<table>
			<tr>
				<td width="50">번호</td>
				<td width="300">책이름</td>
				<td width="100">판매가</td>
				<td width="150">수량</td>
				<td width="150">금액</td>
			</tr>
			<tr>
				<td width="50">${ }</td>
				<td width="50" align="left"><img src="" border="0" width="30" height="50" align="middle">${ cart.book_id }</td>
				<td width="100">${ }</td>
				<td width="150">${ car.buy_count }</td>
				<td width="150">${ }</td>
			</tr>
			<tr>
				<td colspan="5" align="right"><b>총구매금액 : ${ }</b></td>
			</tr>
		</table>
	</form><br>
	<form method="post" action="BookShopServlet" name="buyinput">
		<table>
			<tr>
				<td colspan="5"><font size="+1"><b>주문자 정보</b></font></td>
			</tr>
			<tr>
				<td width="200"align="left">성명</td>
				<td width="400"align="left">${ member.name }</td>
			</tr>
			<tr>
				<td width="200"align="left">전화번호</td>
				<td width="400"align="left">${ member.tel }</td>
			</tr>
			<tr>
				<td width="200"align="left">주소</td>
				<td width="400"align="left">${ member.address }</td>
			</tr>
			<tr>
				<td width="200"align="left">결제계좌</td>
				<td width="400"align="left">
					<select name="account">
						<option value="${ accountList }">${ accountList }</option>
					</select>
				</td>
			</tr>			
		</table>
		<br>
		
		<table>
			<tr>
				<td colspan="2" align="center"><font size="+1"><b>배송지 정보</b></font></td>
			</tr>
			<tr>
				<td width="200"align="left">성명</td>
				<td width="400"align="left">
				<input type="text" name="deliveryName" value="${ member.name }">
				</td>
			</tr>
			<tr>
				<td width="200"align="left">전화번호</td>
				<td width="400"align="left">
				<input type="text" name="deliveryTel" value="${ member.tel }">
				</td>
			</tr>		
			<tr>
				<td width="200"align="left">주소</td>
				<td width="400"align="left">
				<input type="text" name="deliveryAddress" value="${ member.address }">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center" bgcolor="<%= value_c %>">
				<input type="submit" value="확인">
				<input type="button" value="취소" onclick="BookShopServlet?command=">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>