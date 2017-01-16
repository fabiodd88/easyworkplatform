package it.unisa.studenti.easyworkplatform.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import it.unisa.studenti.easyworkplatform.model.Account;
import it.unisa.studenti.easyworkplatform.model.AccountModelDS;
import it.unisa.studenti.easyworkplatform.model.User;
import junit.framework.TestCase;

/**
 *	Class that tests important AccountModelDS methods
 * 
 *	@author AdminEWP
*/
public class TestAccountModelDS extends TestCase {

	private AccountModelDS modelDS;
	private Connection connection;
	private static final String TABLE_NAME = "user";

	/**
	 * Sets up the fixture, initializing the account model DS and connect to database 
	 * This method is called before a test is executed
	 */
	protected void setUp() throws Exception {
		modelDS = new AccountModelDS();
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/dbtest", "root", "");
		connection.setAutoCommit(false);
	}

	/**
	 * Tears down the fixture, setting to null the account model DS and close connection
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
		LinkedList<User> listUser = modelDS.findAll();

		// database extrapolation
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + "");
		ResultSet rs = ps.executeQuery();
		int size = 0;
		while (rs.next()) {
			User expected = new User();
			expected.setName(rs.getString("name"));
			expected.setSurname(rs.getString("surname"));
			expected.setBirthdate(rs.getDate("birth_date"));
			expected.setBirthplace(rs.getString("birth_place"));
			expected.setAddress(rs.getString("address"));
			expected.setCity(rs.getString("city"));
			expected.setProvince(rs.getString("province"));
			expected.setCap(rs.getInt("cap"));
			expected.setTaxCode(rs.getString("tax_code"));
			expected.setEmail(rs.getString("email"));
			expected.setPassword(rs.getString("password"));
			expected.setSecondKey(rs.getString("secondary_key"));
			assertEquals(true, listUser.get(size).equals(expected));
			size++;
		}

		// compare database result with the method tested
		assertEquals(size, listUser.size());
	}

	/**
	 * Testing the method insert()
	 * @throws SQLException - if database insert error occurs.
	 * @throws ClassNotFoundException - if jdbc Driver is not found
	 */
	public void testInsert() throws SQLException, ClassNotFoundException {
		Account account = new Account("email", "password", "secondKey");
		Date date = Date.valueOf("2017-12-12");
		User user = new User(account, "name", "surname", date, "birthplace", "address", "city", "province", 0,
				"taxCode");
		modelDS.insert(user); // method to test

		// database extrapolation
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE email = ?");
		ps.setString(1, "email");
		ResultSet rs = ps.executeQuery();
		User expected = null;
		while (rs.next()) {
			expected = new User();
			expected.setId(rs.getInt("id"));
			expected.setName(rs.getString("name"));
			expected.setSurname(rs.getString("surname"));
			expected.setBirthdate(rs.getDate("birth_date"));
			expected.setBirthplace(rs.getString("birth_place"));
			expected.setAddress(rs.getString("address"));
			expected.setCity(rs.getString("city"));
			expected.setProvince(rs.getString("province"));
			expected.setCap(rs.getInt("cap"));
			expected.setTaxCode(rs.getString("tax_code"));
			expected.setEmail(rs.getString("email"));
			expected.setPassword(rs.getString("password"));
			expected.setSecondKey(rs.getString("secondary_key"));
		}

		// compare database result with the method tested
		assertNotNull(expected);
		assertNotNull(user);
		assertEquals(expected, user);

		modelDS.remove(expected.getId()); // return to the initial state of the
											// database before test
	}

	/**
	 * Testing the method findByEmail()
	 * @throws SQLException - if database select error occurs.
	 * @throws ClassNotFoundException - if jdbc Driver is not found
	 */
	public void testFindByEmail() throws SQLException, ClassNotFoundException {
		Account account = new Account("email", "password", "secondKey");
		Date date = Date.valueOf("2017-12-12");
		User us = new User(account, "name", "surname", date, "birthplace", "address", "city", "province", 0, "taxCode");
		modelDS.insert(us);

		User user = modelDS.findByEmail("email"); // method to test

		// database extrapolation
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE email = ?");
		ps.setString(1, "email");
		ResultSet rs = ps.executeQuery();
		User expected = null;
		while (rs.next()) {
			expected = new User();
			expected.setId(rs.getInt("id"));
			expected.setName(rs.getString("name"));
			expected.setSurname(rs.getString("surname"));
			expected.setBirthdate(rs.getDate("birth_date"));
			expected.setBirthplace(rs.getString("birth_place"));
			expected.setAddress(rs.getString("address"));
			expected.setCity(rs.getString("city"));
			expected.setProvince(rs.getString("province"));
			expected.setCap(rs.getInt("cap"));
			expected.setTaxCode(rs.getString("tax_code"));
			expected.setEmail(rs.getString("email"));
			expected.setPassword(rs.getString("password"));
			expected.setSecondKey(rs.getString("secondary_key"));
		}

		// compare database result with the method tested
		assertNotNull(expected);
		assertNotNull(user);
		assertEquals(expected, user);

		modelDS.remove(expected.getId()); // return to the initial state of the
											// database before test
	}

