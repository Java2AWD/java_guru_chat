package com.seventysevenagency.chat.dao;

import java.util.List;

import com.seventysevenagency.chat.domain.Conversation;
import com.seventysevenagency.chat.domain.Participant;

public interface ParticipantDAO {
	public Long create(Participant participant) throws DAOException;
	public int deleteByConversationId(Long id)  throws DAOException;
	public int deleteByConversation(Conversation conversation)  throws DAOException;
	public List<Participant> selectParticipants(Long id)  throws DAOException;
	public void update(Participant participant) throws DAOException;
}
