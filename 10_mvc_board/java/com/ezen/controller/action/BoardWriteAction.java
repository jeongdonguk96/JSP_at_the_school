package com.ezen.controller.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.BoardDAO;
import com.ezen.dto.BoardVO;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. BoardVO 객체 생성
		BoardVO vo = new BoardVO();
		
		// 2. 화면에 입력받은 파라미터를 BoardVO 객체에 저장
		vo.setName(request.getParameter("name"));
		vo.setPass(request.getParameter("pass"));
		vo.setEmail(request.getParameter("email"));
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		
		// 3. DB작업을 위해 BoardDAO 객체 생성, inserBoard() 매서드 호출, DB에 게시글 저장
		BoardDAO dao = BoardDAO.getInstance();
		dao.insertBoard(vo);
		
		// 4. 게시글 목록 출력을 위해 BoardListAction 객체를 생성해 execute() 매서드 호출
		new BoardListAction().execute(request, response);
		
		// 아래 2줄을 위 1줄로 줄일 수 있음! 따로 객체 생성하지 않고
		// BoardListAction action = new BoardListAction();
		// action.execute(request, response);
	}

}
