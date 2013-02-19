package com.seventysevenagency.chat.dao;

import com.seventysevenagency.chat.domain.Conversation;

public interface ConversationDAO {
	public void create(Conversation conversation) throws DAOException;
	public void delete(Integer id)  throws DAOException;
	public Conversation select(Integer id)  throws DAOException;
	public void update(Conversation conversation) throws DAOException;
}
