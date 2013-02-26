import java.util.Iterator;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.seventysevenagency.chat.dao.DAOException;
import com.seventysevenagency.chat.dao.UserDAO;
import com.seventysevenagency.chat.dao.UserHibernateDAOImpl;
import com.seventysevenagency.chat.domain.Message;
import com.seventysevenagency.chat.domain.User;
import com.seventysevenagency.chat.util.HibernateUtil;

public class TestEntryPoint {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		UserDAO userDao = new UserHibernateDAOImpl();
		User newUser;
		try {
			newUser = (User) userDao.findById(10);			
			Set<Message> messages = newUser.getmMessages();	
			messages.add(new Message());
			messages.add(new Message());
			session.update(newUser);
			session.getTransaction().commit();
		} catch (DAOException e) {
			e.printStackTrace();
		} finally {
		}		
	}
}
