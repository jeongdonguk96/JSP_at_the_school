package com.ezen.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.MovieDAO;
import com.ezen.dto.MovieVO;

public class MovieWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. VO 객체 생성, request속성에 담긴 값을 VO 객체에 담음
		MovieVO vo = (MovieVO) request.getAttribute("movie");

		// 3. DB작업을 위해 DAO 객체 생성
		MovieDAO dao = MovieDAO.getInstance();
		
		// 4. DAO 객체를 통해 insertMovie() 매서드를 호출해 영화를 DB에 저장
		dao.insertMovie(vo);
		
		// 5. 목록 출력을 위해 MovieListAction 객체를 생성, execute() 매서드 호출 
		new MovieListAction().execute(request, response);
	}

}
