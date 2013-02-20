package com.seventysevenagency.chat.dao;

import java.util.List;

import com.seventysevenagency.chat.domain.Conversation;
import com.seventysevenagency.chat.domain.Message;
import com.seventysevenagency.chat.domain.User;

public interface MessageDAO {
	public Long create(Message message) throws DAOException;

	public void update(Message message) throws DAOException;

	public Message find(int id) throws DAOException;

	public void deleteById(int id) throws DAOException;

	public Message findByUser(User user) throws DAOException;

	public List<Message> findByConversation(Conversation conversation)
			throws DAOException;
}
