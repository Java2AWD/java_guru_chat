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

public class RegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		if (!username.isEmpty() && !password.isEmpty() && !repassword.isEmpty()
				&& !email.isEmpty() && !name.isEmpty() && !surname.isEmpty()) {
			if (password.equals(repassword)) {
				System.out.println("3");
				UserDAOImpl userDB = new UserDAOImpl();
				try {
					System.out.println("2");
					User existUser = userDB.findByUsername(username);	
					System.out.println(existUser);
					if (existUser == null) {						
						User newUser = new User();
						newUser.setEmail(email);
						newUser.setName(name);
						newUser.setSurname(surname);
						newUser.setUsername(username);
						newUser.setPassword(password);
						userDB.create(newUser);
						response.sendRedirect("login?registered=true");
					}else{
						request.setAttribute("username", username);
						request.setAttribute("name", name);
						request.setAttribute("surname", surname);
						request.setAttribute("email", email);
						request.setAttribute("error", "Username already taken");
					}
				} catch (DAOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			} else {
				request.setAttribute("username", username);
				request.setAttribute("name", name);
				request.setAttribute("surname", surname);
				request.setAttribute("email", email);
				request.setAttribute("error", "Password must match");
			}
		}else{
			request.setAttribute("username", username);
			request.setAttribute("name", name);
			request.setAttribute("surname", surname);
			request.setAttribute("email", email);
			request.setAttribute("error", "Please fill all fields");
		}
		if(request.getAttribute("error") != null){
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
			dispatcher.forward(request, response);
		}
		

	}

}
