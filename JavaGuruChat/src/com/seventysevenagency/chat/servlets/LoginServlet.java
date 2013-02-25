package com.seventysevenagency.chat.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seventysevenagency.chat.dao.DAOException;
import com.seventysevenagency.chat.dao.UserDAOImpl;
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
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDAOImpl userDB = new UserDAOImpl();
		try {
			User user = userDB.findByUsername(username);
			if(user != null){
				System.out.println(user.getPassword());
				System.out.println(password);
				if(user.getPassword().replaceAll("\\s","").equals(password)){
					
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
