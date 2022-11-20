package com.ezen.dto;

import java.sql.Timestamp;

public class CustomerVO {
	private String id;  // 사용자 아이디
	private String pwd; // 사용자 패스워드
	private String name; // 사용자 이름
	private Timestamp reg_date; // 사용자 가입일자
	private String tel; // 사용자 전화번호
	private String address; // 사용자 주소
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getReg_date() {
		return reg_date;
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}