<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	td{
		text-align: center;
	}
</style>
</head>
<body>
<%!
	Connection conn = null; // 연결할 객체
	Statement stmt = null;  // 내용을 관리할 객체
	ResultSet rs = null; // 결과를 받아볼(조회할) 객체
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "jsp_user"; 
	String password = "ora123"; 
%>

<table border="1" width="700">
<tr>
	<th>이름</th><th>가격</th><th>설명</th>
</tr>

<%
	try {
		// 1. 오라클 JDBC 드라이버를 VM에 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 2. DriverManager를 이용해 오라클 DB에 연결, Connection의 객체(conn)에다 담음
		conn = DriverManager.getConnection(url, user, password);
		
		// 3. SQL문 실행을 위한 Statement 객체 생성 
		stmt = conn.createStatement();
		
		// 4. SQL문을 실행, 결과를 ResultSet의 객체(rs)에 담음
		rs = stmt.executeQuery("SELECT * FROM item"); // 조회할 때는 executeQuery 사용
		
		// 5. While문을 이용해 데이터 출력
		while(rs.next()) {
			out.print("<tr>");
			out.print("<td>" + rs.getString("name") + "</td>");
			out.print("<td>" + rs.getInt("price") + "</td>");
			out.print("<td>" + rs.getString("description") + "</td>");
			out.print("</tr>");
		} 
	} catch(Exception e) {
			e.printStackTrace();	
	} finally {
		try {
			if(rs!=null) rs.close(); // 위의 과정에서 각 객체들에 null이 생길 경우가 있는데
			if(stmt!=null) stmt.close(); // null인 상태에서 close()를 하면 오류가 생길 수 있다
			if(conn!=null) conn.close(); // 그래서 null이 아닐 경우에만 닫아주는 것
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
%>
</table>
</body>
</html>