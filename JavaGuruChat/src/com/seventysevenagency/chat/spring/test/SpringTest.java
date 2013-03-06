package com.seventysevenagency.chat.spring.test;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.seventysevenagency.chat.dao.UserDAO;
import com.seventysevenagency.chat.domain.User;

public class SpringTest {

	private ApplicationContext applicationContext;

	public SpringTest() {
		applicationContext = new ClassPathXmlApplicationContext(
				"/spring_context.xml");
	}

	@Test
	public void test() {

		// ClassA a = applicationContext.getBean(ClassA.class);
		// UserDAO userDao = applicationContext.getBean(UserDAO.class);
		// assertNotNull(userDao);

	}

	@Test
	public void testUserCreate() {
		User newUser = new User();
		newUser.setName("TestUser2");
		newUser.setSurname("FromSpring");
		newUser.setPassword("pass1");
		newUser.setEmail("mail.com");
		newUser.setUsername("username2");

		UserDAO userDao = applicationContext.getBean(UserDAO.class);
		Integer id = userDao.create(newUser);

		assertNotNull(id);

	}
}
