package com.seventysevenagency.chat.controllers;

import com.seventysevenagency.chat.models.IModel;
import com.seventysevenagency.chat.models.LoginModel;

public class LoginController implements Controller {

	@Override
	public void execute(IModel model) {
		// TODO Auto-generated method stub
		LoginModel loginModel = (LoginModel) model;
		
		if(loginModel.getLogin() != ""){
			loginModel.setWarning("error");
		}
		
	}

}
