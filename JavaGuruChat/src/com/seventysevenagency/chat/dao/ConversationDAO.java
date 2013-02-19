package com.seventysevenagency.chat.dao;

import com.seventysevenagency.chat.domain.Conversation;

public interface ConversationDAO {
	public void create(Conversation conversation) throws DAOException;
	public void delete(Long id)  throws DAOException;
	public Conversation select(Long id)  throws DAOException;
	public void update(Conversation conversation) throws DAOException;
}
