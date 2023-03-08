package hibernate;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OrderDAO {
	public Order findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// HQL - Hibernate Query Language uses JavaObject names rather than DB tables
		String hql = "FROM Order o WHERE o.id = :idParam";
		TypedQuery<Order> query = session.createQuery(hql, Order.class);
		query.setParameter("idParam", id);
		Order result = query.getSingleResult(); // This returns one customer

		session.close();
		return result;
	}

	public void update(Order order) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		session.getTransaction().begin();
		session.merge(order); // This is used to update
		session.getTransaction().commit();
		session.close();
	}

	public void insert(Order order) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		session.getTransaction().begin();
		session.save(order); // This is used to insert
		session.getTransaction().commit();
		session.close();
	}

	public void delete(Order order) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		session.getTransaction().begin();
		session.delete(order); // This is used to delete
		session.getTransaction().commit();
		session.close();
	}
}
