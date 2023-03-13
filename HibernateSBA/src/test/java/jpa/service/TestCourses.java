package jpa.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class TestCourses {
	private static CourseService cs = new CourseService();
	
	@Test
	public void findCourseByIdTest() {
		// Given
				String name = "Digital Logic";
				String instructor = "Glenden Reilingen";;
				
				// When
				Course course = cs.findCourseById(6);
				
				// Then
				Assertions.assertEquals(course.getCName(), name);
				Assertions.assertEquals(course.getCInstructorName(), instructor);
	}
}
