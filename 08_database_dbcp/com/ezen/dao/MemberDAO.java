package com.ezen.dao;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

import com.ezen.dto.MemberVO;

public class MemberDAO {
	private MemberDAO() {} // 싱글톤 패턴, 생성자를 private로
	
	private static MemberDAO instance = new MemberDAO(); // 내부적으로 사용할 객체 instance 생성
	
	public static MemberDAO getInstance() { // private인 객체를 외부에서 사용 가능하게 끔 getInstance
		return instance;
	}			
	
	public Connection getConnection() throws Exception {
		Context initContext = new InitialContext(); 	// JNDI를 이용하기 위한 객체 생성
		Context envContext  = (Context)initContext.lookup("java:/comp/env"); // lookup() : 지정된 이름으로 등록된 서비스를 찾을 때 사용
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle"); // JDBC 연결 서비스 등록
		Connection conn = ds.getConnection(); // DBCP에 등록된 오라클 연결을 할당 (Connection의 conn객체에 담음)

		return conn;
	}
	
	/*
	 * 입력 파라미터 : 
	 * 	userid : 화면에서 입력한 사용자의 id	
	 * 	userpwd : 화면에서 입력한 사용자의 pwd
	 * 
	 * 출력 :
	 * 	id가 DB에 존재하지 않으면 -1을 반환
	 * 	pwd가 DB와 맞지 않으면 0을 반환
	 *  id, pwd 둘 다 맞을 경우 1을 반환
	 */
	public int userCheck(String userid, String userpwd) {
		// 1. 커넥션에 필요한 값들 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT pwd FROM member WHERE userid=?";
		int result = -1;

		// 2. DB에 연결
		try {
			conn = getConnection(); 
			pstmt = conn.prepareStatement(sql); // SQL문 실행을 위한 Statement 객체 생성(실행권한을 얻음)
			pstmt.setString(1, userid); // 
			rs = pstmt.executeQuery(); // SQL문을 실행, 결과를 ResultSet의 객체(rs)에 담음
			
			if(rs.next()) {
				String db_pwd = rs.getString("pwd"); // DB에서 조회한 pwd를 db_pwd에 담음
				if(userpwd.equals(db_pwd)) {
					result = 1; // 둘 다 맞으니까 1 반환
				} else {
					result = 0; // pwd가 틀리니까 0 반환
				}
			} else {
				result = -1; // id부터 존재하지 않으니까 -1 반환
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) conn.close();
				if(rs != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/*
	 * 사용자 아이디로 회원정보 불러오기 
	 */
	public MemberVO getMember(String userid) {
		// 1. 커넥션에 필요한 값들 초기화
		MemberVO memberVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member WHERE userid=?";
		
		// 2. DB에 연결
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memberVo = new MemberVO();
				memberVo.setName(rs.getString("name"));
				memberVo.setUserid(rs.getString("userid"));
				memberVo.setPwd(rs.getString("pwd"));
				memberVo.setEmail(rs.getString("email"));
				memberVo.setPhone(rs.getString("phone"));
				memberVo.setAdmin(rs.getInt("admin"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return memberVo;
	}
	
	/*
	 * 회원가입시 입력한 아이디가 기존에 있는 아이디인지 아닌지 확인
	 */
	public int confirmId(String userid) {
		// 1. 커넥션에 필요한 값들 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member WHERE userid=?";
		int result = -1;

		// 2. DB에 연결
		try {
			conn = getConnection(); 
			pstmt = conn.prepareStatement(sql); // SQL문 실행을 위한 Statement 객체 생성(실행권한을 얻음)
			pstmt.setString(1, userid); // 
			rs = pstmt.executeQuery(); // SQL문을 실행, 결과를 ResultSet의 객체(rs)에 담음
			
			if(rs.next()) {
				result = 1;
			} else {
				result = -1;	
			} 
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) conn.close();
				if(rs != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/*
	 * 회원가입 화면에서 전달된 데이터를 MemberVO에 저장
	 */
	public int insertMember(MemberVO memberVo) {
		// 1. 커넥션에 필요한 값들 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO member VALUES(?, ?, ?, ?, ?, ?)";
		int result = -1;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVo.getName());
			pstmt.setString(2, memberVo.getUserid());
			pstmt.setString(3, memberVo.getPwd());
			pstmt.setString(4, memberVo.getEmail());
			pstmt.setString(5, memberVo.getPhone());
			pstmt.setInt(6, memberVo.getAdmin());
			result = pstmt.executeUpdate();
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
		return result;
	}
	
	public int updateMember(MemberVO memberVo) {
		// 1. 커넥션에 필요한 값들 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
	
		String sql = "UPDATE member SET pwd=?, email=?, phone=?, admin=? WHERE userid=?";
		int result = -1;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVo.getPwd());
			pstmt.setString(2, memberVo.getEmail());
			pstmt.setString(3, memberVo.getPhone());
			pstmt.setInt(4, memberVo.getAdmin());
			pstmt.setString(5, memberVo.getUserid());
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
