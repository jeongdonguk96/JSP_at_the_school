package com.ezen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ezen.dto.ProductVO;
import util.DBManager;

/*
 * 프로젝트를 할 때는 
 * 1. 오라클로 데이터베이스 생성
 * 2. VO클래스 작성   
 * 3. DAO클래스 
 * 4. DBManager(Connection)클래스 작성까지가 기본 셋팅
 */

public class ProductDAO {
	private ProductDAO() {} // 싱글톤 패턴
	
	private static ProductDAO instance = new ProductDAO();
	
	public static ProductDAO getInstance() {
		return instance;
	}
	
	/*
	 * 상품목록 전체를 조회
	 */
	public List<ProductVO> selectAllProduct() {
		// 1. 커넥션에 필요한 값들 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM product";

		// 상품목록 저장을 위한 변수 생성
		List<ProductVO> list = new ArrayList<ProductVO>();
		
		try {
			conn = DBManager.getConnection(); 
			pstmt = conn.prepareStatement(sql); // SQL문 실행을 위한 Statement 객체 생성(실행권한을 얻음)
			rs = pstmt.executeQuery(); // SQL문을 실행, 결과를 ResultSet의 객체(rs)에 담음
			
			while(rs.next()) {
				ProductVO productVO = new ProductVO();
				productVO.setCode(rs.getInt("code"));
				productVO.setName(rs.getString("name"));
				productVO.setPrice(rs.getInt("price"));
				productVO.setDescription(rs.getString("description"));
				productVO.setPictureurl(rs.getString("pictureurl"));
				list.add(productVO);
			} 
		} catch(Exception e) {
				e.printStackTrace(); 
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	public void insertProduct(ProductVO productVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO product VALUES (product_sqe.NEXTVAL, ?, ?, ?, ?)";

		try {
			conn = DBManager.getConnection(); 
			pstmt = conn.prepareStatement(sql); // SQL문 실행을 위한 Statement 객체 생성(실행권한을 얻음)
			pstmt.setString(1, productVO.getName());
			pstmt.setInt(2, productVO.getPrice());
			pstmt.setString(3, productVO.getPictureurl());
			pstmt.setString(4, productVO.getDescription());
			pstmt.executeUpdate();
		} catch(Exception e) {
				e.printStackTrace(); 
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public ProductVO selectProductByCode(int code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVO productVO = null;
		String sql = "SELECT * FROM product WHERE code=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				productVO = new ProductVO();
				productVO.setCode(rs.getInt("code"));
				productVO.setName(rs.getString("name"));
				productVO.setPrice(rs.getInt("price"));
				productVO.setPictureurl(rs.getString("pictureurl"));
				productVO.setDescription(rs.getString("description"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return productVO;
	}
	
	public void updateProduct(ProductVO productVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE product SET name=?, price=?, pictureurl=?, description=? WHERE code=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productVO.getName());
			pstmt.setInt(2, productVO.getPrice());
			pstmt.setString(3, productVO.getPictureurl());
			pstmt.setString(4, productVO.getDescription());
			pstmt.setInt(5, productVO.getCode());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			 DBManager.close(conn, pstmt);
		}
	}
	
	public void deleteProduct(int code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM product WHERE code=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
}
