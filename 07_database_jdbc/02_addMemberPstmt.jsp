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
	String name = "안창호";
	String userid = "chAhn";
	String pwd = "1234";
	String email = "Ahn@email.com";
	String phone = "010-7777-2222";
	int admin = 0;
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, user, password);
		pstmt = conn.prepareStatement(sql); //  createStatement가 아니라 prepareStatement
		pstmt.setString(1, name);
		pstmt.setString(2, userid);
		pstmt.setString(3, pwd);
		pstmt.setString(4, email);
		pstmt.setString(5, phone);
		pstmt.setInt(6, admin);
		
		pstmt.executeUpdate(); // 이미 위에서 pstmt에 sql을 넣은 conn을 담았기 때문에 여기서는 매개변수 없이 실행
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if(conn!=null) conn.close();
			if(pstmt!=null) pstmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
%>

<h3>회원 가입 완료</h3>
<a href="01_allMember.jsp">회원 전체 목록 보기</a>
</body>
</html>