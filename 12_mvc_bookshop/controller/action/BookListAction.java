package com.ezen.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.ShopBookDAO;
import com.ezen.dto.ShopBookVO;


public class BookListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "manager/productProcess/bookList.jsp";
		
		// 1. DAO 객체를 생성, 책을 조회하는 selectAllBooks() 매서드를 호출
		ShopBookDAO dao = ShopBookDAO.getInstance();
		List<ShopBookVO> bookList = dao.selectAllBooks();	
		
		// 2. 조회한 목록을 request 객체의 "book" 속성에 저장
		request.setAttribute("bookList", bookList);
		
		// 3. RequestDispatcher 객체를 이용해 forward
		request.getRequestDispatcher(url).forward(request, response);
	}

}