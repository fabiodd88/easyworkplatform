package it.unisa.studenti.easyworkplatform.test;

import java.util.Date;

import it.unisa.studenti.easyworkplatform.model.Account;
import it.unisa.studenti.easyworkplatform.model.User;
import junit.framework.TestCase;

/**
 *	Class that tests important Activity methods 
 *	@author AdminEWP
*/
public class TestUser extends TestCase {

	private User user;
	
	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		user = new User();
	}

	/**
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		user = null;
	}

	/**
	 * Testing the method toString()
	 */
	public final void testToString() {
		// case 1
		user = new User();
		String expected = "User[id=0, email=null, password=null, secondKey=null]User [name=null, surename=null, birthdate=null, birthplace=null, address=null, city=null, province=null, cap=0, taxCode=null]";
		assertEquals(expected, user.toString());
		
		// case 2
		Account a = new Account("email", "password", "secondKey");
		Date d = new Date();
		user = new User(a, "name", "surname", d, "birthplace", "address", "city", "province", 0, "taxCode");
		expected = "User[id=0, email=email, password=password, secondKey=secondKey]User [name=name, surename=surname, birthdate="+d+", birthplace=birthplace, address=address, city=city, province=province, cap=0, taxCode=taxCode]";
		assertEquals(expected, user.toString());
		
		// case 3
		a = new Account("", "password", "secondKey");
		d = new Date();
		user = new User(a, "NAme", "surname", d, "birthplace", "address", "city", "province", 0, "taxCode");
		expected = "User[id=0, email=email, password=password, secondKey=secondKey]User [name=name, surename=surname, birthdate="+d+", birthplace=birthplace, address=address, city=city, province=province, cap=0, taxCode=taxCode]";
		assertNotSame(expected, user.toString());
	}
	
	/**
	 * Testing the method equals()
	 */
	public final void testEquals(){
		// case 1
		Account a = new Account("email", "password", "secondKey");
		Date d = new Date();
		user = new User(a, "name", "surname", d, "birthplace", "address", "city", "province", 0, "taxCode");
		User expected = new User(a, "name", "surname", d, "birthplace", "address", "city", "province", 0, "taxCode");
		assertEquals(true, user.equals(expected));
		
		// case 2
		a = new Account("email", "password", "secondKey");
		d = new Date();
		user = new User(a, "name", "surname", d, "birthplace", "address", "city", "province", 0, "taxCode");
		expected = new User(a, "", "surname", d, "birthplace", "addreSS", "city", "provInce", 1, "taxCode");
		assertEquals(false, user.equals(expected));
	}
	
	/**
	 * Testing the method clone()
	 */
	public final void testClone(){
		// case 1
		Account a = new Account("email", "password", "secondKey");
		Date d = new Date();
		user = new User(a, "name", "surname", d, "birthplace", "address", "city", "province", 0, "taxCode");
		User expected = user.clone();
		assertEquals(expected, user);
	}
}
