package it.unisa.studenti.easyworkplatform.test;

import it.unisa.studenti.easyworkplatform.model.Account;
import junit.framework.TestCase;

/**
 *	Class that tests important Account methods 
 *	@author AdminEWP
*/
public class TestAccount extends TestCase {

	private Account account;

	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		account = new Account();
	}

	/**
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		account = null;
	}

	/**
	 * Testing the method toString()
	 */
	public final void testToString() {
		// case 1
		account = new Account();
		String expected = "Account[id=0, email=null, password=null, secondKey=null]";
		assertEquals(expected, account.toString());

		// case 2
		account = new Account("anemail@domain.com", "password", "secondKey");
		expected = "Account[id=0, email=anemail@domain.com, password=password, secondKey=secondKey]";
		assertEquals(expected, account.toString());

		// case 3
		account = new Account("anemail@domain.com", "password", "secondKey");
		expected = "Account[id=0, email=null, password=null, secondKey=null]";
		assertNotSame(expected, account.toString());
	}

	/**
	 * Testing the method equals()
	 */
	public final void testEquals() {
		// case 1
		account = new Account("anemail@domain.com", "password", "secondKey");
		Account expected = new Account("anemail@domain.com", "password", "secondKey");
		assertEquals(true, account.equals(expected));

		// case 3
		account = new Account("anemail@domain.com", "", "secondKey");
		expected = new Account("anemail@domain.com", "password", "secondKey");
		assertEquals(false, account.equals(expected));
	}
	
	/**
	 * Testing the method clone()
	 */
	public final void testClone() {
		// case 1
		account = new Account("anemail@domain.com", "password", "secondKey");
		Account expected = account.clone();
		assertEquals(expected, account);
	}

}
