package it.unisa.studenti.easyworkplatform.test;

import java.util.Date;

import it.unisa.studenti.easyworkplatform.model.Customer;
import junit.framework.TestCase;

/**
 *	Class that tests important Customer methods 
 *
 *	@author AdminEWP
*/
public class TestCustomer extends TestCase {

	private Customer customer;

	/**
	 * Sets up the fixture, initializing the customer 
	 * This method is called before a test is executed
	 */
	protected void setUp() throws Exception {
		customer = new Customer();
	}

	/**
	 * Tears down the fixture, setting to null the customer
	 * This method is called after a test is executed.
	 */
	protected void tearDown() throws Exception {
		customer = null;
	}

	/**
	 * Testing the method toString()
	 */
	public final void testToString() {
		// case 1
		customer = new Customer();
		String expected = "Customer [name=null, surname=null, birthdate=null, birthplace=null, address=null, city=null, province=null, cap=0, phoneNumber=null, email=null]";
		assertEquals(expected, customer.toString());
		
		// case 2
		Date d = new Date();
		customer = new Customer("name", "surname", d, "birtplace", "address", "city", "province", 0, 0, "phoneNumber", "email");
		expected = "Customer [name=name, surname=surname, birthdate="+d+", birthplace=birtplace, address=address, city=city, province=province, cap=0, phoneNumber=phoneNumber, email=email]";
		assertEquals(expected, customer.toString());
		
		// case 3
		customer = new Customer();
		expected = "Customer [name=name, surname=surname, birthdate="+d+", birthplace=birtplace, address=address, city=city, province=province, cap=0, phoneNumber=phoneNumber, email=email]";
		assertNotSame(expected, customer.toString());
	}

	/**
	 * Testing the method equals()
	 */
	public final void testEquals(){
		// case 1
		Date d = new Date();
		customer = new Customer("name", "surname", d, "birtplace", "address", "city", "province", 0, 0, "phoneNumber", "email");
		Customer expected = new Customer("name", "surname", d, "birtplace", "address", "city", "province", 0, 0, "phoneNumber", "email");
		assertEquals(true, customer.equals(expected));

		// case 2
		d = new Date();
		customer = new Customer("name", "", new Date(), "birtPlace", "address", "city", "province", 0, 0, "phoneNumber", "email");
		expected = new Customer("name", "surname", d, "birtplace", "address", "city", "province", 0, 0, "phoneNumber", "email");
		assertEquals(false, customer.equals(expected));
	}

	/**
	 * Testing the method clone()
	 */
	public final void testClone(){
		Date d = new Date();
		customer = new Customer("name", "surname", d, "birtplace", "address", "city", "province", 0, 0, "phoneNumber", "email");
		Customer expected = customer.clone();
		assertEquals(expected, customer);
	}

}
