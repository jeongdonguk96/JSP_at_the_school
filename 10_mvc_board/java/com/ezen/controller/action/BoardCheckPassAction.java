package com.ezen.controller.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.BoardDAO;
import com.ezen.dto.BoardVO;

/*
 * 게시글 수정, 삭제를 위해 입력한 비밀번호가 맞는지 아닌지 확인하는 클래스
 */
public class BoardCheckPassAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "";
		
		// 1. 비밀번호와 게시글번호를 파라미터로 받아 변수에 담는다
		String pass = request.getParameter("pass");
		int num = Integer.parseInt(request.getParameter("num"));
		
		// 2. BoardDAO 인스턴스를 생성하고, selectOneBoardBuNum() 매서드를 호출해 게시글을 조회한다
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = dao.selectOneBoardByNum(num);
		
		// 3. DB에서 조회한 비밀번호와 입력한 비밀번호가 일치하는지 확인
		if(vo != null) {
			if(pass.equals(vo.getPass())) {
				url = "/board/checkSuccess.jsp";
			} else {
				url = "/board/boardCheckPass.jsp";
				request.setAttribute("message", "비밀번호가 일치하지 않습니다.");
			}
		}
		
		// 4. 위에서 지정한 url로 forward
		request.getRequestDispatcher(url).forward(request, response);
	}

}
