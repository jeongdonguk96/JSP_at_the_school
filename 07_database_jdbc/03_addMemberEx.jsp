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
	Connection conn = null; // 연결할 객체
	PreparedStatement pstmt = null;  // 내용을 관리할 객체
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "jsp_user"; 
	String password = "ora123";
	String sql = "INSERT INTO member VALUES(?, ?, ?, ?, ?, ?)";
%>

<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String userid = request.getParameter("userid");
	String pwd = request.getParameter("pwd");
	String email = request.getParameter("email");
	String phone = request.getParameter("phone");
	int admin = Integer.parseInt(request.getParameter("admin"));
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, user, password); // db연결을 얻는 방식
		pstmt = conn.prepareStatement(sql); // 실행권한을 얻는 방식
		pstmt.setString(1, name);
		pstmt.setString(2, userid);
		pstmt.setString(3, pwd);
		pstmt.setString(4, email);
		pstmt.setString(5, phone);
		pstmt.setInt(6, admin);
		pstmt.executeUpdate();
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		try{
			if(conn != null) conn.close();
			if(pstmt != null) pstmt.close();	
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
%>

<h2>회원 가입 성공</h2>
<a href="01_allMember.jsp">회원 전체 목록 보기</a>
</body>
</html>