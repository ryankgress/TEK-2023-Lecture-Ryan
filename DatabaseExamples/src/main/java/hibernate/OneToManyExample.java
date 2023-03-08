package hibernate;

public class OneToManyExample {

	public static void main(String[] args) {
		CustomerDAO customerDao = new CustomerDAO();
		EmployeeDAO employeeDao = new EmployeeDAO();
		PaymentDAO paymentDao = new PaymentDAO();
		
//		Employee e = employeeDao.findById(1166);
//		System.out.println(e);
//		
//		for( Customer customer : e.getCustomers()) {
//			System.out.println(customer);
//		}
		
		
		
		Customer c = customerDao.findById(112);
		System.out.println(c);
		
		/* Insert */
		Payment payment = new Payment();
		payment.setCheckNumber("THIS10KAY");
		payment.setPaymentDate(new java.sql.Date(300000));
		payment.setAmount(42000.00);
		payment.setCustomerId(112);
		payment.setCustomer(c);
		
		paymentDao.insert(payment);
		
		c.getPayments().add(payment);
		customerDao.update(c);
		
		for( Payment p : c.getPayments()) {
			System.out.println(p);
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
