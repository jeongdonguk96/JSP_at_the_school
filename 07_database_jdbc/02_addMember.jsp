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
	Statement stmt = null;  // 내용을 관리할 객체
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "jsp_user"; 
	String password = "ora123";
	String sql = "";
%>

<%
	String name = "홍길동";
	String userid = "gdhong";
	String pwd = "1234";
	String email = "hong@email.com";
	String phone = "010-0000-8888";
	int admin = 0;
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver"); // 1. 오라클 JDBC 드라이버를 VM에 로드
		conn = DriverManager.getConnection(url, user, password); // 2. DriverManager를 이용해 오라클 DB에 연결, Connection의 객체(conn)에다 담음
		stmt = conn.createStatement(); // 3. SQL문 실행을 위한 Statement 객체 생성 
		
		sql = "INSERT INTO member VALUES('" // 변수에 값을 넣고 그 변수를 사용하는 방법, 상당히 번거로움
		+name+"', '"+userid+"', '"+pwd+"', '"+email+"', '"+phone+"', "+admin+")";
		
		stmt.executeUpdate(sql); // insert 실행
		 						 // insert, delete, update를 할 때는 executeUpdate 사용
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if(conn!=null) conn.close();
			if(stmt!=null) stmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
%>
<h3>회원 가입 완료</h3>
<a href="01_allMember.jsp">회원 전체 목록 보기</a>
</body>
</html>