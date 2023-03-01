package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Homework1 {

	public static void main(String[] args) {
		String dburl = "jdbc:mysql://localhost:3306/classicmodels";
		String user = "root";
		String password = "apolloPA15613...";
		System.out.println("-------- MySQL JDBC Connection Demo ------------");

		try {
			Scanner keyboard = new Scanner(System.in);
			System.out.print("Enter an amount: ");
			int amt = keyboard.nextInt();
			keyboard.nextLine();
			System.out.print("Enter a State: ");
			String state = keyboard.nextLine();

//			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(dburl, user, password);
			String SelectSQL = "select p.checkNumber, p.amount, c.customerName\r\n"
					+ "from payments p left join customers c using (customerNumber)\r\n"
					+ "where p.amount > ? and c.state = ?\n"
					+ "order by p.amount desc;";

			PreparedStatement stmt = connection.prepareStatement(SelectSQL);
			stmt.setDouble(1, amt);
			stmt.setString(2, state);

			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				String checkNumber = result.getString("checkNumber");
				double amount = result.getDouble("amount");
				String customerName = result.getString("customerName");
//				System.out.println(customerNumber + " | " + customerName + " | " + averageMargin);
				System.out.printf("%-9s | $%9.2f | %s\n", checkNumber, amount, customerName);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
