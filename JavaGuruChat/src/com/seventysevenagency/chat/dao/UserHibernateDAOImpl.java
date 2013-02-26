package com.seventysevenagency.chat.dao;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.seventysevenagency.chat.domain.User;
import com.seventysevenagency.chat.util.HibernateUtil;

public class UserHibernateDAOImpl implements UserDAO {

	@Override
	public int create(User user) throws DAOException {
		int id;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			id = (Integer) session.save(user);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			throw new DAOException(e);
		} finally {
			session.close();
		}
		return id;
	}

	@Override
	public void update(User user) throws DAOException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(user);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			throw new DAOException(e);
		} finally {
			session.close();
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
		Transaction transaction = session.beginTransaction();
		int result;
		try {
			Query query = session.createQuery("DELETE User WHERE id = :id");
			query.setParameter("id", id);
			result = query.executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			throw new DAOException(e);
		} finally {
			session.close();
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
		} catch (Exception e) {
			throw new DAOException(e);
		} finally {
			session.close();
		}
		return user;
	}

}
