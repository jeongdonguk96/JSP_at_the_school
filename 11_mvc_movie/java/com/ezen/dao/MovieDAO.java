package com.ezen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.ezen.dto.MovieVO;
import com.ezen.util.DBManager;


public class MovieDAO {
	private MovieDAO() {}

	private static MovieDAO instance = new MovieDAO();
	
	public static MovieDAO getInstance() {
		return instance;
	}
	
	public List<MovieVO> selectAllMovies() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MovieVO> list = new ArrayList<>();
		String sql = "SELECT * FROM movie ORDER BY code DESC";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MovieVO vo = new MovieVO();
				vo.setCode(rs.getInt("code"));
				vo.setTitle(rs.getString("title"));
				vo.setPrice(rs.getInt("price"));
				vo.setDirector(rs.getString("director"));
				vo.setActor(rs.getString("actor"));
				vo.setPoster(rs.getString("poster"));
				vo.setSynopsis(rs.getString("synopsis"));
				list.add(vo);
			}			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	// 매개변수로 받은 VO 객체를 movie테이블에 추가
	public void insertMovie(MovieVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO movie VALUES(movie_seq.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setString(3, vo.getDirector());
			pstmt.setString(4, vo.getActor());
			pstmt.setString(5, vo.getPoster());
			pstmt.setString(6, vo.getSynopsis());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// 제목으로 해당 영화를 찾아 영화 정보를 VO 객체에 저장한다. 실패:null 반환
	public MovieVO selectOneMovieByTitle(int code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MovieVO vo = null;
		String sql = "SELECT * FROM movie WHERE code=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new MovieVO();
				vo.setCode(rs.getInt("code"));
				vo.setTitle(rs.getString("title"));
				vo.setPrice(rs.getInt("price"));
				vo.setDirector(rs.getString("director"));
				vo.setActor(rs.getString("actor"));
				vo.setSynopsis(rs.getString("synopsis"));
				vo.setPoster(rs.getString("poster"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return vo;
	}
	
	
	// 매개변수로 받은 VO 객체 내의 코드를 조건으로 VO 객체에 저장된 정보로 테이블을 수정한다.
	public void updateMovie(MovieVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE movie SET title=?, price=?, director=?, actor=?, synopsis=?, poster=? WHERE code=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setString(3, vo.getDirector());
			pstmt.setString(4, vo.getActor());
			pstmt.setString(5, vo.getSynopsis());
			pstmt.setString(6, vo.getPoster());
			pstmt.setInt(7, vo.getCode());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// 코드 번호에 해당하는 게시글 정보를 삭제한다.
	public void deleteMovie(int code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE movie WHERE code=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	
}



















