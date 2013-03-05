package com.seventysevenagency.chat.spring.test;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"/spring_context.xml");
		ClassA a = applicationContext.getBean(ClassA.class);
		assertNotNull(a);
	}
}
