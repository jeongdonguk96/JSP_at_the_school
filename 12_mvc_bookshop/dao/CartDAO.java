package com.ezen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ezen.dto.CartVO;
import com.ezen.util.DBManager;

public class CartDAO {
	private CartDAO() {}
	private static CartDAO instance = new CartDAO();
	public static CartDAO getInstance() {
		return instance;
	}
	
	// [장바구니에 담기]를 클릭하면 cart테이블에 새로운 레코드를 추가하는 매서드.
	public void insertCart(CartVO cart) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO cart VALUES(cart_seq.NEXTVAL, ?, ?, ?, ?, ?, ?)";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cart.getBuyer());
			pstmt.setInt(2, cart.getBook_id());
			pstmt.setString(3, cart.getBook_title());
			pstmt.setInt(4, cart.getBuy_price());
			pstmt.setInt(5, cart.getBuy_count());
			pstmt.setString(6, cart.getBook_image());
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// id에 해당하는 장바구니에 담긴 품목의 수를 알아내는 매서드
	public int getListCount(String buyer) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1;
		String sql = "SELECT count(*) FROM cart WHERE buyer=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, buyer);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	// id에 해당하는 레코드의 목록을 얻어내는 매서드
	public List<CartVO> getCart(String buyer) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CartVO cart = null;
		List<CartVO> cartList = null;
		int result = -1;
		String sql = "SELECT * FROM cart WHERE buyer=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, buyer);
			rs = pstmt.executeQuery();
			cartList = new ArrayList<>();
			
			if(rs.next()) {
				cart = new CartVO();
				cart.setCart_id((rs.getInt("cart_id")));
				cart.setBuyer((rs.getString("buyer")));
				cart.setBook_id((rs.getInt("book_id")));
				cart.setBook_title((rs.getString("book_title")));
				cart.setBuy_price((rs.getInt("buy_price")));
				cart.setBuy_count((rs.getInt("buy_count")));
				cart.setBook_image((rs.getString("book_image")));
				
				cartList.add(cart);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		return cartList;
	}
	
	// 장바구니에서 수랴을 수정할 때 실행하는 매서드
	public void updateCount(int cart_id, int count) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE cart SET buy_count=? WHERE cart_id=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, count);
			pstmt.setInt(2, cart_id);
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// 장바구니에서 cart_id에 대한 레코드를 삭제하는 매서드
	public void deleteCount(int cart_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE cart WHERE cart_id=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cart_id);
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// [장바구니 비우기]를 클릭시, id에 해당하는 모든 레코드를 삭제하는 매서드
	public void deleteAll(String buyer) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE cart WHERE buyer=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, buyer);
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
}
