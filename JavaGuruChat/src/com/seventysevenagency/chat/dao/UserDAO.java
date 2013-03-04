package com.seventysevenagency.chat.dao;

import com.seventysevenagency.chat.domain.User;

public interface UserDAO {
	public int create(User user) throws DAOException;

	public void update(User user) throws DAOException;

	public User findById(int id) throws DAOException;

	public int deleteById(int id) throws DAOException;
	
	public User findByUsername(String username) throws DAOException;
	
	public User authorize(String username, String password) throws DAOException;
	
	public void flushChanges();
}
