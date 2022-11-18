package com.ezen.dao;

public class CustomerDAO {
	private CustomerDAO() {}
	private static CustomerDAO instance = new CustomerDAO();
	public static CustomerDAO getInstance() {
		return instance;
	}
	
	
}
