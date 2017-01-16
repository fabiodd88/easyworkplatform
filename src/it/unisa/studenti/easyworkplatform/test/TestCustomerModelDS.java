package it.unisa.studenti.easyworkplatform.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import it.unisa.studenti.easyworkplatform.model.Customer;
import it.unisa.studenti.easyworkplatform.model.CustomerModelDS;
import junit.framework.TestCase;

/**
 *	Class that tests important CustomerModelDS methods
 * 
 *	@author AdminEWP
*/
public class TestCustomerModelDS extends TestCase {

	private CustomerModelDS modelDS;
	private Connection connection;
	private static final String TABLE_NAME = "pizzeria_customer";

	/**
	 * Sets up the fixture, initializing the customer model DS and connect to database 
	 * This method is called before a test is executed
	 */	
	protected void setUp() throws Exception {
		modelDS = new CustomerModelDS("dbtest","pizzeria_customer");
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/dbtest", "root", "");
		connection.setAutoCommit(false);
	}

	/**
	 * Tears down the fixture, setting to null the customer model DS and close connection
	 * This method is called after a test is executed.
	 */
	protected void tearDown() throws Exception {
		modelDS = null;
		if (null != connection) {
			connection.close();
			connection = null;
		}
	}

	/**
	 * Testing the method findAll()
	 * @throws SQLException - if database select error occurs.
	 * @throws ClassNotFoundException - if jdbc Driver is not found
	 */
	public void testFindAll() throws SQLException, ClassNotFoundException {
		// method to test
		LinkedList<Customer> listCustomer = modelDS.findAll();

		// database extrapolation
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + "");
		ResultSet rs = ps.executeQuery();
		int size = 0;
		while (rs.next()) {
			Customer expected = new Customer();
			expected.setId(rs.getInt("id"));
			expected.setName(rs.getString("name"));
			expected.setSurname(rs.getString("surname"));
			expected.setBirthdate(rs.getDate("birth_date"));
			expected.setBirthplace(rs.getString("birth_place"));
			expected.setAddress(rs.getString("address"));
			expected.setCity(rs.getString("city"));
			expected.setProvince(rs.getString("province"));
			expected.setCap(rs.getInt("cap"));
			expected.setPhoneNumber(rs.getString("phone_number"));
			expected.setNewsletter(rs.getInt("newsletter"));
			expected.setEmail(rs.getString("email"));
			assertEquals(true, listCustomer.get(size).equals(expected));
			size++;
		}

