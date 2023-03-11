package jpa.dao;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public interface StudentDAO {
	
	void getAllStudents();
	
	Student getStudentByEmail(String email);
	
	boolean validateStudent(String email, String password);
	
	void registerStudentToCourse(Student student, Course course);
	
	void getStudentCourses();
}
