<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../color/color.jspf" %>         
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Shopping Mall</title>
<link href="../../css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body bgcolor="<%= bodyback_c %>">
	<table>
		<tr>
			<td width="150" valign="top">
				<jsp:include page="../module/left.jsp" flush="false"/>
			</td>
			<td>
			<h3><b>${ book.book_kindName } 분류목록</b></h3>
			<a href="shopMain.jsp">메인으로</a>
			</td>
			<table>
				<tr height="30" bgcolor="<%= value_c %>">
					<td rowspan="4" width="100">
						<a href="BookShopServlet?book_id=${ book.book_id }&book_kind=${ book.book_kind }"><img src="../../images/${  }" border="0" width="60" height="90"></a>
					</td>
					<td width="350"> <font size="+1"><b>
						<a href="BookShopServlet?book_id=${ book.book_id }&book_kind=${ book.book_kind }">${ book.book_title }</a></b></font>
					</td>
					<td rowspan="4" width="100" align="center" valign="middle">
					<c:if test="${ book.book_count }==0">
						<b>일시품절</b>
					</c:if>								
					</td>
				</tr>
				<tr height="30" bgcolor="<%= value_c %>">
					<td width="350">출판사 : ${ book.publishing_com }
					</td>
				</tr>
				<tr height="30" bgcolor="<%= value_c %>">
					<td width="350">저자 : ${ book.author }
					</td>
				</tr>
				<tr height="30" bgcolor="<%= value_c %>">
					<td width="350">정가 : ${ book.book_price }<br>
					판매가 : <b><font color="red">
					${ }</font></b>
					</td>
				</tr>
			</table>
		</tr>
	</table>
</body>
</html>