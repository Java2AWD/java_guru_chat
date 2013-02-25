package com.seventysevenagency.chat.dao;

import com.seventysevenagency.chat.domain.User;

public interface UserDAO {
	public int create(User user) throws DAOException;

	public void update(User user) throws DAOException;

	public User findById(long id) throws DAOException;

	public int deleteById(long id) throws DAOException;
	
	public User findByUsername(String username) throws DAOException;
}
