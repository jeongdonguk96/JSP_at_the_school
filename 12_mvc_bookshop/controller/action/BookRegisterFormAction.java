package com.ezen.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.ShopBookDAO;
import com.ezen.dto.ShopBookVO;

public class BookRegisterFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "manager/productProcess/bookRegisterForm.jsp";
		
		ShopBookDAO dao = ShopBookDAO.getInstance();
		List<ShopBookVO> bookList = dao.selectAllBooks();
		
		request.setAttribute("book", bookList);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}