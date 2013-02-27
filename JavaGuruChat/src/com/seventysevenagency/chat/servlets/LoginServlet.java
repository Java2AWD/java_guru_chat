package com.seventysevenagency.chat.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.seventysevenagency.chat.dao.DAOException;
import com.seventysevenagency.chat.dao.UserDAO;
import com.seventysevenagency.chat.dao.UserHibernateDAOImpl;
import com.seventysevenagency.chat.domain.User;
import com.seventysevenagency.chat.util.HibernateUtil;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String registered = request.getParameter("registered");
		if(registered != null && registered.equals("true")){
			request.setAttribute("registered", "You registered successfully");
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDAO userDB = new UserHibernateDAOImpl();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			User user = userDB.findByUsername(username);
			if(user != null){
				System.out.println(user.getPassword());
				System.out.println(password);
				if(user.getPassword().replaceAll("\\s","").equals(password)){
					HttpSession userSession = request.getSession();
					userSession.setAttribute("user", user);
					response.sendRedirect("chatroom");
				} else {
					request.setAttribute("error", "Invalid username or password");					
				}
			} else {
				request.setAttribute("error", "Invalid username or password");	
			}
			if(request.getAttribute("error") != null){
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/login.jsp");
				dispatcher.forward(request, response);
			}
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
}
