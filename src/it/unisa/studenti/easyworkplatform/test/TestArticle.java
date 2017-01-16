package it.unisa.studenti.easyworkplatform.test;

import it.unisa.studenti.easyworkplatform.model.Article;
import junit.framework.TestCase;

/**
 *	Class that tests important Article methods 
 *
 *	@author AdminEWP
*/
public class TestArticle extends TestCase {

	private Article article;

	/**
	 * Sets up the fixture, initializing the article 
	 * This method is called before a test is executed
	 */
	protected void setUp() throws Exception {
		article = new Article();
	}

	/**
	 * Tears down the fixture, setting to null the article
	 * This method is called after a test is executed.
	 */
	protected void tearDown() throws Exception {
		article = null;
	}

	/**
	 * Testing the method toString()
	 */
	public final void testToString() {
		// case 1
		article = new Article();
		String expected = "Article [name=null, price=0.0, description=null, duration=0]";
		assertEquals(expected, article.toString());
		
		// case 2
		article = new Article("name", 0.0, "description", 0);
		expected = "Article [name=name, price=0.0, description=description, duration=0]";
		assertEquals(expected, article.toString());
		
		// case 3
		article = new Article("name",1.1,"",1);
		expected = "Article [name=name, price=0.0, description=description, duration=0]";
		assertNotSame(expected, article.toString());
		
	}

	/**
	 * Testing the method equals()
	 */	
	public final void testEquals(){
		// case 1
		article = new Article("name", 0.0, "description", 0);
		Article	expected = new Article("name", 0.0, "description", 0);
		assertEquals(true,article.equals(expected));
		
		// case 3
		article = new Article("name",1.1,"",1);
		expected = new Article("name", 0.0, "description", 0);
		assertNotSame(expected, article.toString());
		
	}

	/**
	 * Testing the method clone()
	 */
	public final void testClone(){
		// case 1
		article = new Article("name", 0.0, "description", 0);
		Article expected = article.clone();
		assertEquals(expected, article);
	}
}
