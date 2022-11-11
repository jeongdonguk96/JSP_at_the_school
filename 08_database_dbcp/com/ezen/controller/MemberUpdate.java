package com.ezen.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.dao.MemberDAO;
import com.ezen.dto.MemberVO;

@WebServlet("/memberUpdate.do")
public class MemberUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String url = "member/memberUpdate.jsp";
		
		MemberDAO memberDao = MemberDAO.getInstance();
		MemberVO memberVo = memberDao.getMember(userid);
		
		request.setAttribute("memberVo", memberVo);
		request.getRequestDispatcher(url).forward(request, response);;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // utf-8로 인코딩 변환
		MemberVO memberVo = new MemberVO();
		
		// 회원정보수정 화면에서 입력받은 정보를 MemberVO 객체에 저장
		memberVo.setName(request.getParameter("name"));
		memberVo.setUserid(request.getParameter("userid"));
		memberVo.setPwd(request.getParameter("pwd"));
		memberVo.setEmail(request.getParameter("email"));
		memberVo.setPhone(request.getParameter("phone"));
		memberVo.setAdmin(Integer.parseInt(request.getParameter("admin")));
		
		MemberDAO memberDao = MemberDAO.getInstance();
		int result = memberDao.updateMember(memberVo);
		
		// 회원정보를 수정하면 그 회원의 세션도 새로 수정해주어야 함
		if(result>0) { // executeUpdate가 성공하면 변경한 행의 수만큼의 값을 리턴함
			HttpSession session = request.getSession(); // 세션 가져와서
			session.setAttribute("loginUser", memberVo); // 세션 설정
		}
		response.sendRedirect("login.do"); // login.do는 상황에 따라 여러 페이지를 보여줄 수 있는 파일
	}

}
