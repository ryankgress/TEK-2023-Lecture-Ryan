package hibernate;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MovieRentalDAO {
	public MovieRental findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// HQL - Hibernate Query Language uses JavaObject names rather than DB tables
		String hql = "FROM MovieRental mr WHERE mr.id = :idParam";
		TypedQuery<MovieRental> query = session.createQuery(hql, MovieRental.class);
		query.setParameter("idParam", id);
		MovieRental result = query.getSingleResult(); // This returns one customer

		session.close();
		return result;
	}

	public void update(MovieRental movieRental) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		session.getTransaction().begin();
		session.merge(movieRental); // This is used to update
		session.getTransaction().commit();
		session.close();
	}

	public void insert(MovieRental movieRental) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		session.getTransaction().begin();
		session.save(movieRental); // This is used to insert
		session.getTransaction().commit();
		session.close();
	}

	public void delete(MovieRental movieRental) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		session.getTransaction().begin();
		session.delete(movieRental); // This is used to delete
		session.getTransaction().commit();
		session.close();
	}
}
