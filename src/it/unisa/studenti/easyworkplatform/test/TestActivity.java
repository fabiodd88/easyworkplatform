package it.unisa.studenti.easyworkplatform.test;

import it.unisa.studenti.easyworkplatform.model.Activity;
import junit.framework.TestCase;

/**
 *	Class that tests important Activity methods 
 *	@author AdminEWP
*/
public class TestActivity extends TestCase {

	private Activity activity;

	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		activity = new Activity();
	}
	
	/**
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		activity = null;
	}

	/**
	 * Testing the method toString()
	 */
	public final void testToString() {
		// case 1
		activity = new Activity();
		String expected = "Activity [name=null, type=null, address=null, city=null, province=null, cap=0, vatNumber=null]";
		assertEquals(expected, activity.toString());

		// case 2
		activity = new Activity("name", "type", "address", "city", "province", 0, "vatNumber", 1);
		expected = "Activity [name=name, type=type, address=address, city=city, province=province, cap=0, vatNumber=vatNumber]";
		assertEquals(expected, activity.toString());

		// case 3
		activity = new Activity();
		expected = "Activity [name=name, type=type, address=address, city=city, province=province, cap=0, vatNumber=vatNumber]";
		assertNotSame(expected, activity.toString());
	}

	/**
	 * Testing the method equals()
	 */
	public final void testEquals() {
		// case 1
		activity = new Activity("name", "type", "address", "city", "province", 0, "vatNumber", 1);
		Activity expected = new Activity("name", "type", "address", "city", "province", 0, "vatNumber", 1);
		assertEquals(true, activity.equals(expected));

		// case 2
		activity = new Activity("name", "type", "", "city", "province", 3, "vatnumber", 1);
		expected = new Activity("name", "type", "address", "city", "province", 0, "vatNumber", 1);
		assertEquals(false, activity.equals(expected));
	}
	
	/**
	 * Testing the method clone()
	 */
	public final void testClone() {
		// case 1
		activity = new Activity("name", "type", "address", "city", "province", 0, "vatNumber", 1);
		Activity expected = activity.clone();
		assertEquals(expected, activity);

	}

}