		// compare database result with the method tested
		assertEquals(size, listCustomer.size());
	}

	/**
	 * Testing the method insert()
	 * @throws SQLException - if database insert error occurs.
	 * @throws ClassNotFoundException - if jdbc Driver is not found
	 */
	public void testInsert() throws SQLException, ClassNotFoundException {
		// create an instance to be test
		Date d = Date.valueOf("2017-01-01");
		Customer customer = new Customer("name", "surname", d, "birtplace", "address", "city", "province", 0, 0, "phoneNumber", "email");
		modelDS.insert(customer); // method to test

		// database extrapolation
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE name = ?");
		ps.setString(1, "name");
		ResultSet rs = ps.executeQuery();
		Customer expected = null;
		while (rs.next()) {
			expected = new Customer();
			expected.setId(rs.getInt("id"));
			expected.setName(rs.getString("name"));
			expected.setSurname(rs.getString("surname"));
			expected.setBirthdate(rs.getDate("birth_date"));
			expected.setBirthplace(rs.getString("birth_place"));
			expected.setAddress(rs.getString("address"));
			expected.setCity(rs.getString("city"));
			expected.setProvince(rs.getString("province"));
			expected.setCap(rs.getInt("cap"));
			expected.setPhoneNumber(rs.getString("phone_number"));
			expected.setNewsletter(rs.getInt("newsletter"));
			expected.setEmail(rs.getString("email"));
		}

		// compare database result with the method tested
		assertNotNull(expected);
		assertNotNull(customer);
		assertEquals(expected, customer);

		modelDS.remove(expected.getId()); // return to the initial state of the
											// database before test
	}

	/**
	 * Testing the method findByKey()
	 * @throws SQLException - if database select error occurs.
	 * @throws ClassNotFoundException - if jdbc Driver is not found
	 */
	public void testFindByKey() throws SQLException, ClassNotFoundException {
		// create an instance to be test
		Date d = Date.valueOf("2017-01-01");
		Customer cus = new Customer("name", "surname", d, "birtplace", "address", "city", "province", 0, 0, "phoneNumber", "email");
		modelDS.insert(cus); 
		int id = -1;
		LinkedList<Customer> list = modelDS.findAll();
		for (Customer a : list) {
			if (a.equals(cus))
				id = a.getId();
		}

		// method to test
		Customer customer = modelDS.findByKey(id);

		// database extrapolation
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Customer expected = null;
		while (rs.next()) {
			expected = new Customer();
			expected.setId(rs.getInt("id"));
			expected.setName(rs.getString("name"));
			expected.setSurname(rs.getString("surname"));
			expected.setBirthdate(rs.getDate("birth_date"));
			expected.setBirthplace(rs.getString("birth_place"));
			expected.setAddress(rs.getString("address"));
			expected.setCity(rs.getString("city"));
			expected.setProvince(rs.getString("province"));
			expected.setCap(rs.getInt("cap"));
			expected.setPhoneNumber(rs.getString("phone_number"));
			expected.setNewsletter(rs.getInt("newsletter"));
			expected.setEmail(rs.getString("email"));
		}

		// compare database result with the method tested
		assertNotNull(expected);
		assertNotNull(customer);
		assertEquals(expected, customer);

		modelDS.remove(expected.getId()); // return to the initial state of the
											// database before test
	}

	/**
	 * Testing the method findByField()
	 * @throws SQLException - if database update error occurs.
	 * @throws ClassNotFoundException - if jdbc Driver is not found
	 */
	public void testFindByField() throws SQLException, ClassNotFoundException {
		// create an instance to be test
		Date d = Date.valueOf("2017-01-01");
		Customer cus = new Customer("name", "surname", d, "birtplace", "address", "city", "province", 0, 0, "phoneNumber", "email");
		modelDS.insert(cus); 

		// method to test
		LinkedList<Customer> listActivity = modelDS.findByField("birth_place", "birtplace");

		// database extrapolation
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE birth_place LIKE ?");
		ps.setString(1, "birtplace"+"%");
		ResultSet rs = ps.executeQuery();
		Customer expected = null;
		int index = 0;
		while (rs.next()) {
			expected = new Customer();
			expected.setId(rs.getInt("id"));
			expected.setName(rs.getString("name"));
			expected.setSurname(rs.getString("surname"));
			expected.setBirthdate(rs.getDate("birth_date"));
			expected.setBirthplace(rs.getString("birth_place"));
			expected.setAddress(rs.getString("address"));
			expected.setCity(rs.getString("city"));
			expected.setProvince(rs.getString("province"));
			expected.setCap(rs.getInt("cap"));
			expected.setPhoneNumber(rs.getString("phone_number"));
			expected.setNewsletter(rs.getInt("newsletter"));
			expected.setEmail(rs.getString("email"));
			assertEquals(true, listActivity.get(index).equals(expected));
			index++;
		}

		modelDS.remove(expected.getId()); // return to the initial state of the
											// database before test
	}

	/**
	 * Testing the method update()
	 * @throws SQLException - if database update error occurs.
	 * @throws ClassNotFoundException - if jdbc Driver is not found
	 */
	public void testUpdate() throws SQLException, ClassNotFoundException {
		// create an instance to be test
		Date d = Date.valueOf("2017-01-01");
		Customer cus = new Customer("name", "surname", d, "birtplace", "address", "city", "province", 0, 0, "phoneNumber", "email");
		modelDS.insert(cus); 
		int id = -1;
		LinkedList<Customer> list = modelDS.findAll();
		for (Customer a : list) {
			if (a.equals(cus))
				id = a.getId();
		}

		Customer customer = modelDS.findByKey(id);
		customer.setName("newName");
		customer.setAddress("newAddress");
		customer.setPhoneNumber("newPhoneNumber");
		modelDS.update(customer);	//method to test

		// database extrapolation
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Customer expected = null;
		while (rs.next()) {
			expected = new Customer();
			expected.setId(rs.getInt("id"));
			expected.setName(rs.getString("name"));
			expected.setSurname(rs.getString("surname"));
			expected.setBirthdate(rs.getDate("birth_date"));
			expected.setBirthplace(rs.getString("birth_place"));
			expected.setAddress(rs.getString("address"));
			expected.setCity(rs.getString("city"));
			expected.setProvince(rs.getString("province"));
			expected.setCap(rs.getInt("cap"));
			expected.setPhoneNumber(rs.getString("phone_number"));
			expected.setNewsletter(rs.getInt("newsletter"));
			expected.setEmail(rs.getString("email"));
		}

		// compare database result with the method tested
		assertNotNull(expected);
		assertNotNull(customer);
		assertEquals(expected, customer);

		modelDS.remove(expected.getId()); // return to the initial state of the
											// database before test
	}

	/**
	 * Testing the method remove()
	 * @throws SQLException - if database delete error occurs.
	 * @throws ClassNotFoundException - if jdbc Driver is not found
	 */
	public void testRemove() throws SQLException, ClassNotFoundException {
		// create an instance to be test
		Date d = Date.valueOf("2017-01-01");
		Customer cus = new Customer("name", "surname", d, "birtplace", "address", "city", "province", 0, 0, "phoneNumber", "email");
		modelDS.insert(cus); 
		int id = -1;
		LinkedList<Customer> list = modelDS.findAll();
		for (Customer a : list) {
			if (a.equals(cus))
				id = a.getId();
		}
		
		Customer customer = modelDS.findByKey(id);
		modelDS.remove(customer.getId()); // method to test

		// database extrapolation
		PreparedStatement ps = connection.prepareStatement("SELECT count(*) FROM " + TABLE_NAME + " WHERE id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		int expected = 0;
		if (rs.next())
			expected = rs.getInt(1);
		assertEquals(expected, 0);
	}

}
