package com.seventysevenagency.chat.mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.seventysevenagency.chat.dao.DAOException;
import com.seventysevenagency.chat.dao.UserDAO;
import com.seventysevenagency.chat.dao.hibernate.UserHibernateDAOImpl;
import com.seventysevenagency.chat.domain.User;
import com.seventysevenagency.chat.mvc.models.IModel;
import com.seventysevenagency.chat.mvc.models.LoginModel;
import com.seventysevenagency.chat.util.HibernateUtil;

public class LoginController implements Controller {

	@Override
	public void execute(IModel model, HttpServletRequest request){
		// TODO Auto-generated method stub
		LoginModel loginModel = (LoginModel) model;
		String username = loginModel.getUsername();
		String password = loginModel.getPassword();
		if (username != null || password != null){
			if ( username == "" || password == "") {
				loginModel.setWarning("Please fill in all fields");
			} else {
				UserDAO userDB = new UserHibernateDAOImpl();
				Session session = HibernateUtil.getSessionFactory()
						.getCurrentSession();
				session.beginTransaction();
				try {
					User user = userDB.findByUsername(username);
					if (user != null) {
						if (user.getPassword().replaceAll("\\s", "")
								.equals(password)) {
							loginModel.setWarning("Logged");
							HttpSession userSession = request.getSession();
							userSession.setAttribute("user", user);
							System.out.println(userSession.getAttribute("user"));
						} else {
							loginModel.setWarning("Invalid username or password");
						}
					} else {
						loginModel.setWarning("Invalid username or password");
					}
				} catch (DAOException e) {
					e.printStackTrace();
				} finally {
					session.close();
				}
			}
		}

	}

}
