package hibernate;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserDAO {
	public User findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// HQL - Hibernate Query Language uses JavaObject names rather than DB tables
		String hql = "FROM User u WHERE u.id = :idParam";
		TypedQuery<User> query = session.createQuery(hql, User.class);
		query.setParameter("idParam", id);
		User result = query.getSingleResult(); // This returns one customer

		session.close();
		return result;
	}

	public void update(User user) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		session.getTransaction().begin();
		session.merge(user); // This is used to update
		session.getTransaction().commit();
		session.close();
	}

	public void insert(User user) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		session.getTransaction().begin();
		session.save(user); // This is used to insert
		session.getTransaction().commit();
		session.close();
	}

	public void delete(User user) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		session.getTransaction().begin();
		session.delete(user); // This is used to delete
		session.getTransaction().commit();
		session.close();
	}
}
