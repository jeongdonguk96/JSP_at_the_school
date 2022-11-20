package com.ezen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ezen.dto.CustomerVO;
import com.ezen.util.DBManager;

public class CustomerDAO {
	private CustomerDAO() {}
	private static CustomerDAO instance = new CustomerDAO();
	public static CustomerDAO getInstance() {
		return instance;
	}
	
	// 사용자 회원가입 매서드
	public void joinMember(CustomerVO customer) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO member VALUES(?, ?, ?, SYSDATE, ?, ?)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, customer.getId());
			pstmt.setString(1, customer.getPwd());
			pstmt.setString(1, customer.getName());
			pstmt.setString(1, customer.getAddress());
			pstmt.setString(1, customer.getTel());
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// 사용자 로그인시 인증 매서드
	public int userCheck(String id, String pwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1;
		String dbPwd = "";
		String sql = "SELECT pwd FROM member WHERE id=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dbPwd = rs.getString("pwd"); // DB에서 조회한 pwd를 dbPwd에 담음
				if(pwd.equals(dbPwd)) 
					result = 1;
				else
					result = 0;
			} else {
				result = -1;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	// 사용자 회원가입시 아이디 중복체크 매서드
	public int confirmId(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1;
		String sql = "SELECT id FROM member WHERE id=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) 
				result = 1; // 입력한 아이디가 기존에 존재하면 1을 반환
			else
				result = -1; // 입력한 아이디가 기존에 없으면 -1을 반환
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	
	// 회원정보를 수정하기 위해 기존의 정보를 조회하는 매서드
	public CustomerVO getMember(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CustomerVO customer = null;
		String sql = "SELECT * FROM member WHERE id=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				customer = new CustomerVO();
				customer.setId(rs.getString("id"));
				customer.setPwd(rs.getString("pwd"));
				customer.setName(rs.getString("name"));
				customer.setReg_date(rs.getTimestamp("reg_date"));
				customer.setAddress(rs.getString("address"));
				customer.setTel(rs.getString("tel"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return customer;
	}
	
	// 회원 정보 수정 매서드
	public void updateMember(CustomerVO customer) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE member SET pwd=?, name=?, address=?, tel=? WHERE id=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, customer.getPwd());
			pstmt.setString(2, customer.getName());
			pstmt.setString(3, customer.getAddress());
			pstmt.setString(4, customer.getTel());
			pstmt.setString(5, customer.getId());
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// 회원 탈퇴하는 매서드
	public int deleteMember(String id, String pwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dbPwd = "";
		String sql = "SELECT pwd FROM member WHERE id=?";
		int result = -1;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dbPwd = rs.getString("pwd"); // DB에서 조회한 pwd를 dbPwd에 담음
				if(pwd.equals(dbPwd)) {
					sql = "DELETE member WHERE id=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					result = 1;
				}
			} else {
				result = -1;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return result;
	}

}
