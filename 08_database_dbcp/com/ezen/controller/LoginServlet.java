package com.ezen.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.dao.MemberDAO;
import com.ezen.dto.MemberVO;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Login 화면 출력
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/login.jsp"; // login 화면의 jsp 주소를 url에 담음 

		// 이미 로그인된 사용자면 main.jsp로 바로 이동
		HttpSession session = request.getSession(); // 세션을 생성하고 세션 객체에 저장
		MemberVO memberVo = (MemberVO)session.getAttribute("loginUser"); // loginUser 정보를 memberVo에 담음 
		if(memberVo != null) { // 로그인 되어 있는 사용자면 url이 main.jsp로 바꿈
			url = "main.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(url); // 주소를 rd에 담음
		rd.forward(request, response); // 리퀘스트, 리스폰스 객체를 login.jsp에 넘겨줌
	}
	
	// 사용자 인증 수행
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // utf-8로 인코딩 변환
		String url = "member/login.jsp"; // login 화면의 jsp 주소를 url에 담음
		
		// 로그인 화면에서 입력한 데이터 읽어오기
		String userid = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// DAO를 통해 사용자 검증
		MemberDAO memberDao = MemberDAO.getInstance(); // DAO 객체 불러오기
		int status = memberDao.userCheck(userid, pwd); // DAO의 userCheck 매서드를 status에 담음
		
		if(status == 1) {
			System.out.println("정상 로그인입니다.");
			// 1. 정상 로그인시 사용자 정보 조회
			MemberVO memberVo = memberDao.getMember(userid);
			// 2. 세션 내장객체에 사용자 정보 저장 (로그인 시에 세션이 할당되는데 그 세션에 정보를 저장)
			HttpSession session = request.getSession(); // 세션을 생성하고 세션 객체에 저장
			session.setAttribute("loginUser", memberVo); // 사용자 정보를 세션 속성 loginUser에 저장
			url = "main.jsp"; // 로그인 성공시에만 url을 main.jsp로 바꿈 
		} else if(status == 0 ) {
			System.out.println("비밀번호가 틀렸습니다.");
			request.setAttribute("message", "비밀번호가 틀렸습니다.");
		} else {
			System.out.println("아이디가 존재하지 않습니다.");
			request.setAttribute("message", "아이디가 존재하지 않습니다.");
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	}
}
