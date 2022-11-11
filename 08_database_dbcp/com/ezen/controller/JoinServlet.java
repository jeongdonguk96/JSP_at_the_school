package com.ezen.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.MemberDAO;
import com.ezen.dto.MemberVO;

@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/join.jsp"; // join 화면의 jsp 주소를 url에 담음 

		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // utf-8로 인코딩 변환
		String url = "member/join.jsp"; // join 화면의 jsp 주소를 url에 담음 
		MemberVO memberVo = new MemberVO();
		
		// 회원가입 화면에서 입력받은 정보를 MemberVO 객체에 저장
		memberVo.setName(request.getParameter("name"));
		memberVo.setUserid(request.getParameter("userid"));
		memberVo.setPwd(request.getParameter("pwd"));
		memberVo.setEmail(request.getParameter("email"));
		memberVo.setPhone(request.getParameter("phone"));
		memberVo.setAdmin(Integer.parseInt(request.getParameter("admin")));
		
		MemberDAO memberDao = MemberDAO.getInstance();
		int result = memberDao.insertMember(memberVo);
		
		if(result == 1) {
			url = "main.jsp";
			System.out.println("회원 가입 성공!!");
			request.setAttribute("message", "회원 가입 성공!!");
		} else {
			System.out.println("회원 가입 실패..");
			request.setAttribute("message", "회원 가입 실패..");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
