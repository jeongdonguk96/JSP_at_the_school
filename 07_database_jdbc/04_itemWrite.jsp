<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	Connection conn = null;
	PreparedStatement pstmt = null;
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "jsp_user";
	String password = "ora123";
	String sql = "INSERT INTO item VALUES(?, ?, ?)";
%>

<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	int price = Integer.parseInt(request.getParameter("price"));
	String description = request.getParameter("description");
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, user, password);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setInt(2, price);
		pstmt.setString(3, description);
		pstmt.executeUpdate();
	} catch(Exception e){
		e.printStackTrace();
	} finally {
	 	try {
	 		if(conn != null) conn.close();
	 		if(pstmt != null) pstmt.close();
	 	} catch(Exception e) {
	 		e.printStackTrace();
	 	}
	}
%>
<h3>정보 입력 완료</h3>
<a href="04_itemResult.jsp">결과 보기</a>
</body>
</html>