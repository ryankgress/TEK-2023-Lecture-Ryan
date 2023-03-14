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

		Student student = main.login();
		main.register(student);

	}

	/**
	 * Runs the first prompt and validates student email/password combination with ss.validateStudent()
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

		return null;

	}

	/**
	 * Handles the remaining menu prompts. Also Lists the current classes, provides implementation for registering
	 * new ones, and prints the list of updated courses upon expected completion.
	 * @param student - The student performing the operation, following a valid login in main()
	 */
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

					for (Course c : courseList) {			// Catching already-registered courses
						if (c.getCId() == courseNum) {
							System.out.println("You're already registered for " + c.getCName() + "!");
							System.exit(0);
						}
					}

					courseList.add(cs.findCourseById(courseNum));
					ss.registerStudentToCourse(student, cs.findCourseById(courseNum));

					System.out.println("Here is your new Course List:");
					printCourseList(courseList);

				} catch (Exception e) { // Catching non-integer input
					System.out.println("Invalid Input. Have a nice day.");
				}

			} else { 					// Catching invalid menu choice
				System.out.println("Invalid Input. Have a nice day.");
				System.exit(0);
			}
		} catch (Exception e) { 		// Catching invalid menu choice datatype
			System.out.println("Invalid Input. Have a nice day.");
			System.exit(0);
		}
	}

	/**
	 * Lists all courses for the current student. Was called often, so formatted and put in method.
	 * @param courseList list of all courses a student is registered for.
	 */
	public void printCourseList(List<Course> courseList) {
		if (courseList != null) {
			System.out.println("--------------------------------------------------");
			for (Course c : courseList) {
				System.out.printf("%-30s\t%s\n", c.getCName(), c.getCInstructorName());
			}
			System.out.println("--------------------------------------------------");
		} else {
			System.out.println("No active courses registered.");
		}
	}
}
