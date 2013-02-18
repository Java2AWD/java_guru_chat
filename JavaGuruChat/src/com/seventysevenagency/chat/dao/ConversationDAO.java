package com.seventysevenagency.chat.dao;

import com.seventysevenagency.chat.domain.Conversation;

public interface ConversationDAO {
	public Integer create(Conversation conversation);
	public void delete(Integer id);
	public void update(Conversation conversation);
}
