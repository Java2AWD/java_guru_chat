package com.seventysevenagency.chat.dao;

import com.seventysevenagency.chat.domain.User;

public interface UserDAO {
	public void create(User user) throws DAOException;

	public void update(User user) throws DAOException;

	public User find(int id) throws DAOException;

	public void deleteById(int id) throws DAOException;
	
	public User findByUsername(String username) throws DAOException;
}
