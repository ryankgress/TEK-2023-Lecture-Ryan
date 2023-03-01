package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BasicJDBCExamples {

	public static void main(String[] args) {
		String dburl = "jdbc:mysql://localhost:3306/classicmodels";
		String user = "root";
		String password = "apolloPA15613...";
		System.out.println("-------- MySQL JDBC Connection Demo ------------");

		try {
			Scanner keyboard = new Scanner(System.in);
			System.out.print("Enter first or last name: ");
			String name = keyboard.nextLine();
			
//			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(dburl, user, password);
//			String fName = "Steve";
			String SelectSQL = "Select * FROM employees WHERE firstName = ? or lastName = ?";
			
			PreparedStatement stmt = connection.prepareStatement(SelectSQL);
			stmt.setString(1,name);
			stmt.setString(2,name);
			
			ResultSet result = stmt.executeQuery();
			
			while (result.next()) {
				String EmployeeID = result.getString("employeeNumber");
				String fname = result.getString("firstName");
				String lname = result.getString("lastName");
				String email = result.getString("email");
				System.out.println(EmployeeID + " | " + fname + " " + lname + " | " + email);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	

}
