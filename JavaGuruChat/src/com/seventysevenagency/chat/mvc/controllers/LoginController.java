package com.seventysevenagency.chat.mvc.controllers;

import com.seventysevenagency.chat.mvc.models.IModel;
import com.seventysevenagency.chat.mvc.models.LoginModel;

public class LoginController implements Controller {

	@Override
	public void execute(IModel model) {
		// TODO Auto-generated method stub
		LoginModel loginModel = (LoginModel) model;
		
		if(loginModel.getUsername() != ""){
			loginModel.setWarning("error");
		}
		
	}

}
