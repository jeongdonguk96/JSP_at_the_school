package com.ezen.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.BoardDAO;
import com.ezen.dto.BoardVO;

/*
 * 게시글 수정창에서 비밀번호 입력 후 수정된 화면을 출력하는 클래스
 */
public class BoardUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/board/boardUpdate.jsp";
		
		// 1. 게시글 번호를 파라미터로 읽어 변수에 담는다.
		int num = Integer.parseInt(request.getParameter("num"));
		
		// 2. BoardDAO 인스턴스를 생성, selectOneBoardByNum() 매서드를 호출해 게시글을 조회한다.
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = dao.selectOneBoardByNum(num);
		
		// 3. request 객체의 "board"속성에 db에서 조회한 게시글 정보를 저장한다.
		request.setAttribute("board", vo);
		
		// 4. 위에서 지정한 url로 forward
		request.getRequestDispatcher(url).forward(request, response);
	}

}
