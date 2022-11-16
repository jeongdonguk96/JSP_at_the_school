package com.ezen.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.MovieDAO;
import com.ezen.dto.MovieVO;

public class MovieUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. VO 객체 생성
		MovieVO vo = (MovieVO) request.getAttribute("movie");

		// 3. DAO 객체를 생성, 수정처리를 위해 updateMovie() 매서드를 호출
		MovieDAO dao = MovieDAO.getInstance();
		dao.updateMovie(vo);
		
		// 4. MovieListAction()을 호출, 게시글 목록을 표시
		new MovieListAction().execute(request, response);
	}

}
