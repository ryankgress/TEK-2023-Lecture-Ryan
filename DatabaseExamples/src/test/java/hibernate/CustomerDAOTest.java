package hibernate;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;


public class CustomerDAOTest {
	
	private static CustomerDAO customerDao;
	
	@BeforeAll
	public static void setUp() {
		customerDao = new CustomerDAO();
	}
	
	@Test
	public void findByIdTest() {
		
		// Given
		Customer expected = new Customer();
		expected.setCustomerName("Atelier graphique");
		expected.setContactLastName("Schmitt");
		expected.setContactFirstName("Carine");
		
		// When
		Customer actual = customerDao.findById(103);	// Should point to above customer
		
		// Then
		Assertions.assertEquals(expected.getCustomerName(), actual.getCustomerName());
		Assertions.assertEquals(expected.getContactFirstName(), actual.getContactFirstName());
		Assertions.assertEquals(expected.getContactLastName(), actual.getContactLastName());
	}
	
	@ParameterizedTest
	@CsvSource({
		"103,Atelier graphique,Schmitt,Carine",
		"112,Signal Gift Stores,King,Jean"
		})
	public void findByIdParameterizedTest(ArgumentsAccessor arguments) {
		
		// Given
		Customer expected = new Customer();
		expected.setCustomerName(arguments.getString(1));
		expected.setContactLastName(arguments.getString(2));
		expected.setContactFirstName(arguments.getString(3));
		
		// When
		Customer actual = customerDao.findById(arguments.getInteger(0));	// Should point to above customer
		
		// Then
		Assertions.assertEquals(expected.getCustomerName(), actual.getCustomerName());
		Assertions.assertEquals(expected.getContactFirstName(), actual.getContactFirstName());
		Assertions.assertEquals(expected.getContactLastName(), actual.getContactLastName());
	}
	
}
