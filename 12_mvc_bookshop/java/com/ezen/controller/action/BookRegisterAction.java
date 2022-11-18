package com.ezen.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.ShopBookDAO;
import com.ezen.dto.ShopBookVO;

public class BookRegisterAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "manager/productProcess/bookList.jsp";
		
		ShopBookVO book = (ShopBookVO)request.getAttribute("book");
		
		ShopBookDAO dao = ShopBookDAO.getInstance();

		dao.insertBook(book);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
