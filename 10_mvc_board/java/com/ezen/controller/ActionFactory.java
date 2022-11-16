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
		
		if(command.equals("board_list")) {
			action = new BoardListAction();
		} else if(command.equals("board_write_form")) {
			action = new BoardWriteFormAction();
		} else if(command.equals("board_write")) {
			action = new BoardWriteAction();
		} else if(command.equals("board_view")) {
			action = new BoardViewAction();
		} else if(command.equals("board_check_pass_form")) {
			action = new BoardCheckPassFormAction();
		} else if(command.equals("board_check_pass")) {
			action = new BoardCheckPassAction();
		} else if(command.equals("board_update_form")) {
			action = new BoardUpdateFormAction();
		} else if(command.equals("board_update")) {
			action = new BoardUpdateAction();
		}  else if(command.equals("board_delete")) {
			action = new BoardDeleteAction();
		}
				
		return action;
	}
}
