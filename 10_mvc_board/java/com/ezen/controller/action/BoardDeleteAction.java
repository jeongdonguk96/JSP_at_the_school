package com.ezen.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.BoardDAO;

/*
 * 게시글 삭제를 위한 클래스
 */
public class BoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 게시글 번호를 파라미터로 읽어 변수에 담는다.
		int num = Integer.parseInt(request.getParameter("num"));
		
		// 2. BoardDAO 인스턴스를 생성, 게시글 번호를 매개변수로 deleteBoard() 매서드 호출
		BoardDAO dao = BoardDAO.getInstance();
		dao.deleteBoard(num);
		
		// 3. BoardListAction()을 호출해 게시글 목록 표시
		new BoardListAction().execute(request, response);
	}

}
