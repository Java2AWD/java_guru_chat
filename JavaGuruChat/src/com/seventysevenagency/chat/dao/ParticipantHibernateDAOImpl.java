package com.seventysevenagency.chat.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.seventysevenagency.chat.domain.Conversation;
import com.seventysevenagency.chat.domain.Participant;
import com.seventysevenagency.chat.util.HibernateUtil;

public class ParticipantHibernateDAOImpl implements ParticipantDAO {

	@Override
	public Long create(Participant participant) throws DAOException {
		Long id = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			id = (Long) session.save(participant);
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
	public int deleteByConversationId(Long id) throws DAOException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		int result;
		try {
			Query query = session
					.createQuery("DELETE Participant WHERE id = :id");
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
	public int deleteByConversation(Conversation conversation)
			throws DAOException {
		return deleteByConversationId(conversation.getId());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Participant> selectParticipants(Long id) throws DAOException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Participant> list = null;
		try {
			String hql = "FROM Participant WHERE conversation_id = :conversation_id";
			Query query = session.createQuery(hql);
			query.setLong("conversation_id", id);
			list = query.list();
		} catch (Exception e) {
			throw new DAOException(e);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public void update(Participant participant) throws DAOException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(participant);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			throw new DAOException(e);
		} finally {
			session.close();
		}
	}

}