	/**
	 * Testing the method findByKey()
	 * @throws SQLException - if database select error occurs.
	 * @throws ClassNotFoundException - if jdbc Driver is not found
	 */
	public void testFindByKey() throws SQLException, ClassNotFoundException {

		User user = modelDS.findByKey(5);

		// database extrapolation
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE id = ?");
		ps.setInt(1, 5);
		ResultSet rs = ps.executeQuery();
		User expected = null;
		while (rs.next()) {
			expected = new User();
			expected.setName(rs.getString("name"));
			expected.setSurname(rs.getString("surname"));
			expected.setBirthdate(rs.getDate("birth_date"));
			expected.setBirthplace(rs.getString("birth_place"));
			expected.setAddress(rs.getString("address"));
			expected.setCity(rs.getString("city"));
			expected.setProvince(rs.getString("province"));
			expected.setCap(rs.getInt("cap"));
			expected.setTaxCode(rs.getString("tax_code"));
			expected.setEmail(rs.getString("email"));
			expected.setPassword(rs.getString("password"));
			expected.setSecondKey(rs.getString("secondary_key"));
		}

		// compare database result with the method tested
		assertNotNull(expected);
		assertNotNull(user);
		assertEquals(expected, user);
	}

	/**
	 * Testing the method update()
	 * @throws SQLException - if database update error occurs.
	 * @throws ClassNotFoundException - if jdbc Driver is not found
	 */
	public void testUpdate() throws SQLException, ClassNotFoundException {
		// create an instance to be test
		Account account = new Account("email", "password", "secondKey");
		Date date = Date.valueOf("2017-12-12");
		User us = new User(account, "name", "surname", date, "birthplace", "address", "city", "province", 0, "taxCode");
		modelDS.insert(us);

		User user = modelDS.findByEmail("email");
		user.setName("newName");
		user.setSurname("newSurname");
		user.setTaxCode("newTaxCode");
		modelDS.update(user); // method to test

		// database extrapolation
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE email = ?");
		ps.setString(1, "email");
		ResultSet rs = ps.executeQuery();
		User expected = null;
		while (rs.next()) {
			expected = new User();
			expected.setId(rs.getInt("id"));
			expected.setName(rs.getString("name"));
			expected.setSurname(rs.getString("surname"));
			expected.setBirthdate(rs.getDate("birth_date"));
			expected.setBirthplace(rs.getString("birth_place"));
			expected.setAddress(rs.getString("address"));
			expected.setCity(rs.getString("city"));
			expected.setProvince(rs.getString("province"));
			expected.setCap(rs.getInt("cap"));
			expected.setTaxCode(rs.getString("tax_code"));
			expected.setEmail(rs.getString("email"));
			expected.setPassword(rs.getString("password"));
			expected.setSecondKey(rs.getString("secondary_key"));
		}

		// compare database result with the method tested
		assertNotNull(expected);
		assertNotNull(user);
		assertEquals(expected, user);

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
		Account account = new Account("email", "password", "secondKey");
		Date date = Date.valueOf("2017-12-12");
		User us = new User(account, "name", "surname", date, "birthplace", "address", "city", "province", 0, "taxCode");
		modelDS.insert(us);
		
		User user = modelDS.findByEmail("email");
		modelDS.remove(user.getId()); // method to test

		// database extrapolation
		PreparedStatement ps = connection.prepareStatement("SELECT count(*) FROM " + TABLE_NAME + " WHERE email = ?");
		ps.setString(1, "email");
		ResultSet rs = ps.executeQuery();
		int expected = 0;
		if (rs.next())
			expected = rs.getInt(1);
		assertEquals(expected, 0);

	}

}
