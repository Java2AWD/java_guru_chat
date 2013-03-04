import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.seventysevenagency.chat.dao.DAOException;
import com.seventysevenagency.chat.dao.UserDAO;
import com.seventysevenagency.chat.dao.hibernate.UserHibernateDAOImpl;
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
			newUser = (User) userDao.findById(23);			
			Set<Message> messages = newUser.getMessages();	
			Message msg = new Message();
			msg.setText("Hi1");
			messages.add(msg);
			session.getTransaction().commit();
		} catch (DAOException e) {
			e.printStackTrace();
		} finally {
		}		
	}
}
