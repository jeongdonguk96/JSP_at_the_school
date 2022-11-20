package com.ezen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.ezen.dto.BuyVO;
import com.ezen.dto.CartVO;
import com.ezen.util.DBManager;

public class BuyDAO {
	private BuyDAO() {}
	private static BuyDAO instance = new BuyDAO();
	public static BuyDAO getInstance() {
		return instance;
	}
	
	// bank테이블에 있는 전체 레코드를 얻어내는 매서드
	public List<String> getAccount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String> accountList = null;
		String sql = "SELECT * FROM bank";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			accountList = new ArrayList<>();
			
			while(rs.next()) {
				String account = new String(rs.getString("account") + "-" + rs.getString("bank") + "-" + rs.getString("name"));
			
				accountList.add(account);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return accountList;
	}
	
	// buy테이블에 구매목록 등록
	public void insertBuy(List<CartVO> cartList, String id, String account, String deliveryName, String deliveryTel, String deliveryAddress) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Timestamp  reg_date = null;
		String maxDate = "";
		String number = "";
		String todayDate = "";
		String compareDate = "";
		int buyId = 0;
		short nowCount;
		String sql = "SELECT max(buy_id) FROM buy";
		
		try {
			conn = DBManager.getConnection();
			reg_date = new Timestamp(System.currentTimeMillis());
			todayDate = reg_date.toString();
			compareDate = todayDate.substring(0, 4) + todayDate.substring(5, 7) + todayDate.substring(8, 10);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			rs.next();
			if(rs.getLong(1)>0) {
				Long val = new Long(rs.getLong(1));
				maxDate = val.toString().substring(0, 8);
				number = val.toString().substring(8);
				if(compareDate.equals(maxDate)) {
					if(Integer.parseInt(number)+1<10000)
						buyId = Integer.parseInt(maxDate) + (Integer.parseInt(number)+1+10000);
					else
						buyId = Integer.parseInt(maxDate) + (Integer.parseInt(number)+1);
				} else {
					compareDate += "00001";
					buyId = Integer.parseInt(compareDate);
				}
			} else {
				compareDate += "00001";
				buyId = Integer.parseInt(compareDate);
			}
			// 여기 88번 줄부터 132번 줄까지 하나의 트랜잭션으로 처리
			conn.setAutoCommit(false);
			for(int i=0; i<cartList.size(); i++) {
				// 해당 아이디에 대한 cart테이블 레코드를 가져온 후 buy테이블에 추가
				CartVO cart = cartList.get(i);
				// buy테이블에 sancion제외 모두
				sql = "INSERT INTO buy(buy_id, buyer, book_id, book_title, buy_price, buy_count, book_image, buy_date, account, deliveryName, deliveryTel, deliveryAddress) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, buyId);
				pstmt.setString(2, id);
				pstmt.setInt(3, cart.getBook_id());
				pstmt.setString(4, cart.getBook_title());
				pstmt.setInt(5, cart.getBuy_price());
				pstmt.setInt(6, cart.getBuy_count());
				pstmt.setString(7, cart.getBook_image());
				pstmt.setTimestamp(8, reg_date);
				pstmt.setString(9, account);
				pstmt.setString(10, deliveryName);
				pstmt.setString(11, deliveryTel);
				pstmt.setString(22, deliveryAddress);
				
				pstmt.executeUpdate();
				
				// 상품이 구매되었으므로 book테이블의 상품수량을 재조정
				sql = "SELECT book_count FROM book WHERE book_id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, cart.getBook_id());
				rs = pstmt.executeQuery();
				rs.next();
				
				nowCount = (short)(rs.getShort(1) - cart.getBuy_count());
				
				sql = "UPDATE book SET book_count=? WHERE book_id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setShort(1, nowCount);
				pstmt.setInt(2, cart.getBook_id());
				pstmt.executeUpdate();
			}
			
			sql = "DELETE cart WHERE buyer=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
			conn.commit();
			conn.setAutoCommit(true);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return ;
	}
	
	// id에 해당하는 buy테이블의 레코드수를 얻어내는 매서드
	public int getListCount(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1;
		String sql = "SELECT count(*) FROM buy WHERE buyer=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	// buy테이블의 전체 레코드 수를 얻어내는 매서드
	public int getListCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1;
		String sql = "SELECT count(*) FROM buy";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	// id에 해당하는 buy테이블의 구매목록을 얻내는 매서드
	public List<BuyVO> getBuyList(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BuyVO buy = null;
		List<BuyVO> buyList = null;
		String sql = "SELECT * FROM buy WHERE buyer=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			buyList = new ArrayList<>();
			
			while(rs.next()) {
				buy = new BuyVO();
				buy.setBuy_id(rs.getInt("buy_id"));
				buy.setBook_id(rs.getInt("book_id"));
				buy.setBook_title(rs.getString("book_title"));
				buy.setBuy_price(rs.getInt("buy_price"));
				buy.setBuy_count(rs.getInt("buy_count"));
				buy.setBook_image(rs.getString("book_image"));
				buy.setSanction(rs.getString("sanction"));
				
				buyList.add(buy);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return buyList;
	}
	
	
	// buy테이블의 전체 목록을 얻어내는 매서드
	public List<BuyVO> getBuyList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BuyVO buy = null;
		List<BuyVO> buyList = null;
		String sql = "SELECT * FROM buy";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			buyList = new ArrayList<>();
			
			while(rs.next()) {
				buy = new BuyVO();
				buy.setBuy_id(rs.getInt("buy_id"));
				buy.setBuyer(rs.getString("buyer"));
				buy.setBook_id(rs.getInt("book_id"));
				buy.setBook_title(rs.getString("book_title"));
				buy.setBuy_price(rs.getInt("buy_price"));
				buy.setBuy_count(rs.getInt("buy_count"));
				buy.setBook_image(rs.getString("book_image"));
				buy.setBuy_date(rs.getTimestamp("buy_date"));
				buy.setAccount(rs.getString("account"));
				buy.setDeliveryName(rs.getString("deliveryName"));
				buy.setDeliveryTel(rs.getString("deliveryTel"));
				buy.setDeliveryAddress(rs.getString("deliveryAddress"));
				buy.setSanction(rs.getString("sanction"));
				
				buyList.add(buy);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return buyList;
	}
}











