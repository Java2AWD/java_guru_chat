package com.seventysevenagency.chat.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.seventysevenagency.chat.domain.Conversation;
import com.seventysevenagency.chat.domain.Message;
import com.seventysevenagency.chat.domain.User;
import com.seventysevenagency.chat.util.HibernateUtil;

public class MessageHibernateDAOImpl implements MessageDAO {

	@Override
	public int create(Message message) throws DAOException {
		int id;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			id = (Integer) session.save(message);
		} catch (Exception e) {
			throw new DAOException(e);
		}
		return id;
	}

	@Override
	public void update(Message message) throws DAOException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.update(message);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public Message find(int id) throws DAOException {
		Message result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		result = (Message) session.createQuery("FROM Message WHERE id = :id")
				.setLong("id", id).uniqueResult();
		return result;
	}

	@Override
	public void deleteById(int id) throws DAOException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.delete(find(id));
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Message> findByUser(User user) throws DAOException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Message> list = null;
		try {
			String hql = "FROM Message WHERE user_id = :user_id";
			Query query = session.createQuery(hql);
			query.setLong("user_id", user.getmId());
			list = query.list();
		} catch (Exception e) {
			throw new DAOException(e);
		} finally {
			session.close();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Message> findByConversation(Conversation conversation)
			throws DAOException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Message> result = null;
		Query query = session
				.createQuery("FROM messages WHERE conversation_id = :id");
		query.setParameter("id", conversation.getId());
		try {
			result = query.list();
		} catch (Exception e) {
			throw new DAOException(e);
		}
		return result;
	}
}
