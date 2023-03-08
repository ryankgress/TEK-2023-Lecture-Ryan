package hibernate;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProductDAO {
	public Product findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// HQL - Hibernate Query Language uses JavaObject names rather than DB tables
		String hql = "FROM Product p WHERE p.id = :idParam";
		TypedQuery<Product> query = session.createQuery(hql, Product.class);
		query.setParameter("idParam", id);
		Product result = query.getSingleResult(); // This returns one customer

		session.close();
		return result;
	}

	public void update(Product product) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		session.getTransaction().begin();
		session.merge(product); // This is used to update
		session.getTransaction().commit();
		session.close();
	}

	public void insert(Product product) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		session.getTransaction().begin();
		session.save(product); // This is used to insert
		session.getTransaction().commit();
		session.close();
	}

	public void delete(Product product) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		session.getTransaction().begin();
		session.delete(product); // This is used to delete
		session.getTransaction().commit();
		session.close();
	}
}
