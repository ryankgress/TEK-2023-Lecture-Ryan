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
		
		/** Insert Customer w/ employee number **/
//		Customer customer = new Customer();
//		customer.setCustomerName("New Hibernate Customer");
//		customer.setContactFirstName("Ryan");
//		customer.setContactLastName("Gress");
//		customer.setPhone("123-456-7890");
//		customer.setAddressLine1("1056 Meadowview Drive");
//		customer.setCity("Apollo");
//		customer.setState("PA");
//		customer.setPostalCode("15613");
//		customer.setCountry("USA");
//		customer.setCreditLimit(40000.00);
//		customer.setEmployee(e);
//		
//		customerDao.insert(customer);
		
//		e.getCustomers().add(customer);
//		employeeDao.update(e);
		

	}

}
