package it.unisa.studenti.easyworkplatform.test;

import java.util.Date;

import it.unisa.studenti.easyworkplatform.model.Payment;
import junit.framework.TestCase;

/**
 *	Class that tests important Payment methods 
 *	@author AdminEWP
*/
public class TestPayment extends TestCase {

	private Payment payment;

	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		payment = new Payment();
	}

	/**
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		payment = null;
	}

	/**
	 * Testing the method toString()
	 */
	public final void testToString() {

		// case 1
		payment = new Payment();
		String expected = "Payment [date=null, amount=0.0, serviceCustomerId=0, serviceId=0, serviceArticleId=0]";
		assertEquals(expected,payment.toString());

		// case 2
		Date d = new Date();
		payment = new Payment(0.0, d, 0, 0, 0);
		expected = "Payment [date="+d+", amount=0.0, serviceCustomerId=0, serviceId=0, serviceArticleId=0]";
		assertEquals(expected,payment.toString());
		
		// case 3
		payment = new Payment();
		expected = "Payment [date=Tue Jan 03 23:26:35 CET 2017, amount=0.0, serviceCustomerId=0, serviceId=0, serviceArticleId=0]";
		assertNotSame(expected,payment.toString());
	}

	/**
	 * Testing the method equals()
	 */	
	public final void testEquals(){

		// case 1
		Date d = new Date();
		payment = new Payment(0.0, d, 0, 0, 0);
		Payment expected = new Payment(0.0, d, 0, 0, 0);
		assertEquals(true,payment.equals(expected));
		
		// case 2
		d = new Date();
		payment = new Payment(1.1, new Date(), 0, 0, 0);
		expected = new Payment(0.0, d, 0, 0, 0);
		assertEquals(false,payment.equals(expected));
	}

	/**
	 * Testing the method clone()
	 */	
	public final void testClone(){
		// case 1
		Date d = new Date();
		payment = new Payment(0.0, d, 0, 0, 0);
		Payment expected = payment.clone();
		assertEquals(expected, payment);
		
	}
	
}
