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
	public Long create(Message message) throws DAOException {
		Long id = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			id = (Long) session.save(message);
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
		result = (Message) session.createQuery("FROM user WHERE id = ?")
				.setParameter(1, id).uniqueResult();
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

	@Override
	public Message findByUser(User user) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> findByConversation(Conversation conversation)
			throws DAOException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("FROM messages WHERE conversation_id = :id");	
		query.setParameter("id", conversation.getId());
		@SuppressWarnings("unchecked")
		List<Message> result =  query.list();
		return null;
	}

}
