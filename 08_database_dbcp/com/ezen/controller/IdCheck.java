package com.ezen.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.MemberDAO;


@WebServlet("/idCheck.do")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 화면에서 사용자 ID 파라미터를 읽어오기
		String userid = request.getParameter("userid");
		String url = "member/idCheck.jsp";
		// 2. 사용자 ID를 데이터베이스(MemberDAO.userCheck())에서 조회, 변수 status에 저장
		MemberDAO memberDao = MemberDAO.getInstance(); // DAO 객체 불러오기
		int status = memberDao.confirmId(userid); // 입력받은 userid를 confirm 매서드를 통해 1 혹은 -1가 나온 값을 status에 담음
		// 3. idCheck.jsp로 결과를 넘겨주기 전에 request 객체에 저장(userid, result)
		request.setAttribute("userid", userid); // 입력받은 userid를 리퀘스트의 속성 "userid"에 저장
		request.setAttribute("result", status); // 저장한 status를 리퀘스트의 속성 "result"에 저장
		// 4. idCheck.jsp 호출
		request.getRequestDispatcher(url).forward(request, response);;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
