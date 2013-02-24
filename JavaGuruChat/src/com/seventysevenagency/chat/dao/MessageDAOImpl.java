package com.seventysevenagency.chat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.seventysevenagency.chat.domain.Conversation;
import com.seventysevenagency.chat.domain.Message;
import com.seventysevenagency.chat.domain.User;

public class MessageDAOImpl extends BaseDAO implements MessageDAO {

	@Override
	public  Long create(Message message) throws DAOException {
		Connection connection = this.getConnection();

		try {
			PreparedStatement stm = connection
					.prepareStatement("");
			

			stm.execute();
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			closeConnection(connection);
		}
		return null;
	}

	@Override
	public void update(Message message) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Message find(int id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int id) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Message findByUser(User user) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> findByConversation(Conversation conversation)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
