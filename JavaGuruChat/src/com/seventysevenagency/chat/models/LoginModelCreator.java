package com.seventysevenagency.chat.models;

import javax.servlet.http.HttpServletRequest;


public class LoginModelCreator extends ModelCreator {

	@Override
	public IModel createModel(HttpServletRequest request) {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		LoginModel model = new LoginModel();
		model.setLogin(login);
		model.setPassword(password);
		
		return model;
	}

}
