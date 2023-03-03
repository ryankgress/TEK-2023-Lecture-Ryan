package hibernate;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CustomerDAO {
	
	public List<Customer> findByContactFirstName(String firstName) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// HQL - Hibernate Query Language uses JavaObject names rather than DB tables
		String hql = "FROM Customer c WHERE c.contactFirstName = :fNameParam";
		TypedQuery<Customer> query = session.createQuery(hql,Customer.class);
		query.setParameter("fNameParam", firstName);
		List<Customer> results = query.getResultList();		// This can return multiple customers

		session.close();
		return results;
	}

	public Customer findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// HQL - Hibernate Query Language uses JavaObject names rather than DB tables
		String hql = "FROM Customer c WHERE c.id = :idParam";
		TypedQuery<Customer> query = session.createQuery(hql,Customer.class);
		query.setParameter("idParam", id);
		Customer result = query.getSingleResult();			// This returns one customer

		session.close();
		return result;
	}
	
	// This might not actually work. Jury's out
	public void deleteById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// HQL - Hibernate Query Language uses JavaObject names rather than DB tables
		String hql = "delete FROM Customer c WHERE c.id = :idParam";
		
		Query query = session.createQuery(hql,Customer.class);
		query.setParameter("idParam", id);
		
		session.getTransaction().begin();
		query.executeUpdate();		// Used to do an update, delete, or insert
		session.getTransaction().commit();

		session.close();
	}
	
	/** 
	 * All of this is boiler plate code
	 * @param customer the Customer object after using the setVariable commands
	 */
	public void update(Customer customer) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		session.getTransaction().begin();
		session.merge(customer);				// This is used to update
		session.getTransaction().commit();
		session.close();
	}

	public void insert(Customer customer) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		session.getTransaction().begin();
		session.save(customer);					// This is used to insert
		session.getTransaction().commit();
		session.close();
	}
	
	public void delete(Customer customer) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		session.getTransaction().begin();
		session.delete(customer);				// This is used to delete
		session.getTransaction().commit();
		session.close();
	}
}
