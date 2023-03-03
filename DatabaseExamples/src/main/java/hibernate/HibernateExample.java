package hibernate;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateExample {

	public static void main(String[] args) {
		CustomerDAO customerDao = new CustomerDAO();
		
		/* Insert */
//		Customer customer = new Customer();
//		customer.setCustomerName("Hibernate Customer");
//		customer.setContactFirstName("Ryan");
//		customer.setContactLastName("Gress");
//		customer.setPhone("123-456-7890");
//		customer.setAddressLine1("1056 Meadowview Drive");
//		customer.setCity("Apollo");
//		customer.setState("PA");
//		customer.setPostalCode("15613");
//		customer.setCountry("USA");
//		customer.setCreditLimit(40000.00);
//		
//		customerDao.insert(customer);
		
		
		/* Delete */
//		Customer deleteCust = customerDao.findById(501);
//		customerDao.delete(deleteCust);
		
		
		/* Find by ID */
//		System.out.println(customerDao.findById(501).toString());
		
		
		/* Print list of findByFirstName rows */
//		List<Customer> firstNames = customerDao.findByContactFirstName("Leslie");
//		for (Customer c : firstNames) {
//			System.out.println(c.toString());
//		}
		
		
		/* Update */
//		Customer first = customerDao.findById(501);
//		first.setAddressLine2("This is an update");
//		first.setPostalCode("12345");
//		first.setCreditLimit(100000.35);
//		
//		customerDao.update(first);

	}
	
	

}
