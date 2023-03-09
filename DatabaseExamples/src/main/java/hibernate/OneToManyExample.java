package hibernate;

import java.util.Date;

public class OneToManyExample {

	public static void main(String[] args) {
		CustomerDAO customerDao = new CustomerDAO();
		EmployeeDAO employeeDao = new EmployeeDAO();
		PaymentDAO paymentDao = new PaymentDAO();
		OrderDAO orderDao = new OrderDAO();
		OrderDetailDAO orderDetailDao = new OrderDetailDAO();
		ProductDAO productDao = new ProductDAO();
		
//		Employee e = employeeDao.findById(1166);
//		System.out.println(e);
//		
//		for( Customer customer : e.getCustomers()) {
//			System.out.println(customer);
//		}
		
//		System.out.println(productDao.findById(2));
//		
//		
//		Customer c = customerDao.findById(112);
//		System.out.println(c);

		/* Insert into Order */
//		Order order = new Order();
//		order.setOrderDate(new Date());
//		order.setRequiredDate(new Date());
//		order.setStatus("Hello");
//		order.setCustomer(c);
//		
//		orderDao.insert(order);
//		
//		c.getOrders().add(order);
//		customerDao.update(c);
		
		
		
		/* Add Insert for Products */
		// Need to make productLines
//		Product product = new Product();
//		product.setProductCode("Hello");
//		product.setProductName("MemeCar");
//		product.setProductLineId(2);
//		product.setProductScale("Big");
//		product.setProductVendor("Pepsi");
//		product.setProductDescription("It's really great");
//		product.setQuantityInStock(33);
//		product.setBuyPrice(69.00);
//		product.setMsrp(33.33);
//		
//		productDao.insert(product);
		
//		System.out.println(productDao.findById(2));
		
		/* Add Insert for OrderDetails */
		OrderDetail od1 = new OrderDetail();
		Product prod = productDao.findById(111);	// Memecar
		Order ord = orderDao.findById(10426);		// Hello
		od1.setOrderLineNumber(3);
		od1.setPriceEach(42.00);
		od1.setQuantityOrdered(76);
		od1.setProduct(prod);
		od1.setOrder(ord);
		od1.setProductId(111);
		od1.setOrderId(10426);
		orderDetailDao.insert(od1);
		
		prod.getOrderDetails().add(od1);
		ord.getOrderDetails().add(od1);
		
		productDao.update(prod);
		orderDao.update(ord);
		
		for( OrderDetail odd : prod.getOrderDetails()) {
			System.out.println(odd);
		}
		
		for( OrderDetail odd : ord.getOrderDetails()) {
			System.out.println(odd);
		}
		
		/* --------------------------- */
		
//		Order order1 = orderDao.findById(10100);
		
//		for( OrderDetail od : order1.getOrderDetails()) {
//			System.out.println(od);
//		}
		
		
		/* Print all orders for the customer above */
//		for( Order o : c.getOrders()) {
//			System.out.println(o);
//		}
		
		/* Insert Payment linked to Customer */
//		Payment payment = new Payment();
//		payment.setCheckNumber("THIS10KAY");
//		payment.setPaymentDate(new Date());
//		payment.setAmount(42000.00);
//		payment.setCustomerId(112);
//		payment.setCustomer(c);
//		
//		paymentDao.insert(payment);
//		
//		c.getPayments().add(payment);
//		customerDao.update(c);
		
		/* Print all payments for customer above */
//		for( Payment p : c.getPayments()) {
//			System.out.println(p);
//		}
		
		
		
		
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
