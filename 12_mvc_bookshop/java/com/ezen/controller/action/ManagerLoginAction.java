package com.ezen.controller.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManagerLoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "manager/logon/managerLoginForm.jsp";
		String id = "bookmaster@shop.com";
		String pwd = "123456";
		String param_id = request.getParameter("id");
		String param_pwd = request.getParameter("pwd");
		
		if(id.equals(param_id) && pwd.equals(param_pwd)) {
			url = "manager/managerMain.jsp";
		}

		request.getRequestDispatcher(url).forward(request, response);
	}

}
