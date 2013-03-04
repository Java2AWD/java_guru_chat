package com.seventysevenagency.chat.mvc.controllers;

import javax.servlet.http.HttpServletRequest;

import com.seventysevenagency.chat.dao.DAOException;
import com.seventysevenagency.chat.dao.UserDAO;
import com.seventysevenagency.chat.dao.hibernate.UserHibernateDAOImpl;
import com.seventysevenagency.chat.mvc.models.IModel;
import com.seventysevenagency.chat.mvc.models.RegisterModel;

public class RegisterController extends ControllerBase {

	@Override
	public void execute(IModel model, HttpServletRequest request) {
		this.redirectUrl = null;
		RegisterModel registerModel = (RegisterModel) model;
		String requestMethod = request.getMethod();

		if (requestMethod.equals("POST")) {
			// validation new user data and saving to db
			if (validateModel(registerModel)) {

				UserDAO userDao = new UserHibernateDAOImpl();
				try {
					userDao.create(registerModel.user);
					this.redirectUrl = "login";
				} catch (DAOException e) {
					e.printStackTrace();
					registerModel.addWarning("error",
							"Failed to create a user");
				}
			}
		} else {
			// Get request
		}
	}

	public boolean validateModel(RegisterModel model) {

		boolean isValid = true;

		String username = model.user.getUsername();
		if (username == null || username.isEmpty()) {
			model.addWarning("error", "Username is empty");
			isValid = false;
		}

		String password = model.user.getPassword();
		if (password == null || password.isEmpty()) {
			model.addWarning("error", "Password is empty");
			isValid = false;
		} else if (password.length() < 4) {
			model.addWarning("error", "Password is too short");
			isValid = false;
		}

		String name = model.user.getName();
		if (name == null || name.isEmpty()) {
			model.addWarning("error", "Please, provide your name...");
			isValid = false;
		}
		return isValid;
	}
}
