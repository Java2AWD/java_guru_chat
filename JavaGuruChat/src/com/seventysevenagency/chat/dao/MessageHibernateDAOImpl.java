package com.seventysevenagency.chat.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.seventysevenagency.chat.domain.Conversation;
import com.seventysevenagency.chat.domain.Message;
import com.seventysevenagency.chat.domain.User;
import com.seventysevenagency.chat.util.HibernateUtil;

public class MessageHibernateDAOImpl implements MessageDAO {

	@Override
	public Long create(Message message) throws DAOException {
		Long id = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			id = (Long) session.save(message);
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
	public void update(Message message) throws DAOException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(message);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			throw new DAOException(e);
		} finally {
			session.close();
		}

	}

	@Override
	public Message find(int id) throws DAOException {
		Message result = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		result = (Message) session.createQuery("FROM user WHERE id = ?")
				.setParameter(1, id).uniqueResult();
		return result;
	}

	@Override
	public void deleteById(int id) throws DAOException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.delete(find(id));
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			throw new DAOException(e);
		} finally {
			session.close();
		}
		
		

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
