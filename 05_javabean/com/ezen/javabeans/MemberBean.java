package com.ezen.javabeans;

public class MemberBean { // 정보를 하나의 클래스로 묶음, private로 은닉 후 getter, setter로 접근
	private String name;  // 변수, 매서드를 나열하는 범위를 필드라 하지 않고 프로퍼티라는 용어로 사용함
	private String userid;
	private String nickname;
	private String pwd;
	private String email;
	private String phone;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
