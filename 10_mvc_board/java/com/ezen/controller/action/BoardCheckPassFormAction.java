package com.ezen.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 게시글 수정, 삭제하기 위한 비밀번호 확인창을 출력하는 클래스
 */
public class BoardCheckPassFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "board/boardCheckPass.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
