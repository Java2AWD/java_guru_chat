package com.seventysevenagency.chat.mvc.controllers;

import com.seventysevenagency.chat.mvc.models.IModel;
import com.seventysevenagency.chat.mvc.models.RegisterModel;

public class RegisterController implements Controller {

	@Override
	public void execute(IModel model) {
		// TODO Auto-generated method stub
		RegisterModel registerModel = (RegisterModel) model;
		
		if(registerModel.getLogin() != ""){
			registerModel.setWarning("error");
		}
		
	}

}
