package com.ezen.controller.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.dao.ShopBookDAO;
import com.ezen.dto.ShopBookVO;


public class ManagerLoginAction implements Action {

//	@Override
//	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String url = "manager/logon/managerLoginForm.jsp";
//		String id = "bookmaster@shop.com";
//		String pwd = "123456";
//		String param_id = request.getParameter("id");
//		String param_pwd = request.getParameter("pwd");
//		
//		if(id.equals(param_id) && pwd.equals(param_pwd)) {
//			url = "manager/managerMain.jsp";
//		}
//
//		request.getRequestDispatcher(url).forward(request, response);
//	}
	
	//유저나 관리자 정보가 있어야 완성되는 부분!!
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "manager/logon/managerLoginForm.jsp";
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		ShopBookDAO dao = ShopBookDAO.getInstance();
		int result = dao.managerCheck(id, pwd);
		
		if(result == 1) {
			System.out.println("정상 로그인입니다.\n");
			// 1. 정상 로그인시 사용자 정보 조회
			ShopBookVO book = new ShopBookVO();
			// 2. 세션 내장객체에 사용자 정보 저장 (로그인 시에 세션이 할당되는데 그 세션에 정보를 저장)
			HttpSession session = request.getSession(); // 세션을 생성하고 세션 객체에 저장
			session.setAttribute("admin", book); // 사용자 정보를 세션 속성 loginUser에 저장
			url = "manager/managerMain.jsp"; // 로그인 성공시에만 url을 main.jsp로 바꿈 
		} else if(result == 0) {
			System.out.println("비밀번호가 틀렸습니다.\n");
			request.setAttribute("message", "비밀번호가 틀렸습니다.");
		} else {
			System.out.println("아이디가 존재하지 않습니다.\n");
			request.setAttribute("message", "아이디가 존재하지 않습니다.");
		}

		request.getRequestDispatcher(url).forward(request, response);
	}

}