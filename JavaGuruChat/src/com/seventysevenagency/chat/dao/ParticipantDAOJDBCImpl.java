package com.seventysevenagency.chat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.seventysevenagency.chat.domain.Participant;

public class ParticipantDAOJDBCImpl extends BaseDAO implements ParticipantDAO {
	public void create(Participant participant) throws DAOException {
		Connection connection = this.getConnection();
		try {
			PreparedStatement stm = connection
					.prepareStatement("INSERT INTO partiticant "
							+ "(user_id, conversation_id)" + " VALUES (?, ?);");

			stm.setLong(1, participant.getUserId());
			stm.setLong(2, participant.getConversationId());

			stm.execute();
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			closeConnection(connection);
		}
	}

	public void delete(Long id) throws DAOException {
		Connection connection = this.getConnection();
		try {
			PreparedStatement stm = connection
					.prepareStatement("DELETE FROM partiticant "
							+ "WHERE id = ? ");

			stm.setLong(1, id);

			stm.execute();
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			closeConnection(connection);
		}
	}

	public Participant select(Long id) throws DAOException {
		Connection connection = this.getConnection();
		Participant participant = null;
		try {
			PreparedStatement stm = connection
					.prepareStatement("SELECT (user_id, conversation_id) FROM partiticant "
							+  "WHERE id = ? ");

			stm.setLong(1, id);
			ResultSet result = stm.executeQuery();
			participant = new Participant();
			participant.setId(id);
			participant.setUserId(result.getLong(1));
			participant.setConversationId(result.getLong(2));
			return participant;
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			closeConnection(connection);
		}
	}

	public void update(Participant participant) throws DAOException {
		Connection connection = this.getConnection();
		try {
			PreparedStatement stm = connection
					.prepareStatement("UPDATE participant SET user_id = ? AND"
							+ "conversation_id = ?" + "WHERE id = ?");

			stm.setLong(1, participant.getUserId());
			stm.setLong(2, participant.getConversationId());
			stm.setLong(3, participant.getId());
			stm.execute();
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			closeConnection(connection);
		}
	}
}
