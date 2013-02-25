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
		Session session = sf.openSession();
		session.beginTransaction();

		UserDAO userDao = new UserHibernateDAOImpl();
		User newUser;
		try {
			newUser = (User) userDao.findById(18);
			
			Message message1 = new Message();
			newUser.getmMessages().add(message1);
			session.update(newUser);
			
			session.getTransaction().commit();
		} catch (DAOException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}		
	}
}
