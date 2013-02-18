package com.seventysevenagency.chat.dao;

import com.seventysevenagency.chat.domain.User;

public interface UserDAO {
	public void create(User user);

	public void update(User user);

	public void find(int id);

	public void delete(User user);

	public void deleteById(int id);	
}
