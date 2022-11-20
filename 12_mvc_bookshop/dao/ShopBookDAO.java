package com.ezen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ezen.dto.ShopBookVO;
import com.ezen.util.DBManager;

public class ShopBookDAO {
	private ShopBookDAO() {}
	private static ShopBookDAO instance = new ShopBookDAO();
	public static ShopBookDAO getInstance() {
		return instance;
	}
	
	// 관리자 로그인 인증 매서드
	public int managerCheck(String id, String pwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT managerPwd FROM manager WHERE managerId=?";
		String dbPwd = "";
		int result = -1;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dbPwd = rs.getString("managerPwd"); // DB에 등록된 관리자 비밀번호
				
				if(dbPwd.equals(pwd)) // 등록된 비밀번호와 파라입력한 번호가 같다면
					result = 1; // 인증 성공
				 else 
					result = 0; // 아이디는 맞지만 패스워드 틀림
			} else {
				result = -1; // 해당 아이디 없음
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return result;	
	}
	
	// 책 목록을 조회하는 매서드
	public List<ShopBookVO> selectAllBooks() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ShopBookVO> bookList = new ArrayList<>();
		String sql = "SELECT * FROM book ORDER BY reg_date DESC";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ShopBookVO book = new ShopBookVO();
				book.setBook_id(rs.getInt("book_id"));
				book.setBook_kind(rs.getString("book_kind"));
				book.setBook_title(rs.getString("book_title"));
				book.setBook_price(rs.getInt("book_price"));
				book.setBook_count(rs.getInt("book_count"));
				book.setAuthor(rs.getString("author"));
				book.setPublishing_com(rs.getString("publishing_com"));
				book.setPublishing_date(rs.getString("publishing_date"));
				book.setBook_image(rs.getString("book_image"));
				book.setDiscount_rate(rs.getDouble("discount_rate"));
				book.setReg_date(rs.getTimestamp("reg_date"));

