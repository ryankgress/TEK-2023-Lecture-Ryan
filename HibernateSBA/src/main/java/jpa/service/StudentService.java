package jpa.service;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class StudentService implements StudentDAO {

	public void getAllStudents() {
		// TODO Auto-generated method stub

	}

	public Student getStudentByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean validateStudent(String email, String password) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM Student s WHERE s.sEmail = :idParam1 AND s.sPass = :idParam2";
		
		try {
			TypedQuery<Student> query = session.createQuery(hql, Student.class);
			query.setParameter("idParam1", email);
			query.setParameter("idParam2", password);
			Student result = query.getSingleResult();
		} catch(Exception e) {
			// PUT HERE IF NO RESULT IS FOUND CODE
		}
		
		session.close();
		
	
		return false;
	}

	public void registerStudentToCourse(Student student, Course course) {
		// TODO Auto-generated method stub

	}

	public void getStudentCourses() {
		// TODO Auto-generated method stub

	}

}
