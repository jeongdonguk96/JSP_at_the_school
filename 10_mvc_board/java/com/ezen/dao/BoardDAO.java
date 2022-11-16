package com.ezen.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ezen.dto.BoardVO;

import util.DBManager;

public class BoardDAO {
	private BoardDAO() {}
	
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	// 최근 등록한 게시물이 먼저 나오도록 게시판 조회
	public List<BoardVO> selectAllBoards() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM board ORDER BY num desc";
		
		List<BoardVO> list = new ArrayList<>();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setWritedate(rs.getDate("writedate"));
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	// 매개변수로 받은 VO 객체를 board테이블에 추가
	public void insertBoard(BoardVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO board VALUES (product_sqe.NEXTVAL, ?, ?, ?, ?, ?, ?, SYSDATE)";
		// 어차피 조회수랑 작성일은 디폴트 값인데 왜 일일이 지정해줘야 하냐면
		// board테이블에 통으로 값을 넣는 거기 때문에 값을 다 지정해 줘야함.
		// 만약 INTO board에 (num, pass, name, ...) 이런 식으로 컬럼을 지정해준다면 필요한 컬럼만 수정 가능
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPass());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getTitle());
			pstmt.setString(5, vo.getContent());
			pstmt.setInt(6, vo.getReadcount());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// 게시글 조회마다 글 번호를 증가시킨다.
	public void updateReadCount(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE board SET readcount=readcount+1 WHERE num=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// 게시물 번호로 해당 게시물을 찾아 게시물 정보를 BoardVO 객체에 저장한다. 실패:null 반환
	public BoardVO selectOneBoardByNum(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO vo = null;
		String sql = "SELECT * FROM board WHERE num=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {		
				vo = new BoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setContent(rs.getString("content"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setWritedate(rs.getDate("writedate"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
	}
	
	// 매개변수로 받은 VO 객체 내의 코드를 조건으로 VO 객체에 저장된 정보로 테이블을 수정한다.
	public void updateBoard(BoardVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE board SET pass=?, name=?, email=?, title=?, content=? WHERE num=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPass());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getTitle());
			pstmt.setString(5, vo.getContent());
			pstmt.setInt(6, vo.getNum());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// 게시글 번호와 비밀번호가 일치하는 게시글을 테이블에서 조회해 BoardVO 객체로 반환
	public BoardVO checkPassword(String pass, int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM board WHRER num=? AND pass=?";
		BoardVO vo = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pass);
			pstmt.setInt(2, num);
			rs = pstmt.executeQuery();
			
			vo = new BoardVO();
			vo.setNum(rs.getInt("num"));
			vo.setPass(rs.getString("pass"));
			vo.setName(rs.getString("name"));
			vo.setEmail(rs.getString("email"));
			vo.setTitle(rs.getString("title"));
			vo.setContent(rs.getString("content"));
			vo.setReadcount(rs.getInt("readcount"));
			vo.setWritedate(rs.getDate("writedate"));
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, null);
		}
		return vo;
	}
	
	// 게시글 번호에 해당하는 게시글 정보를 삭제
	public void deleteBoard(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE board WHERE num=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
}










