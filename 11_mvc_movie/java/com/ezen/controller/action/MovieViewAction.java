package com.ezen.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.MovieDAO;
import com.ezen.dto.MovieVO;

public class MovieViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "movie/movieView.jsp";
		
		// 1. request 객체에서 영화 제목 "code" 파라미터를 읽어온다
		int code = Integer.parseInt(request.getParameter("code"));
						
		// 2. DB작업을 위해 DAO 객체 생성
		MovieDAO dao = MovieDAO.getInstance();
						
		// 3. "code"를 조건으로 DB에서 영화 정보를 읽어온다
		MovieVO vo = dao.selectOneMovieByTitle(code);
		
		// 4. request 객체의 "movie" 속성에 결과 VO 객체를 저장한다.
		request.setAttribute("movie", vo);
		
		// 5. 상세보기 페이지로 forward
		request.getRequestDispatcher(url).forward(request, response);
	}

}
