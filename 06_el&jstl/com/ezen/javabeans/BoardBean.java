package com.ezen.javabeans;

public class BoardBean {
	private int	num;
	private String writer;
	private String email;
	private String title;
	private String content;
	private String writedate;
	
	public BoardBean() {
	}
	
	public BoardBean(int num, String writer, String email, String title, String content, String writedate) {
		this.num = num;
		this.writer = writer;
		this.email = email;
		this.title = title;
		this.content = content;
		this.writedate = writedate;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
}

