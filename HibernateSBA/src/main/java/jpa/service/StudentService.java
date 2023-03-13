package jpa.service;

import java.util.ArrayList;
import java.util.List;

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
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM Student s WHERE s.sEmail = :idParam";
		
		TypedQuery<Student> query = session.createQuery(hql, Student.class);
		query.setParameter("idParam", email);
		Student result = query.getSingleResult();
		
		session.close();
		
		return result;
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
			
			if(result != null) {
				return true;
			}
		} catch(Exception e) {
			System.out.println("No student found with that result. Have a nice day.");
			System.exit(0);
		}
		
		session.close();
		
	
		return false;
	}

	public void registerStudentToCourse(Student student, Course course) {
		// TODO Auto-generated method stub

	}

	public List<Course> getStudentCourses(Student student) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM Course c WHERE c.id IN (SELECT sc.courseId FROM StudentCourse sc where sc.studentId = :idParam)";
		TypedQuery<Course> query = session.createQuery(hql, Course.class);
		query.setParameter("idParam", student.getSId());
		
		List<Course> courseList = query.getResultList();
//		if(courseList != null) {
//			for(Course c : courseList) {
//				System.out.printf("%-30s\t%s\n", c.getCName(), c.getCInstructorName());
//			}
//		} else {
//			System.out.println("No active courses registered.");
//		}
		
		session.close();
		return courseList;
	}

}
