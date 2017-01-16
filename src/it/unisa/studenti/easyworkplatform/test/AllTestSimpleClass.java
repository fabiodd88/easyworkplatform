package it.unisa.studenti.easyworkplatform.test;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Class that tests all the test SimpleClass
 *
 * @author AdminEWP
*/
public class AllTestSimpleClass{

	/**
	 * Manually built a suite containing all the testSimpleClass to run them all in one time
	 * @return suite - suite containing all the testSimpleClass
	 */
	public static Test suite(){
		TestSuite suite = new TestSuite();
		
		// Test SimpleClass
		suite.addTestSuite(TestAccount.class);
		suite.addTestSuite(TestActivity.class);
		suite.addTestSuite(TestArticle.class);
		suite.addTestSuite(TestCustomer.class);
		suite.addTestSuite(TestNewsletter.class);
		suite.addTestSuite(TestPayment.class);
		suite.addTestSuite(TestService.class);
		suite.addTestSuite(TestUser.class);
		
		return suite;
	}

}
