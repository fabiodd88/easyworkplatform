package it.unisa.studenti.easyworkplatform.test;

import it.unisa.studenti.easyworkplatform.model.Newsletter;
import junit.framework.TestCase;

/**
 *	Class that tests important Newsletter methods 
 *	@author AdminEWP
*/
public class TestNewsletter extends TestCase {

	private Newsletter newsletter;

	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		newsletter = new Newsletter();
	}

	/**
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		newsletter = null;
	}

	/**
	 * Testing the method toString()
	 */
	public final void testToString() {
		// case 1
		newsletter = new Newsletter();
		String expected = "Newsletter [sender=null, receiver=null, object=null, message=null]";
		assertEquals(expected, newsletter.toString());
		
		// case 2
		newsletter = new Newsletter("sender", "receiver", "object", "message");
		expected = "Newsletter [sender=sender, receiver=receiver, object=object, message=message]";
		assertEquals(expected, newsletter.toString());
		
		// case 3
		newsletter = new Newsletter();
		expected = "Newsletter [sender=sender, receiver=receiver, object=object, message=message]";
		assertNotSame(expected, newsletter.toString());
		
	}

	/**
	 * Testing the method equals()
	 */	
	public final void testEquals(){
		// case 1
		newsletter = new Newsletter("sender", "receiver", "object", "message");
		Newsletter expected = new Newsletter("sender", "receiver", "object", "message");
		assertEquals(true, newsletter.equals(expected));
		
		// case 2
		newsletter = new Newsletter("", "receIver", "object", "message");
		expected = new Newsletter("sender", "receiver", "object", "message");
		assertEquals(false, newsletter.equals(expected));
	}

	/**
	 * Testing the method clone()
	 */
	public final void testClone(){
		newsletter = new Newsletter("sender", "receiver", "object", "message");
		Newsletter expected = newsletter.clone();
		assertEquals(expected, newsletter);
	}
	
}
