package com.ezen.controller.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ezen.dao.BoardDAO;
import com.ezen.dto.BoardVO;


public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/board/boardView.jsp";
		
		// 1. request 객체에서 게시글 번호 파라미터를 읽어 변수에 담는다.
		int num = Integer.parseInt(request.getParameter("num"));
		
		// 2. DB작업을 위하 BoardDAO 객체를 생성, updateReadCount() 매서드를 호출해 게시글 읽은 횟수를 조정
		BoardDAO dao = BoardDAO.getInstance(); 
		BoardVO vo = dao.selectOneBoardByNum(num);
		if(vo != null) {
			dao.updateReadCount(num);			
		}
		
		// 4. request객체의 "board"속성에 BoardVO 객체를 저장한다. 
		request.setAttribute("board", vo);
		
		// 5. 상세보기 페이지로 forward
		request.getRequestDispatcher(url).forward(request, response);
	}

}
