package com.seventysevenagency.chat.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//		String username = request.getParameter("username");
//		String output = "Nothing to display";
//		if (username != null) {
//			UserDAO userDao = new UserHibernateDAOImpl();
//			try {
//				User requestedUser = userDao.findByUsername(username);
//				output = requestedUser.getName() + " " + requestedUser.getSurname();
//			} catch (DAOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		response.getWriter().println(output);
		String registered = request.getParameter("registered");
		if(registered != null && registered.equals("true")){
			request.setAttribute("registered", "You registered successfully");
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		UserHibernateDAOImpl userDao = new UserHibernateDAOImpl();		
		try {
			User user = userDao.findByUsername(username);
			if(user != null){
				System.out.println(user.getmPassword());
				System.out.println(password);
				if(user.getmPassword().replaceAll("\\s","").equals(password)){					
					response.sendRedirect("chats");
				} else {
					request.setAttribute("error", "Invalid username or password");					
				}
			} else {
				request.setAttribute("error", "Invalid username or password");	
			}
			if(request.getAttribute("error") != null){
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp");
				dispatcher.forward(request, response);
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
