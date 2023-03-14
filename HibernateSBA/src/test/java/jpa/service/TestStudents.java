package jpa.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import jpa.entitymodels.Student;


public class TestStudents {
	
	private static StudentService ss = new StudentService();
	
	@Test
	public void validateStudentTest() {
		
		// Given
		String email = "cstartin3@flickr.com";
		String pass = "XYHzJ1S";
		
		// When 
		boolean expectedTrue = ss.validateStudent(email, pass);
		
		// Then
		Assertions.assertTrue(expectedTrue);
//		Assertions.assertFalse(ss.validateStudent(email, wrongPass));
		
	}
	
	@Test
	public void getStudentByEmailTest() {
		
		// Given
		String email = "cstartin3@flickr.com";
		String name = "Clem Startin";
		String pass = "XYHzJ1S";
		String fakePass = "Not it";
		
		// When
		Student student = ss.getStudentByEmail(email);
		
		// Then
		Assertions.assertEquals(student.getSName(), name);
		Assertions.assertEquals(student.getSPass(), pass);
		Assertions.assertNotEquals(student.getSPass(), fakePass);
	}
	
	@Test
	public void getStudentCoursesTest() {
		ss.getStudentCourses(ss.getStudentByEmail("ryankgress@gmail.com"));
	}
}
