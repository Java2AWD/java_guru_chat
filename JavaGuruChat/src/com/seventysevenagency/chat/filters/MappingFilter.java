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

import com.seventysevenagency.chat.UrlMapping;
import com.seventysevenagency.chat.controllers.Controller;
import com.seventysevenagency.chat.controllers.LoginController;
import com.seventysevenagency.chat.models.IModel;
import com.seventysevenagency.chat.models.LoginModelCreator;
import com.seventysevenagency.chat.models.ModelCreator;

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
		UrlMapping loginPage = new UrlMapping();
		loginPage.setUrl("/login");
		loginPage.setModelCreator(new LoginModelCreator());
		loginPage.setController(new LoginController());
		loginPage.setJsp("/jsp/login.jsp");

		mapping.put(loginPage.getUrl(), loginPage);
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String url = req.getRequestURI().replace("/JavaGuruChat", "");
		System.out.println(url);
		UrlMapping urlMapping = mapping.get(url);
		if (urlMapping == null) {
			//
		}
		System.out.println(urlMapping);
		ModelCreator modelCreator = urlMapping.getModelCreator();
		IModel model = modelCreator.createModel(req);

		Controller controller = urlMapping.getController();
		controller.execute(model);

		req.setAttribute("model", model);

		RequestDispatcher view = req.getRequestDispatcher(urlMapping.getJsp());
		view.forward(req, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}
}
