package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AggregateJDBCExample {

	public static void main(String[] args) {
		String dburl = "jdbc:mysql://localhost:3306/classicmodels";
		String user = "root";
		String password = "apolloPA15613...";
		System.out.println("-------- MySQL JDBC Connection Demo ------------");

		try {
			Scanner keyboard = new Scanner(System.in);
			System.out.print("Enter an amount: ");
			int amt = keyboard.nextInt();
			
//			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(dburl, user, password);
			String SelectSQL = "select c.customerNumber, c.customerName, avg((MSRP - buyPrice)*quantityOrdered) as avg_margin\r\n"
					+ "from orders o, orderdetails od, products p, customers c\r\n"
					+ "where o.orderNumber = od.orderNumber\r\n"
					+ "and od.productCode = p.productCode\r\n"
					+ "and o.customerNumber = c.customerNumber\r\n"
					+ "group by c.customerNumber\r\n"
					+ "having avg((MSRP - buyPrice)*quantityOrdered) > ?\r\n"
					+ "order by avg_margin desc;";
			
			
			PreparedStatement stmt = connection.prepareStatement(SelectSQL);
			stmt.setInt(1,amt);
			
			ResultSet result = stmt.executeQuery();
			
			while (result.next()) {
				String customerNumber = result.getString("customerNumber");
				String customerName = result.getString("customerName");
				double averageMargin = result.getDouble("avg_margin");
//				System.out.println(customerNumber + " | " + customerName + " | " + averageMargin);
				System.out.printf("%s | %-30s | %f\n", customerNumber, customerName, averageMargin);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	

}
