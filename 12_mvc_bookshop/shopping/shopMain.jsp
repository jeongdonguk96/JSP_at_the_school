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
	<table>
		<tr>
			<td width="150" valign="top">
				<img src="../images/logo.png" border="0" width="150" height="120">
			</td>
			<td>
				<jsp:include page="../module/top.jsp" flush="false"/>
			</td>
		</tr>
		
		<tr>
			<td width="150" valign="top">
				<jsp:include page="../module/left.jsp" flush="false"/>
			</td>
			<td width="700" valign="top">
				<jsp:include page="introList.jsp" flush="false"/>
			</td>
		</tr>
		
		<tr>
			<td width="150" valign="top">
				<img src="../images/logo.png" border="0" width="90" height="60"/>
			</td>
			<td width="700" valign="top">
				<jsp:include page="../module/bottom.jsp" flush="false"/>
			</td>
		</tr>
	</table>
</body>
</html>