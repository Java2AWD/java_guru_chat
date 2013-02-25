package com.seventysevenagency.chat.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seventysevenagency.chat.dao.DAOException;
import com.seventysevenagency.chat.dao.UserDAO;
import com.seventysevenagency.chat.dao.UserHibernateDAOImpl;
import com.seventysevenagency.chat.domain.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String output = "Nothing to display";
		if (username != null) {
			UserDAO userDao = new UserHibernateDAOImpl();
			try {
				User requestedUser = userDao.findByUsername(username);
				output = requestedUser.getName() + " " + requestedUser.getSurname();
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.getWriter().println(output);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (name != null && surname != null && email != null
				&& username != null && password != null) {
			UserDAO userDao = new UserHibernateDAOImpl();
			User newUser = new User();
			newUser.setName(name);
			newUser.setSurname(surname);
			newUser.setUsername(username);
			newUser.setEmail(email);
			newUser.setPassword(password);
			try {
				userDao.create(newUser);
			} catch (DAOException e) {
				e.printStackTrace();
			}
		}
	}
}
