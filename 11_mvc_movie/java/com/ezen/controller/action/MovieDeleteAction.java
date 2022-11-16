package com.ezen.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ezen.dao.MovieDAO;
import com.ezen.dto.MovieVO;

public class MovieDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 게시글 번호를 파라미터로 읽어 변수에 담는다.
		 int code = Integer.parseInt(request.getParameter("code"));
		
		 // 2. BoardDAO 인스턴스를 생성, 게시글 번호를 매개변수로 deleteBoard() 매서드 호출
		MovieDAO dao = MovieDAO.getInstance();
		dao.deleteMovie(code);
		
		// 3. BoardListAction()을 호출해 게시글 목록 표시
		new MovieListAction().execute(request, response);
	}

}
