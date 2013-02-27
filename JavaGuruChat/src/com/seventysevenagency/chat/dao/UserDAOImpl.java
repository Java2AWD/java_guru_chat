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
							+ " VALUES (?, ?, ?, ?, ?);");

			stm.setString(1, user.getmName());
			stm.setString(2, user.getmSurname());
			stm.setString(3, user.getmUsername());
			stm.setString(4, user.getPassword());
			stm.setString(5, user.getmEmail());

			stm.execute();
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			closeConnection(connection);
		}
	}

	@Override
	public void update(User user) throws DAOException {
		Connection connection = this.getConnection();

		try {
			PreparedStatement stm = connection
					.prepareStatement("UPDATE users SET " + "name = ?, "
							+ "surname = ?, " + "username = ?, "
							+ "email = ? WHERE id = ?");

			stm.setString(1, user.getmName());
			stm.setString(2, user.getmSurname());
			stm.setString(3, user.getmUsername());
			stm.setString(4, user.getmEmail());
			stm.setInt(5, user.getmId());

			stm.execute();
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			closeConnection(connection);
		}
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
			if(result.next()){
				user = new User();
				user.setmId(id);
				user.setmName(result.getString(1));
				user.setmSurname(result.getString(2));
				user.setmUsername(result.getString(3));
				user.setmPassword(result.getString(4));
				user.setmEmail(result.getString(5));
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			closeConnection(connection);
		}

		return user;
	}

	@Override
	public void deleteById(int id) throws DAOException {
		Connection connection = this.getConnection();

		try {
			PreparedStatement stm = connection
					.prepareStatement("DELETE FROM users WHERE id = ?");
			stm.setInt(1, id);
			stm.execute();
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			closeConnection(connection);
		}
	}

	@Override
	public User findByUsername(String username) throws DAOException {
		Connection connection = this.getConnection();
		User user = null;
		try {
			PreparedStatement stm = connection
					.prepareStatement("SELECT id, name, surname, username, password, email "
							+ "FROM users WHERE username = ?");
			stm.setString(1, username);
			ResultSet result = stm.executeQuery();
			if(result.next()){
				user = new User();
				user.setmId(result.getInt(1));
				user.setmName(result.getString(2));
				user.setmSurname(result.getString(3));
				user.setmUsername(result.getString(4));
				user.setmPassword(result.getString(5));
				user.setmEmail(result.getString(6));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			closeConnection(connection);
		}
		return user;
	}

	@Override
	public User findById(long id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(long id) throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}

}
