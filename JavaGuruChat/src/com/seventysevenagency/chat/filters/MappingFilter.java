package com.seventysevenagency.chat.filters;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.seventysevenagency.chat.mvc.controllers.ChatroomController;
import com.seventysevenagency.chat.mvc.controllers.IController;
import com.seventysevenagency.chat.mvc.controllers.LoginController;
import com.seventysevenagency.chat.mvc.controllers.RegisterController;
import com.seventysevenagency.chat.mvc.mapping.UrlMapping;
import com.seventysevenagency.chat.mvc.modelcreators.ChatroomModelCreator;
import com.seventysevenagency.chat.mvc.modelcreators.LoginModelCreator;
import com.seventysevenagency.chat.mvc.modelcreators.ModelCreator;
import com.seventysevenagency.chat.mvc.modelcreators.RegisterModelCreator;
import com.seventysevenagency.chat.mvc.models.IModel;
import com.seventysevenagency.chat.util.ConnectedUsersListener;
import com.seventysevenagency.chat.util.HibernateUtil;

/**
 * Servlet Filter implementation class MappingFilter
 */
@WebFilter("/MappingFilter")
public class MappingFilter implements Filter {

	private Map<String, UrlMapping> mapping;

	/**
	 * Default constructor.
	 */
	public MappingFilter() {
		mapping = new HashMap<String, UrlMapping>();

		// Login page mapping
		UrlMapping loginPage = new UrlMapping();
		loginPage.setUrl("/login");
		loginPage.setModelCreator(new LoginModelCreator());
		loginPage.setController(new LoginController());
		loginPage.setJsp("/jsp/login.jsp");

		mapping.put(loginPage.getUrl(), loginPage);

		// Register page mapping
		UrlMapping registerPage = new UrlMapping();
		registerPage.setUrl("/register");
		registerPage.setModelCreator(new RegisterModelCreator());
		registerPage.setController(new RegisterController());
		registerPage.setJsp("/jsp/register.jsp");

		mapping.put(registerPage.getUrl(), registerPage);

		// Public chat page mapping
		UrlMapping chatroomPage = new UrlMapping();
		chatroomPage.setUrl("/chatroom");
		chatroomPage.setModelCreator(new ChatroomModelCreator());
		chatroomPage.setController(new ChatroomController());
		chatroomPage.setJsp("/jsp/public_chat.jsp");

		mapping.put(chatroomPage.getUrl(), chatroomPage);
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;		
		String url = req.getRequestURI().replace("/JavaGuruChat", "");

		if (!url.matches(".*(css|jpg|png|gif|js)")) {
			if(url.equals("/logout")){
				HttpSession userSession = req.getSession();
				Integer userID = (Integer) userSession.getAttribute("userid");
				userSession.removeAttribute("userid");
				ConnectedUsersListener.removeUser(userID);
				resp.sendRedirect("login");
				return;
			}
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			UrlMapping urlMapping = mapping.get(url);
			
			if (urlMapping == null) {
				RequestDispatcher view = req
						.getRequestDispatcher("/jsp/404.jsp");
				view.forward(req, response);
			} else {
				ModelCreator modelCreator = urlMapping.getModelCreator();
				IModel model = modelCreator.createModel(req);

				IController controller = urlMapping.getController();
				controller.execute(model, req);
				String redirectUrl = controller.getRedirectUrl();
				if(redirectUrl != null) {
					System.out.println(redirectUrl);
					resp.sendRedirect(redirectUrl);
					session.getTransaction().commit();
					return;
				}
				req.setAttribute("model", model);
				req.setAttribute("title", "page");
				RequestDispatcher view = req.getRequestDispatcher(urlMapping
						.getJsp());
				view.forward(req, response);
			}
			session.getTransaction().commit();
		} else {
			chain.doFilter(request, response);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}
}
