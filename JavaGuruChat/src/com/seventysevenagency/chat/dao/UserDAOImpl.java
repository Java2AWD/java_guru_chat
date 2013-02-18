package com.seventysevenagency.chat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.seventysevenagency.chat.domain.User;

public class UserDAOImpl extends BaseDAO implements UserDAO {

	@Override
	public void create(User user) throws DAOException {
		Connection connection = this.getConnection();

		try {
			PreparedStatement stm = connection
					.prepareStatement("INSERT INTO users "
							+ "(name, surname, username, password, email)"
							+ " VALUES (?, ?, ?, SHA1(?), ?);");

			stm.setString(1, user.getName());
			stm.setString(2, user.getSurname());
			stm.setString(3, user.getUsername());
			stm.setString(4, user.getPassword());
			stm.setString(5, user.getEmail());

			stm.execute();
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		closeConnection(connection);
	}

	@Override
	public void update(User user) throws DAOException {
		Connection connection = this.getConnection();

		try {
			PreparedStatement stm = connection
					.prepareStatement("UPDATE users SET " + "name = ?, "
							+ "surname = ?, " + "username = ?, "
							+ "email = ? WHERE id = ?");

			stm.setString(1, user.getName());
			stm.setString(2, user.getSurname());
			stm.setString(3, user.getUsername());
			stm.setString(4, user.getEmail());
			stm.setInt(5, user.getId());

			stm.execute();
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		closeConnection(connection);
	}

	@Override
	public User find(int id) throws DAOException {
		Connection connection = this.getConnection();

		User user = null;
		try {
			PreparedStatement stm = connection
					.prepareStatement("SELECT name, surname, username, password, email "
							+ "FROM users WHERE id = ?");

			stm.setInt(1, id);

			ResultSet result = stm.executeQuery();
			user = new User();
			user.setId(id);
			user.setName(result.getString(1));
			user.setSurname(result.getString(2));
			user.setUsername(result.getString(3));
			user.setPassword(result.getString(4));
			user.setEmail(result.getString(5));

		} catch (SQLException e) {
			throw new DAOException(e);
		}

		closeConnection(connection);
		return user;
	}

	@Override
	public void deleteById(int id) throws DAOException {
		Connection connection = this.getConnection();

		PreparedStatement stm;
		try {
			stm = connection.prepareStatement("DETELE FROM users WHERE id = ?");
			stm.setInt(1, id);
			stm.execute();
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		closeConnection(connection);
	}

}