				bookList.add(book);
			}			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return bookList;
	}
	
	// 책 등록 매서드
	public void insertBook(ShopBookVO book) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO book VALUES(book_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getBook_kind());
			pstmt.setString(2, book.getBook_title());
			pstmt.setInt(3, book.getBook_price());
			pstmt.setInt(4, book.getBook_count());
			pstmt.setString(5, book.getAuthor());
			pstmt.setString(6, book.getPublishing_com());
			pstmt.setString(7, book.getPublishing_date());
			pstmt.setString(8, book.getBook_image());
			pstmt.setString(9, book.getBook_content());
			pstmt.setDouble(10, book.getDiscount_rate());
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// 등록된 모든 책의 수량을 얻어내는 매서드
	public int getBookCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT count(*) FROM book"; // 책의 수량을 파악하는 sql문
		int result = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1); // 파라미터의 1은 첫번째 컬럼이라는 의미. 첫 컬럼이 book_id니까 이 컬럼을 count하면
									   // 전체 수량이 나오고 그 값을 result에 담으면 result에는 책의 전체 수량이 담기게 됨
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	
	// 분류별 또는 전체 등록된 책의 정보를 얻어내는 매서드
	public List<ShopBookVO> getBooks(String book_kind) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ShopBookVO> bookList = null;
		ShopBookVO book = null;
		String sql1 = "SELECT * FROM book"; // 전체 책을 조회하는 sql문
		String sql2 = "SELECT * FROM book WHERE book_kind=? ORDER BY reg_date DESC"; // 입력된 분류의 책을 조회하는 sql문
		
		try {
			conn = DBManager.getConnection();
			
			if(book_kind.equals("all")) { // 전체 책 조회인 경우
				pstmt = conn.prepareStatement(sql1);
			} else {					  // 특정 분류의 책 조회인 경우
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, book_kind);
			}
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				bookList = new ArrayList<>();
				book = new ShopBookVO();
					
				book.setBook_id(rs.getInt("book_id"));
				book.setBook_kind(rs.getString("book_kind"));
				book.setBook_title(rs.getString("book_title"));
				book.setBook_price(rs.getInt("book_price"));
				book.setBook_count(rs.getInt("book_count"));
				book.setAuthor(rs.getString("author"));
				book.setPublishing_com(rs.getString("publishing_com"));
				book.setPublishing_date(rs.getString("publishing_date"));
				book.setBook_image(rs.getString("book_image"));
				book.setDiscount_rate(rs.getDouble("discount_rate"));
				book.setReg_date(rs.getTimestamp("reg_date"));
					
				bookList.add(book);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return bookList;
	}
	
	// 쇼핑몰 메인에 표시하기 위해 사용하는 분류별 신간 책목록을 얻어내는 매서드
	public ShopBookVO[] getBooks(String book_kind, int count) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ShopBookVO book = null;
		ShopBookVO bookList[] = null;
		String sql = "SELECT * FROM book WHERE book_kind=? ORDER BY reg_date DESC LIMIT ?, ?";
		int i = 0;
				
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book_kind);
			pstmt.setInt(2, 0);  
			pstmt.setInt(3, count); // 최신 순으로 입력받은 count개 까지의 책을 보여주도록 하는 로직
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				bookList = new ShopBookVO[count]; // count개 만큼의 배열 만들기
				book = new ShopBookVO();
					
				book.setBook_id(rs.getInt("book_id"));
				book.setBook_kind(rs.getString("book_kind"));
				book.setBook_title(rs.getString("book_title"));
				book.setBook_price(rs.getInt("book_price"));
				book.setBook_count(rs.getInt("book_count"));
				book.setAuthor(rs.getString("author"));
				book.setPublishing_com(rs.getString("publishing_com"));
				book.setPublishing_date(rs.getString("publishing_date"));
				book.setBook_image(rs.getString("book_image"));
				book.setDiscount_rate(rs.getDouble("discount_rate"));
				book.setReg_date(rs.getTimestamp("reg_date"));
					
				bookList[i] = book; // book.set으로 설정한 값을 count횟수까지 배열에 넣기
				i++; // 한 반복이 끝나면 배열 인덱스는 증가
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return bookList;
	}
	
	// 책의 등록번호를 매개로 책의 정보를 찾아내는 매서드로, 등록된 책을 수정하기 위해 수정폼으로 읽어들이기 위한 매서드
	public ShopBookVO getBook(int bookId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ShopBookVO book = null;
		String sql = "SELECT * FROM book WHERE book_id=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookId);
			book = new ShopBookVO();
			rs = pstmt.executeQuery();

			if(rs.next()) {
				book.setBook_kind(rs.getString("book_kind"));
				book.setBook_title(rs.getString("book_title"));
				book.setBook_price(rs.getInt("book_price"));
				book.setBook_count(rs.getInt("book_count"));
				book.setAuthor(rs.getString("author"));
				book.setPublishing_com(rs.getString("publishing_com"));
				book.setPublishing_date(rs.getString("publishing_date"));
				book.setBook_image(rs.getString("book_image"));
				book.setBook_content(rs.getString("book_content"));
				book.setDiscount_rate(rs.getDouble("discount_rate"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return book;
	}
	
	// 책의 등록번호를 매개로 책의 정보를 수정하는 매서드
	public void updateBook(ShopBookVO book, int bookId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE book SET book_kind=?, book_title=?, book_price=?, book_count=?, author=?, publishing_com=?, publishing_date=?, book_image=?, book_content=?, discount_rate=? WHERE book_id=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getBook_kind());
			pstmt.setString(2, book.getBook_title());
			pstmt.setInt(3, book.getBook_price());
			pstmt.setInt(4, book.getBook_count());
			pstmt.setString(5, book.getAuthor());
			pstmt.setString(6, book.getPublishing_com());
			pstmt.setString(7, book.getPublishing_date());
			pstmt.setString(8, book.getBook_image());
			pstmt.setString(9, book.getBook_content());
			pstmt.setDouble(10, book.getDiscount_rate());
			pstmt.setInt(11, bookId);

			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// 책의 등록번호를 매개로 책의 정보를 삭제하는 매서드
	public void deleteBook(int bookId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE book WHERE book_id=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookId);
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
}