package com.seventysevenagency.chat.mvc.modelcreators;

import javax.servlet.http.HttpServletRequest;

import com.seventysevenagency.chat.mvc.models.IModel;
import com.seventysevenagency.chat.mvc.models.LoginModel;
import com.seventysevenagency.chat.mvc.models.RegisterModel;


public class RegisterModelCreator extends ModelCreator {

	@Override
	public IModel createModel(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		RegisterModel model = new RegisterModel();
		model.setUsername(username);
		model.setPassword(password);
		
		return model;
	}

}
