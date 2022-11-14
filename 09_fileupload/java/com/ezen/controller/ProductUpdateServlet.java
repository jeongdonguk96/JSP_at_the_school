package com.ezen.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.ProductDAO;
import com.ezen.dto.ProductVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/productUpdate.do")
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "product/productUpdate.jsp";
		int code = Integer.parseInt(request.getParameter("code"));
		
		// 코드의 값을 매개로 상품 조회
		ProductDAO productDAO = ProductDAO.getInstance();
		ProductVO productVO = productDAO.selectProductByCode(code);
		
		// request 내장 객체에 상품 정보 저장
		request.setAttribute("product", productVO);
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // utf-8로 인코딩 변환
		String url = "productList.do";
		
		// 첨부파일 정보 얻기
		ServletContext context = getServletContext(); // 프로젝트의 정보를 얻어오기
		String savePath = "upload"; // 업로드 파일을 저장할 폴더를 savePath로 담음
		String realPath = context.getRealPath(savePath);
		int maxSize = 5 * 1024 * 1024; // 5MB, 기본이 Byte인데 1024를 곱해주면 단위가 하나씩 늠
		String encType = "utf-8"; // 인코딩 방식을 encType에 담음
		MultipartRequest multi = new MultipartRequest(request, realPath, maxSize, encType, new DefaultFileRenamePolicy());
		
		// 입력한 데이터를 productVO 객체에 자정 
		ProductVO productVO = new ProductVO();
		productVO.setCode(Integer.parseInt(multi.getParameter("code")));
		productVO.setName(multi.getParameter("name"));
		productVO.setPrice(Integer.parseInt(multi.getParameter("price")));
		String picture = multi.getFilesystemName("pictureurl"); // pictureurl의 파일명 읽어오기
		productVO.setPictureurl(picture);
		productVO.setDescription(multi.getParameter("description"));
		
		// 사용자가 상품이미지를 변경하지 않았을 경우 처리
		if(picture == null ) {
			productVO.setPictureurl(multi.getParameter("noupdateImg"));
		} else {
			productVO.setPictureurl(picture);
		}
		
		// DB에 상품정보 수정
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.updateProduct(productVO);
		
		// 확인을 위해 상품목록 출력 요청 - forward를 해주면 안됨 (글쓰기나 회원가입 등 시스템에 변화가 생기는 경우는 reRirect사용
		response.sendRedirect(url);
	}

}
