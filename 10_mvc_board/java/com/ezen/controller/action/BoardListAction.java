package com.ezen.controller.action;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.BoardDAO;
import com.ezen.dto.BoardVO;

/*
 * 게시판 출력을 위한 클래스
 */
public class BoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "board/boardList.jsp";
		
		// 1. BoardDAO 객체를 생성, 모든 게시글을 조회하는 selectAllBoards() 호출
		BoardDAO dao = BoardDAO.getInstance();
		List<BoardVO> list = dao.selectAllBoards();
		
		// 2. 조회한 게시글 목록을 request 객체의 "boardList" 속성에 저장
		request.setAttribute("boardList", list);
		
		// 3. RequestDispatcher 객체를 생성하고 forward
		request.getRequestDispatcher(url).forward(request, response);
		System.out.println("게시글 목록 처리");
	}

}
