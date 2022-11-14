package com.ezen.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.ProductDAO;
import com.ezen.dto.ProductVO;

@WebServlet("/productDelete.do")
public class ProductDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = "product/productDelete.jsp";
		int code = Integer.parseInt(request.getParameter("code"));
		
		ProductDAO productDAO = ProductDAO.getInstance();
		ProductVO productVO = productDAO.selectProductByCode(code);
		request.setAttribute("product", productVO);
		request.getRequestDispatcher(sql).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = "productList.do";
		int code = Integer.parseInt(request.getParameter("code"));
		
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.deleteProduct(code);
		
		response.sendRedirect(sql);
	}

}
