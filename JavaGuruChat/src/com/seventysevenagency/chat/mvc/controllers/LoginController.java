package com.seventysevenagency.chat.mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.seventysevenagency.chat.dao.DAOException;
import com.seventysevenagency.chat.dao.UserDAO;
import com.seventysevenagency.chat.dao.hibernate.UserHibernateDAOImpl;
import com.seventysevenagency.chat.domain.User;
import com.seventysevenagency.chat.mvc.models.IModel;
import com.seventysevenagency.chat.mvc.models.LoginModel;

public class LoginController implements Controller {

	@Override
	public void execute(IModel model, HttpServletRequest request) {
	
		LoginModel loginModel = (LoginModel) model;
		String username = loginModel.getUsername();
		String password = loginModel.getPassword();
		if (username != null || password != null) {
			if (username == "" || password == "") {
				loginModel.addWarning("error", "Please fill in all fields");
			} else {
				UserDAO userDB = new UserHibernateDAOImpl();
				try {
					User user = userDB.authorize(username, password);
					if (user != null) {
						loginModel.addWarning("logged", "Logged");
						HttpSession userSession = request.getSession();
						userSession.setAttribute("userid", user.getId());
					} else {
						loginModel.addWarning("error", "Invalid username or password");
					}
				} catch (DAOException e) {
					
					e.printStackTrace();
				}
			}
		}
	}

}
