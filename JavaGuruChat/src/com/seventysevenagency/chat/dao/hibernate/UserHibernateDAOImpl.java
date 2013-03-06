package com.seventysevenagency.chat.dao.hibernate;

import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.seventysevenagency.chat.dao.DAOException;
import com.seventysevenagency.chat.dao.UserDAO;
import com.seventysevenagency.chat.domain.User;
import com.seventysevenagency.chat.util.EncryptionHelper;
import com.seventysevenagency.chat.util.HibernateUtil;

@Component
@Transactional
public class UserHibernateDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int create(User user) {
		int id;
		
		Session session = sessionFactory.getCurrentSession();
		
		user.setPassword(EncryptionHelper.md5(user.getPassword()));
		id = (Integer) session.save(user);
		
		return id;
	}

	@Override
	public void update(User user) throws DAOException {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(user);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public User findById(int id) throws DAOException {
		Session session = sessionFactory.getCurrentSession();
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
		Session session = sessionFactory.getCurrentSession();
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
		Session session = sessionFactory.getCurrentSession();
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

	@Override
	public User authorize(String username, String password) throws DAOException {
		Session session = sessionFactory.getCurrentSession();
		User user = null;
		try {
			Query query = session
					.createQuery("FROM User WHERE username = :username AND password = :password");
			query.setParameter("username", username);
			query.setParameter("password", EncryptionHelper.md5(password));
			user = (User) query.uniqueResult();
		} catch (Exception e) {
			throw new DAOException(e);
		}
		return user;
	}

	public void flushChanges() {
		Session session = sessionFactory.getCurrentSession();
		FlushMode flushMode = session.getFlushMode();
		session.setFlushMode(FlushMode.ALWAYS);
		session.flush();
		session.setFlushMode(flushMode);
	}

}
