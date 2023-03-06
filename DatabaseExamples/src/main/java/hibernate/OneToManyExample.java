package hibernate;

public class OneToManyExample {

	public static void main(String[] args) {
		CustomerDAO customerDao = new CustomerDAO();
		EmployeeDAO employeeDao = new EmployeeDAO();
		
		Employee e = employeeDao.findById(1166);
		System.out.println(e);
		
		for( Customer customer : e.getCustomers()) {
			System.out.println(customer);
		}
		
		

	}

}
