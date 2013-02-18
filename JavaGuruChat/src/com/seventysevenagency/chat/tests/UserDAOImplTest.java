package com.seventysevenagency.chat.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.seventysevenagency.chat.domain.User;

public class UserDAOImplTest {

	private User mUser;
	
	@Before
	public void setUp() throws Exception {
		mUser = new User();
		mUser.setName("Alex");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testFind() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteById() {
		fail("Not yet implemented");
	}

}
