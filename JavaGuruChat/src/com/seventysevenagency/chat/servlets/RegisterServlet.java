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

public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = -3076745569440957386L;

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
				SessionFactory sf = HibernateUtil.getSessionFactory();
				Session session = sf.getCurrentSession();
				session.beginTransaction();
				UserDAO userDao = new UserHibernateDAOImpl();
				try {
					System.out.println("2");
					User existUser = userDao.findByUsername(username);
					System.out.println(existUser);
					if (existUser == null) {
						User newUser = new User();
						newUser.setmEmail(email);
						newUser.setmName(name);
						newUser.setmSurname(surname);
						newUser.setmUsername(username);
						newUser.setmPassword(password);
						session.save(newUser);
						session.getTransaction().commit();
						response.sendRedirect("login?registered=true");
					} else {
						request.setAttribute("error", "Username already taken");
					}
				} catch (DAOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				request.setAttribute("error", "Password must match");
			}
		} else {
			request.setAttribute("error", "Please fill all fields");
		}
		if (request.getAttribute("error") != null) {
			request.setAttribute("username", username);
			request.setAttribute("name", name);
			request.setAttribute("surname", surname);
			request.setAttribute("email", email);
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
			dispatcher.forward(request, response);
		}

	}

}