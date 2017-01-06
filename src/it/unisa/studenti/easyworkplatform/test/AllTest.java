package it.unisa.studenti.easyworkplatform.test;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * 	AllTest
 *	Class that tests all the testClass
 *	@author AdminEWP
*/
public class AllTest{

	/**
	 * Test all the testClass
	 * @return suite 
	 */
	public static Test suite(){
		TestSuite suite = new TestSuite();
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
