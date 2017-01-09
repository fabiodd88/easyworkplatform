package it.unisa.studenti.easyworkplatform.test;

import java.sql.Date;

import it.unisa.studenti.easyworkplatform.model.Service;
import junit.framework.TestCase;

/**
 *	Class that tests important Service methods 
 *	@author AdminEWP
*/
public class TestService extends TestCase {

	private Service service;

	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		service = new Service();
	}

	/**
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		service = null;
	}

	/**
	 * Testing the method toString()
	 */
	public final void testToString() {
		// case 1
		service = new Service();
		String expected = "Service [employee=null, quantity=0, variation=null, note=null, recepitDate=null, returnDate=null, articleId=0, customerId=0]";
		assertEquals(expected, service.toString());
		
		// case 2
		Date d = Date.valueOf("2017-01-01");
		service = new Service("employee", 1, "variation", "note", d, d, 1, 1);
		expected = "Service [employee=employee, quantity=1, variation=variation, note=note, recepitDate="+d+", returnDate="+d+", articleId=1, customerId=1]";
		assertEquals(expected, service.toString());
		
		// case 3
		service = new Service();
		expected = "Service [employee=employee, quantity=1, variation=variation, note=note, recepitDate="+d+", returnDate="+d+", articleId=1, customerId=1]";
		assertNotSame(expected, service.toString());
	}

	/**
	 * Testing the method equals()
	 */	
	public final void testEquals(){
		// case 1
		Date d = Date.valueOf("2017-01-01");
		service = new Service("employee", 1, "variation", "note", d, d, 1, 1);
		Service expected = new Service("employee", 1, "variation", "note", d, d, 1, 1);
		assertEquals(true, service.equals(expected));
		
		// case 2
		d = Date.valueOf("2017-01-01");
		service = new Service("employee", 1, "variation", "note", d, d, 0, 0);
		expected = new Service("employEE", 1, "variaAtion", "note", d, d, 1, 1);
		assertEquals(false, service.equals(expected));
	}

	/**
	 * Testing the method clone()
	 */	
	public final void testClone(){
		// case 1
		Date d = Date.valueOf("2017-01-01");
		service = new Service("employee", 1, "variation", "note", d, d, 1, 1);
		Service expected = service.clone();
		assertEquals(expected, service);
	}
	
}
