package it.unisa.studenti.easyworkplatform.test;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Class that tests all the test Class
 * 
 * @author AdminEWP
*/
public class AllTest{

	/**
	 * Manually built a suite containing all the TestClass to run them all in one time
	 * @return suite - suite containing all the TestClass
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
		
		// Test ModelDS
		suite.addTestSuite(TestAccountModelDS.class);
		suite.addTestSuite(TestActivityModelDS.class);
		suite.addTestSuite(TestArticleModelDS.class);
		suite.addTestSuite(TestCustomerModelDS.class);
		suite.addTestSuite(TestPaymentModelDS.class);
		suite.addTestSuite(TestServiceModelDS.class);
		
		return suite;
	}

}
