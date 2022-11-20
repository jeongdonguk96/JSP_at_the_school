<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../color/color.jspf" %>    
<!DOCTYPE html>
<html>
<head>
<title>상품 등록</title>
<link href="../../css/style.css" rel="stylesheet" type="text/css"/>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script type="text/javascript" src="../../script/script.js"></script>
</head>
<body bgcolor="<%= bodyback_c %>">
	<p>책 등록</p><br />
	<form method="post" action="BookShopServlet" enctype="multipart-data">
	<input type="hidden" name="command" value="book_register">
	<input type="hidden" name="book_id" value="${ book.book_id }">
	<input type="hidden" name="nothing.jpg" value="${ book.image }">
		<table>
			<tr>
				<td align="right" colspan="2" bgcolor="<%= value_c %>"><a href="BookShopServlet?command=manager_main">관리자 메인으로</a></td>
			</tr>
			<tr>
				<td width="100" bgcolor="<%= value_c %>">분류 선택</td>
				<td width="400" align="left">
					<select name="book_kind">
						<option value="100">문학</option>
						<option value="200">외국어</option>
						<option value="300">컴퓨터</option>
					</select>
				</td>
			</tr>
			<tr>
				<td width="100" bgcolor="<%= value_c %>">제목</td>
				<td width="400" align="left">
				<input type="text" size="10" maxlength="50" name="book_title" /></td>
			</tr>
			<tr>
				<td width="100" bgcolor="<%= value_c %>">가격</td>
				<td width="400" align="left">
				<input type="text" size="10" maxlength="9" name="book_price" />원</td>
			</tr>
			<tr>
				<td width="100" bgcolor="<%= value_c %>">수량</td>
				<td width="400" align="left">
				<input type="text" size="10" maxlength="5" name="book_count" />권</td>
			</tr>
			<tr>
				<td width="100" bgcolor="<%= value_c %>">저자</td>
				<td width="400" align="left">
				<input type="text" size="20" maxlength="30" name="author" /></td>
			<tr>
				<td width="100" bgcolor="<%= value_c %>">출판사</td>
				<td width="400" align="left">
				<input type="text" size="20" maxlength="30" name="publishing_com" /></td>
			</tr>
			<tr>
				<td width="100" bgcolor="<%= value_c %>">출판일</td>
				<td width="400" align="left">
				<select name="publishing_year">
						<%
							Timestamp nowTime = new Timestamp(System.currentTimeMillis());
							int lastYear = Integer.parseInt(nowTime.toString().substring(0,4));
							for(int i=lastYear; i>=2010; i--) {
						%>
						<option value="<%= i %>"><%= i %></option>
						<%
							}
						%>
				</select>년
				
				<select name="publishing_month">
						<%
							for(int i=1; i<=12; i++) {
						%>
						<option value="<%= i %>"><%= i %></option>
						<%
							}
						%>
				</select>월
				
				<select name="publishing_day">
						<%
							for(int i=1; i<=31; i++) {
						%>
						<option value="<%= i %>"><%= i %></option>
						<%
							}
						%>
				</select>일
				</td>
			</tr>
			<tr>
				<td width="100" bgcolor="<%= value_c %>">이미지</td>
				<td width="400" align="left">
				<input type="file" name="book_image" /></td>
			</tr>
			<tr>
				<td width="100" bgcolor="<%= value_c %>">내용</td>
				<td width="400" align="left">
				<textarea name="book_content" cols="40" rows="13"></textarea></td>
			</tr>
			<tr>
				<td width="100" bgcolor="<%= value_c %>">할인율</td>
				<td width="400" align="left">
				<input type="text" size="5" maxlength="2" name="discount_rate" /></td>
			</tr>
			<tr>
				<td colspan=2 bgcolor="<%= value_c %>" align="center">
					<input type="submit" value="책 등록"/>
					<input type="reset" value="재작성" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>