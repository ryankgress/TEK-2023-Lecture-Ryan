package hibernate;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MovieDAO {
	public Movie findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// HQL - Hibernate Query Language uses JavaObject names rather than DB tables
		String hql = "FROM Movie m WHERE m.id = :idParam";
		TypedQuery<Movie> query = session.createQuery(hql, Movie.class);
		query.setParameter("idParam", id);
		Movie result = query.getSingleResult(); // This returns one customer

		session.close();
		return result;
	}

	public void update(Movie movie) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		session.getTransaction().begin();
		session.merge(movie); // This is used to update
		session.getTransaction().commit();
		session.close();
	}

	public void insert(Movie movie) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		session.getTransaction().begin();
		session.save(movie); // This is used to insert
		session.getTransaction().commit();
		session.close();
	}

	public void delete(Movie movie) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		session.getTransaction().begin();
		session.delete(movie); // This is used to delete
		session.getTransaction().commit();
		session.close();
	}
}
