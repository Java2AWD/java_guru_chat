package com.seventysevenagency.chat.dao;

import com.seventysevenagency.chat.domain.Participant;

public interface ParticipantDAO {
	public void create(Participant participant) throws DAOException;
	public void delete(Long id)  throws DAOException;
	public Participant select(Long id)  throws DAOException;
	public void update(Participant participant) throws DAOException;
}
