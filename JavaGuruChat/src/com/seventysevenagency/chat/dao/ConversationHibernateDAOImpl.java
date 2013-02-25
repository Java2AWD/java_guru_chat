package com.seventysevenagency.chat.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.seventysevenagency.chat.domain.Conversation;
import com.seventysevenagency.chat.util.HibernateUtil;

public class ConversationHibernateDAOImpl implements ConversationDAO {

	@Override
	public Long create(Conversation conversation) throws DAOException {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Long conversationId = null;
		try {
			transaction = session.beginTransaction();
			conversationId = (Long) session.save(conversation);
			transaction.commit();

		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return conversationId;
	}

	@Override
	public void delete(Long id) throws DAOException {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Conversation conversation = (Conversation) session.get(
					Conversation.class, id);
			session.delete(conversation);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public Conversation select(Long id) throws DAOException {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public void update(Conversation conversation) throws DAOException {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(conversation);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
