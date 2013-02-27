package com.seventysevenagency.chat.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seventysevenagency.chat.domain.User;

/**
 * Servlet implementation class ChatServlet
 */
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User loggedUser = (User) session.getAttribute("user");
		if (loggedUser != null) {
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/public_chat.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("login");
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
