package com.seventysevenagency.chat.mvc.modelcreators;

import javax.servlet.http.HttpServletRequest;

import com.seventysevenagency.chat.mvc.models.IModel;
import com.seventysevenagency.chat.mvc.models.RegisterModel;

public class RegisterModelCreator extends ModelCreator {

	@Override
	public IModel createModel(HttpServletRequest request) {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String email = request.getParameter("email");
		
		RegisterModel model = new RegisterModel();
		
		model.user.setUsername(username);
		model.user.setPassword(password);
		model.user.setName(name);
		model.user.setSurname(surname);
		model.user.setEmail(email);

		return model;
	}

}
