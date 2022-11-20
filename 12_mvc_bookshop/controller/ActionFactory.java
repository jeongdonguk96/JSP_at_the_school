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
		System.out.println("ActionFactory에서 받은 command는 = " + command + " 입니다.\n");
		
		if(command.equals("manager_login_form")) {
			action = new ManagerLoginFormAction();
		} else if(command.equals("manager_login")) {
			action = new ManagerLoginAction();
		} else if(command.equals("manager_logout")) {
			action = new ManagerLogoutAction();
		} else if(command.equals("book_register_form")) {
			action = new BookRegisterFormAction();
		} else if(command.equals("book_register")) {
			action = new BookRegisterAction();
		} else if(command.equals("book_list")) {
			action = new BookListAction();
		} else if(command.equals("book_kind")) {
			action = new BookKindAction();
		} else if(command.equals("manager_main")) {
			action = new ManagerMainAction();
		}
		

		return action;
	}
}