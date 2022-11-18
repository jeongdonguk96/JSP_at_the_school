package com.ezen.dao;

public class CartDAO {
	private CartDAO() {}
	private static CartDAO instance = new CartDAO();
	public static CartDAO getInstance() {
		return instance;
	}
	
	
}
