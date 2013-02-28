package com.seventysevenagency.chat.mvc.controllers;

import javax.servlet.http.HttpServletRequest;

import com.seventysevenagency.chat.mvc.models.IModel;
import com.seventysevenagency.chat.mvc.models.RegisterModel;

public class RegisterController implements Controller {

	@Override
	public void execute(IModel model, HttpServletRequest request) {
		// TODO Auto-generated method stub
		RegisterModel registerModel = (RegisterModel) model;
		
		if(registerModel.getUsername() != ""){
			registerModel.setWarning("error");
		}
		
	}

}
