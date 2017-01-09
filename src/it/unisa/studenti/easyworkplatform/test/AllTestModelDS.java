package it.unisa.studenti.easyworkplatform.test;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * 	AllTest
 *	Class that tests all the testClass
 *	@author AdminEWP
*/
public class AllTestModelDS{

	/**
	 * Test all the testClass
	 * @return suite 
	 */
	public static Test suite(){
		TestSuite suite = new TestSuite();

		// Test model
		suite.addTestSuite(TestAccountModelDS.class);
		suite.addTestSuite(TestActivityModelDS.class);
		suite.addTestSuite(TestArticleModelDS.class);
		suite.addTestSuite(TestCustomerModelDS.class);
		suite.addTestSuite(TestPaymentModelDS.class);
		suite.addTestSuite(TestServiceModelDS.class);
		
		return suite;
	}

}
