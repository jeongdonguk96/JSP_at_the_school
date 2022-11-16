package com.ezen.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.MovieDAO;
import com.ezen.dto.MovieVO;

/*
 * 게시판 출력을 위한 클래스
 */
public class MovieListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "movie/movieList.jsp";
		
		// 1. DAO 객체를 생성, 모든 목록을 조회하는 selectAllMovies() 매서드를 호출
		MovieDAO dao = MovieDAO.getInstance();
		List<MovieVO> list = dao.selectAllMovies();
		
		// 2. 조회한 목록을 request 객체의 "movieList" 속성에 저장
		request.setAttribute("movieList", list);
		
		// 3. RequestDispatcher 객체를 이용해 forward
		request.getRequestDispatcher(url).forward(request, response);
		System.out.println("목록 처리");
	}

}
