package com.ezen.controller.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ezen.dao.BoardDAO;
import com.ezen.dto.BoardVO;

/*
 * 게시글 수정을 위한 클래스 
 */
public class BoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. BoardVO 객체 생성, 수정 게시글 정보를 request 파라미터로 읽어와 저장
		BoardVO vo = new BoardVO();
		
		vo.setNum(Integer.parseInt(request.getParameter("num")));
		vo.setName(request.getParameter("name"));
		vo.setPass(request.getParameter("pass"));
		vo.setEmail(request.getParameter("email"));
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
	
		// 2. BoardDAO 객체 생성, 수정처리를 위한 updateBoard() 매서드 호출
		BoardDAO dao = BoardDAO.getInstance();
		dao.updateBoard(vo);
		
		// 3. BoardListAction()를 호출해 게시글 목록 표시
		new BoardListAction().execute(request, response);
	}

}
