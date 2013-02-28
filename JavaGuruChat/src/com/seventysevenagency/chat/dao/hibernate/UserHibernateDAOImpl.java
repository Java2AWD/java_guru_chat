package com.seventysevenagency.chat.dao.hibernate;

import org.hibernate.Query;
import org.hibernate.Session;

import com.seventysevenagency.chat.dao.DAOException;
import com.seventysevenagency.chat.dao.UserDAO;
import com.seventysevenagency.chat.domain.User;
import com.seventysevenagency.chat.util.HibernateUtil;

public class UserHibernateDAOImpl implements UserDAO {

	@Override
	public int create(User user) throws DAOException {
		int id;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			id = (Integer) session.save(user);
		} catch (Exception e) {
			throw new DAOException(e);
		}
		return id;
	}

	@Override
	public void update(User user) throws DAOException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.update(user);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public User findById(int id) throws DAOException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();		
		User user = null;
		try {
			user = (User) session.createQuery("FROM User WHERE id = :id")
					.setParameter("id", id).uniqueResult();			
			return user;
		} catch (Exception e) {
			return (User) null;
		}
		
	}

	@Override
	public int deleteById(int id) throws DAOException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int result;
		try {
			Query query = session.createQuery("DELETE User WHERE id = :id");
			query.setParameter("id", id);
			result = query.executeUpdate();
		} catch (Exception e) {
			throw new DAOException(e);
		}
		return result;
	}

	@Override
	public User findByUsername(String username) throws DAOException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		User user = null;
		try {
			user = (User) session
					.createQuery("FROM User WHERE username = :username")
					.setParameter("username", username).uniqueResult();
			return user;
		} catch (Exception e) {
			throw new DAOException(e);
		}
		
	}

}
