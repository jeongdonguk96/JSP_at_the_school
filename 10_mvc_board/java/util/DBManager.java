package util;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Context initContext = new InitialContext(); // JNDI를 이용하기 위한 객체 생성
			Context envContext  = (Context)initContext.lookup("java:/comp/env"); // lookup() : 지정된 이름으로 등록된 서비스를 찾을 때 사용
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle"); // JDBC 연결 서비스 등록
			conn = ds.getConnection(); // DBCP에 등록된 오라클 연결을 할당 (Connection의 conn객체에 담음)
		} catch(Exception e) {
			e.printStackTrace();
		} 
		
		return conn;
	}
	
	/*
	 * executeQuery (SELECT문 수행 후 사용할 close() 매서드)
	 */
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * executeUpdate (UPDATE문 수행 후 사용할 close() 매서드)
	 */
public static void close(Connection conn, Statement stmt) {
	try {
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
