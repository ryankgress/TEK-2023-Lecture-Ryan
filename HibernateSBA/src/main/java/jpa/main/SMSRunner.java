package jpa.main;

import java.util.List;
import java.util.Scanner;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.CourseService;
import jpa.service.StudentService;

public class SMSRunner {

	public static void main(String[] args) {
		SMSRunner main = new SMSRunner();
		StudentService ss = new StudentService();
		CourseService cs = new CourseService();
		Scanner keyboard = new Scanner(System.in);

		Student student = main.login();
		main.register(student);

	}

	/**
	 * Runs the first prompt and validates student email/password combination
	 * 
	 * @return student if verified
	 */
	public Student login() {
		StudentService ss = new StudentService();
		Scanner keyboard = new Scanner(System.in);
		Student student;

		System.out.println("Are you a Student? (Enter 1 or 2)");
		System.out.println("\t1) Student");
		System.out.println("\t2) Quit");
		System.out.print(">> ");
		String ans = keyboard.nextLine();

		try {
			if (ans.equals("2")) {
				System.out.println("\nHave a nice day.");
				System.exit(0);
			} else if (ans.equals("1")) {
				try {
					System.out.print("Email: ");
					String email = keyboard.nextLine();
					System.out.print("Password: ");
					String password = keyboard.nextLine();
					System.out.println("Email: " + email + " | Pass: " + password);

					if (ss.validateStudent(email, password)) {
						student = ss.getStudentByEmail(email);
						return student;
					} else {
						System.out.println("Couldn't find you");
					}

				} catch (Exception e) { // Catching invalid email/password
					System.out.println("Email/Pass not found. Have a nice day.");
					e.printStackTrace();
					System.exit(0);
				}

			} else { // Catching invalid menu choice
				System.out.println("Invalid Input. Have a nice day.");
				System.exit(0);
			}
		} catch (Exception e) { // Catching invalid menu choice datatype
			System.out.println("Invalid Input. Have a nice day.");
			System.exit(0);
		}

		keyboard.close();
		return null;

	}

	public void register(Student student) {
		Scanner keyboard = new Scanner(System.in);
		StudentService ss = new StudentService();
		CourseService cs = new CourseService();

		List<Course> courseList = ss.getStudentCourses(student);

		System.out.println("Welcome " + student.getSName() + "! Here are your classes:");

		printCourseList(courseList);

		System.out.println("\nWould you like to register any classes? (Enter 1 or 2)");
		System.out.println("\t1) Register a Class");
		System.out.println("\t2) Log Out");
		System.out.print(">> ");
		String ans = keyboard.nextLine();

		try {
			if (ans.equals("2")) {
				System.out.println("\nHave a nice day.");
				System.exit(0);
			} else if (ans.equals("1")) {
				List<Course> allCourses = cs.getAllCourses();

				System.out.println("Available Courses:");
				for (Course c : allCourses) {
					System.out.printf("%d)\t%-30s\t%s\n", c.getCId(), c.getCName(), c.getCInstructorName());
				}
				
				System.out.print("\nEnter the course number of the desired course: ");
				String courseStr = keyboard.nextLine();
				int courseNum = 0;
				try {
					courseNum = Integer.parseInt(courseStr);
					if (courseNum >= 11 || courseNum <= 0) { // Catching invalid course number
						System.out.println("Course Number not Found.");
						System.exit(0);
					}

					for (Course c : courseList) {			// Catching registered courses
						if (c.getCId() == courseNum) {
							System.out.println("Already registered for " + c.getCName());
							System.exit(0);
						}
					}

					courseList.add(cs.findCourseById(courseNum));
					ss.registerStudentToCourse(student, cs.findCourseById(courseNum));

					System.out.println("Here is your new Course List:\n");
					printCourseList(courseList);
					// Add to DB and courseList, then print new courselist and exit

				} catch (Exception e) { // Catches non-integer input
					System.out.println("Invalid Input. Have a nice day.");
//					e.printStackTrace(); 
				}

			} else { // Catching invalid menu choice
				System.out.println("Invalid Input. Have a nice day.");
				System.exit(0);
			}
		} catch (Exception e) { // Catching invalid menu choice datatype
			System.out.println("Invalid Input. Have a nice day.");
			System.exit(0);
		}
	}

	public void printCourseList(List<Course> courseList) {
		if (courseList != null) {
			for (Course c : courseList) {
				System.out.printf("%-30s\t%s\n", c.getCName(), c.getCInstructorName());
			}
		} else {
			System.out.println("No active courses registered.");
		}
	}
}
