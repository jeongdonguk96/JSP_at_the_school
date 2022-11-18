package com.ezen.dao;

public class BuyDAO {
	private BuyDAO() {}
	private static BuyDAO instance = new BuyDAO();
	public static BuyDAO getInstance() {
		return instance;
	}
	
	
}
