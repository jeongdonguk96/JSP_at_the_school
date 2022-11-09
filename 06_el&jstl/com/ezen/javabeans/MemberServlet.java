package com.ezen.javabeans;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberBean member1 = new MemberBean("홍길동", "hong"); // 파라미터 생성자로 member1 생성
		request.setAttribute("member", member1); // member1을 member의 속성으로 저장
											     // 이제는 프로퍼티 단위로 주는 게 아니라 객체 전체를 주는 식
		
		RequestDispatcher rd = request.getRequestDispatcher("06_member_info.jsp"); // 위에서 저장한 정보를 jsp로 이동하게끔, 그걸 rd에 담음
		rd.forward(request, response); // 즉 이 서블릿을 실행하면 위에 담긴 정보를 가지고 jsp페이지에서 출력
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
