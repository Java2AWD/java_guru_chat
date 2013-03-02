package com.seventysevenagency.chat;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.seventysevenagency.chat.util.HibernateUtil;

/**
 * Application Lifecycle Listener implementation class StartupListener
 */
public class StartupListener implements ServletContextListener {

	public StartupListener() {
	}

	public void contextInitialized(ServletContextEvent arg0) {
		HibernateUtil.getSessionFactory();
	}

	public void contextDestroyed(ServletContextEvent arg0) {
	}

}
