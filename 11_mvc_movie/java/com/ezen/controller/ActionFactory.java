package com.ezen.controller;

import com.ezen.controller.action.*;

public class ActionFactory {
	private ActionFactory() {}
	
	private static ActionFactory instance = new ActionFactory();
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	/*
	 * 서블릿에서 command를 전달받아서 해당하는 action 업무 로직을 생성해서 반환
	 */
	public Action getAction(String command) {
		Action action = null; // 파라미터에 오는 command의 내용에 따라 Action 객체를 저장하는 변수
		System.out.println("ActionFactory command = " + command);
		
		if(command.equals("movie_list")) {
			action = new MovieListAction();
		} else if(command.equals("movie_write_form")) {
			action = new MovieWriteFormAction();
		} else if(command.equals("movie_write")) {
			action = new MovieWriteAction();
		} else if(command.equals("movie_update_form")) {
			action = new MovieUpdateFormAction();
		} else if(command.equals("movie_update")) {
			action = new MovieUpdateAction();
		} else if(command.equals("movie_delete_form")) {
			action = new MovieDeleteFormAction();
		} else if(command.equals("movie_delete")) {
			action = new MovieDeleteAction();
		} else if(command.equals("movie_view")) {
			action = new MovieViewAction();
		}
		return action;
	}
}
