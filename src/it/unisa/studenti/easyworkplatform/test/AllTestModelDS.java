package it.unisa.studenti.easyworkplatform.test;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Class that tests all the test ModelDS
 *
 * @author AdminEWP
*/
public class AllTestModelDS{

	/**
	 * Manually built a suite containing all the testModelDS to run them all in one time
	 * @return suite - suite containing all the testModelDS
	 */
	public static Test suite(){
		TestSuite suite = new TestSuite();

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
