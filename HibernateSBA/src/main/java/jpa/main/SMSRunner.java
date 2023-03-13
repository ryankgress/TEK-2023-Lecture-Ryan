package jpa.main;
import java.util.Scanner;

import jpa.entitymodels.Student;
import jpa.service.CourseService;
import jpa.service.StudentService;

public class SMSRunner {

	public static void main(String[] args) {
		StudentService ss = new StudentService();
		CourseService cs = new CourseService();
		Scanner keyboard = new Scanner(System.in);
		String email;
		String password;
		Student student;
		
		System.out.println("Are you a Student? (Enter 1 or 2)");
		System.out.println("\t1) Student");
		System.out.println("\t2) Quit");
		System.out.print(">> ");
		
		try {
			if(keyboard.nextInt() == 2) {
				System.out.println("\nHave a nice day.");
				System.exit(0);
			} else if (keyboard.nextInt() == 1) {
				try {
					keyboard.nextLine();
					System.out.print("Email: ");
					email = keyboard.nextLine();
					System.out.print("Password: ");
					password = keyboard.nextLine();
					
					if(ss.validateStudent(email, password)) {
						student = ss.getStudentByEmail(email);
					}
					
				} catch(Exception e) {	// Catching invalid email/password
					System.out.println("Invalid Input. Have a nice day.");
					System.exit(0);
				}
				
			} else {					// Catching invalid menu choice
				System.out.println("Invalid Input. Have a nice day.");
				System.exit(0);
			}
		} catch(Exception e) {			// Catching invalid menu choice datatype
			System.out.println("Invalid Input. Have a nice day.");
			System.exit(0);
		}
		
		

	}

}
