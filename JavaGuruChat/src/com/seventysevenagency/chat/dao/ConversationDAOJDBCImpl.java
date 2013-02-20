package com.seventysevenagency.chat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.seventysevenagency.chat.domain.Conversation;
import com.seventysevenagency.chat.types.ConversationType.Type;

public class ConversationDAOJDBCImpl extends BaseDAO implements ConversationDAO {

	@Override
	public void create(Conversation conversation) throws DAOException {
		Connection connection = this.getConnection();
		try {
			PreparedStatement stm = connection
					.prepareStatement("INSERT INTO conversations "
							+ "(type, name)" + " VALUES (?, ?);");

			stm.setString(1, String.valueOf(conversation.getType()));
			stm.setString(2, conversation.getName());

			stm.execute();
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			closeConnection(connection);
		}
	}

	@Override
	public void delete(Long id) throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = this.getConnection();
		try {
			PreparedStatement stm = connection
					.prepareStatement("DELETE FROM conversations WHERE id = ?");

			stm.setLong(1, id);
			stm.execute();
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			closeConnection(connection);
		}
	}

	public Conversation select(Long id) throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = this.getConnection();

		Conversation conversation = null;
		try {
			PreparedStatement stm = connection
					.prepareStatement("SELECT name, type "
							+ "FROM conversations WHERE id = ?");

			stm.setLong(1, id);

			ResultSet result = stm.executeQuery();
			conversation = new Conversation();
			conversation.setId(id);
			conversation.setName(result.getString(1));
			conversation.setType(Type.valueOf(result.getString(2)));
			return conversation;
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			closeConnection(connection);
		}
	}

	@Override
	public void update(Conversation conversation) throws DAOException {
		// TODO Auto-generated method stub
		Connection connection = this.getConnection();
		try {
			PreparedStatement stm = connection
					.prepareStatement("UPDATE conversations SET name = ?,"
							+ "type = ?" + "WHERE id = ?");

			stm.setString(1, String.valueOf(conversation.getType()));
			stm.setString(2, conversation.getName());
			stm.setLong(3, conversation.getId());
			stm.execute();
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			closeConnection(connection);
		}
	}

}
