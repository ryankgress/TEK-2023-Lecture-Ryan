package jpa.service;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;

public class CourseService implements CourseDAO {

	public List<Course> getAllCourses() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "FROM Course";

		TypedQuery<Course> query = session.createQuery(hql, Course.class);
		
		List<Course> results = query.getResultList();
		
		session.close();
		return results;
	}
	
	public Course findCourseById(int id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Course c WHERE c.id = :idParam";
		TypedQuery<Course> query = session.createQuery(hql, Course.class);
		query.setParameter("idParam", id);
		Course result = query.getSingleResult(); 

		session.close();
		return result;
		
	}

}
