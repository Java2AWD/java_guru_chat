package com.seventysevenagency.chat.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.seventysevenagency.chat.domain.Conversation;
import com.seventysevenagency.chat.util.HibernateUtil;

public class ConversationHibernateDAOImpl implements ConversationDAO {

	@Override
	public Long create(Conversation conversation) throws DAOException {
		Long id = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			id = (Long) session.save(conversation);
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
	public int deleteById(Long id) throws DAOException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		int result;
		try {
			Query query = session
					.createQuery("DELETE Conversation WHERE id = :id");
			query.setLong("id", id);
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
	public int delete(Conversation conversation) throws DAOException {
		return deleteById(conversation.getId());
	}

	@Override
	public Conversation select(Long id) throws DAOException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Conversation conversation = null;
		try {
			String hql = "FROM Conversation WHERE conversation_id = :conversation_id";
			Query query = session.createQuery(hql);
			query.setLong("conversation_id", id);
			conversation = (Conversation) query.uniqueResult();
		} catch (Exception e) {
			throw new DAOException(e);
		} finally {
			session.close();
		}
		return conversation;
	}

	@Override
	public Conversation selectLast() throws DAOException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Conversation conversation = null;
		try {
			String hql = "FROM Conversation ORDER BY id DESC";
			Query query = session.createQuery(hql);
			query.setMaxResults(1);
			conversation = (Conversation) query.uniqueResult();
		} catch (Exception e) {
			throw new DAOException(e);
		} finally {
			session.close();
		}
		return conversation;
	}

	@Override
	public void update(Conversation conversation) throws DAOException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(conversation);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			throw new DAOException(e);
		} finally {
			session.close();
		}
	}

}
