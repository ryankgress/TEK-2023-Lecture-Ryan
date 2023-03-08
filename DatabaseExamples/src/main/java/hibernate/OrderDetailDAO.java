package hibernate;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OrderDetailDAO {
	public OrderDetail findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// HQL - Hibernate Query Language uses JavaObject names rather than DB tables
		String hql = "FROM OrderDetail od WHERE od.id = :idParam";
		TypedQuery<OrderDetail> query = session.createQuery(hql, OrderDetail.class);
		query.setParameter("idParam", id);
		OrderDetail result = query.getSingleResult(); // This returns one customer

		session.close();
		return result;
	}

	public void update(OrderDetail orderDetail) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		session.getTransaction().begin();
		session.merge(orderDetail); // This is used to update
		session.getTransaction().commit();
		session.close();
	}

	public void insert(OrderDetail orderDetail) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		session.getTransaction().begin();
		session.save(orderDetail); // This is used to insert
		session.getTransaction().commit();
		session.close();
	}

	public void delete(OrderDetail orderDetail) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		session.getTransaction().begin();
		session.delete(orderDetail); // This is used to delete
		session.getTransaction().commit();
		session.close();
	}
}
