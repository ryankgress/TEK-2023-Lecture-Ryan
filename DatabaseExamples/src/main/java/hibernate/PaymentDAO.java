package hibernate;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PaymentDAO {
	public Payment findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// HQL - Hibernate Query Language uses JavaObject names rather than DB tables
		String hql = "FROM Payment p WHERE p.id = :idParam";
		TypedQuery<Payment> query = session.createQuery(hql,Payment.class);
		query.setParameter("idParam", id);
		Payment result = query.getSingleResult();			// This returns one customer

		session.close();
		return result;
	}
	
	public void update(Payment payment) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		session.getTransaction().begin();
		session.merge(payment);				// This is used to update
		session.getTransaction().commit();
		session.close();
	}

	public void insert(Payment payment) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		session.getTransaction().begin();
		session.save(payment);					// This is used to insert
		session.getTransaction().commit();
		session.close();
	}
	
	public void delete(Payment payment) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		session.getTransaction().begin();
		session.delete(payment);				// This is used to delete
		session.getTransaction().commit();
		session.close();
	}
}
