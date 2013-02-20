package com.seventysevenagency.chat.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.seventysevenagency.chat.dao.DAOException;
import com.seventysevenagency.chat.dao.UserDAO;
import com.seventysevenagency.chat.dao.UserDAOImpl;
import com.seventysevenagency.chat.domain.User;

public class UserDAOImplTest {

	private User mUser;

	@Before
	public void setUp() throws Exception {
		mUser = new User();
		mUser.setName("Alex");
		mUser.setSurname("Surname");
		mUser.setPassword("mypass");
		mUser.setUsername("starrover");
		mUser.setEmail("starrover@github.com");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() {
		UserDAO userDao = new UserDAOImpl();
		try {
			userDao.create(mUser);
		} catch (DAOException e) {
			fail("Exception is thrown");
			e.printStackTrace();
		}
	}

	@Test
	public void testFindByUsername() {
		UserDAO userDao = new UserDAOImpl();
		try {
			User createdUser = userDao.findByUsername(mUser.getUsername());
			assertEquals(mUser.getName(), createdUser.getName());
			assertEquals(mUser.getSurname(), createdUser.getSurname());
			assertEquals(mUser.getUsername(), createdUser.getUsername());
			assertEquals(mUser.getPassword(), createdUser.getPassword());
			assertEquals(mUser.getEmail(), createdUser.getEmail());

			mUser.setId(createdUser.getId());
		} catch (DAOException e) {
			fail("Exception is thrown");
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		UserDAO userDao = new UserDAOImpl();
		try {
			String newName = "New Name";
			User createdUser = userDao.findByUsername(mUser.getUsername());
			createdUser.setName(newName);
			mUser.setName(newName);
			userDao.update(createdUser);
		} catch (DAOException e) {
			fail("Exception is thrown");
			e.printStackTrace();
		}
	}

	@Test
	public void testFind() {
		UserDAO userDao = new UserDAOImpl();
		try {
			User foundUser = userDao.find(mUser.getId());
			assertEquals(mUser.getId(), foundUser.getId());
			assertEquals(mUser.getName(), foundUser.getName());
			assertEquals(mUser.getUsername(), mUser.getUsername());
		} catch (DAOException e) {
			fail("Exception is thrown");
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteById() {
		UserDAO userDao = new UserDAOImpl();
		try {
			userDao.deleteById(mUser.getId());
			User foundUser = userDao.find(mUser.getId());
			assertEquals(null, foundUser);
		} catch (DAOException e) {
			fail("Exception is thrown");
			e.printStackTrace();
		}
	}

}
