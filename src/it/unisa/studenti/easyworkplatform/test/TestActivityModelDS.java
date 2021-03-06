package it.unisa.studenti.easyworkplatform.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import it.unisa.studenti.easyworkplatform.model.Activity;
import it.unisa.studenti.easyworkplatform.model.ActivityModelDS;
import junit.framework.TestCase;

/**
 *	Class that tests important ActivityModelDS methods
 * 
 *	@author AdminEWP
*/
public class TestActivityModelDS extends TestCase {

	private ActivityModelDS modelDS;
	private Connection connection;
	private static final String TABLE_NAME = "activity";

	/**
	 * Sets up the fixture, initializing the activity model DS and connect to database 
	 * This method is called before a test is executed
	 */
	protected void setUp() throws Exception {
		modelDS = new ActivityModelDS();
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/dbtest", "root", "");
		connection.setAutoCommit(false);
	}

	/**
	 * Tears down the fixture, setting to null the activity model DS and close connection
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
		LinkedList<Activity> listActivity = modelDS.findAll();

		// database extrapolation
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + "");
		ResultSet rs = ps.executeQuery();
		int size = 0;
		while (rs.next()) {
			Activity expected = new Activity();
			expected.setId(rs.getInt("id"));
			expected.setName(rs.getString("name"));
			expected.setType(rs.getString("type"));
			expected.setAddress(rs.getString("address"));
			expected.setCity(rs.getString("city"));
			expected.setProvince(rs.getString("province"));
			expected.setCap(rs.getInt("cap"));
			expected.setVatNumber(rs.getString("vat_number"));
			expected.setUserId(rs.getInt("user_id"));
			assertEquals(true, listActivity.get(size).equals(expected));
			size++;
		}

		// compare database result with the method tested
		assertEquals(size, listActivity.size());
	}

	/**
	 * Testing the method insert()
	 * @throws SQLException - if database insert error occurs.
	 * @throws ClassNotFoundException - if jdbc Driver is not found
	 */
	public void testInsert() throws SQLException, ClassNotFoundException {
		// create an instance to be test
		Activity activity = new Activity("name", "type", "address", "city", "province", 0, "vatNumber", 5);
		modelDS.insert(activity); // method to test

		// database extrapolation
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE name = ?");
		ps.setString(1, "name");
		ResultSet rs = ps.executeQuery();
		Activity expected = null;
		while (rs.next()) {
			expected = new Activity();
			expected.setId(rs.getInt("id"));
			expected.setName(rs.getString("name"));
			expected.setType(rs.getString("type"));
			expected.setAddress(rs.getString("address"));
			expected.setCity(rs.getString("city"));
			expected.setProvince(rs.getString("province"));
			expected.setCap(rs.getInt("cap"));
			expected.setVatNumber(rs.getString("vat_number"));
			expected.setUserId(rs.getInt("user_id"));
		}

		// compare database result with the method tested
		assertNotNull(expected);
		assertNotNull(activity);
		assertEquals(expected, activity);

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
		Activity act = new Activity("name", "type", "address", "city", "province", 0, "vatNumber", 5);
		modelDS.insert(act);
		int id = -1;
		LinkedList<Activity> list = modelDS.findAll();
		for (Activity a : list) {
			if (a.equals(act))
				id = a.getId();
		}

		// method to test
		Activity activity = modelDS.findByKey(id);

		// database extrapolation
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Activity expected = null;
		while (rs.next()) {
			expected = new Activity();
			expected.setId(rs.getInt("id"));
			expected.setName(rs.getString("name"));
			expected.setType(rs.getString("type"));
			expected.setAddress(rs.getString("address"));
			expected.setCity(rs.getString("city"));
			expected.setProvince(rs.getString("province"));
			expected.setCap(rs.getInt("cap"));
			expected.setVatNumber(rs.getString("vat_number"));
			expected.setUserId(rs.getInt("user_id"));
		}

		// compare database result with the method tested
		assertNotNull(expected);
		assertNotNull(activity);
		assertEquals(expected, activity);

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
		Activity act = new Activity("name", "type", "address", "city", "province", 0, "vatNumber", 5);
		modelDS.insert(act);

		// method to test
		LinkedList<Activity> listActivity = modelDS.findByField("address", "address");

		// database extrapolation
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE address LIKE ?");
		ps.setString(1, "address"+"%");
		ResultSet rs = ps.executeQuery();
		Activity expected = null;
		int index = 0;
		while (rs.next()) {
			expected = new Activity();
			expected.setId(rs.getInt("id"));
			expected.setName(rs.getString("name"));
			expected.setType(rs.getString("type"));
			expected.setAddress(rs.getString("address"));
			expected.setCity(rs.getString("city"));
			expected.setProvince(rs.getString("province"));
			expected.setCap(rs.getInt("cap"));
			expected.setVatNumber(rs.getString("vat_number"));
			expected.setUserId(rs.getInt("user_id"));
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
		Activity act = new Activity("name", "type", "address", "city", "province", 0, "vatNumber", 5);
		modelDS.insert(act);
		int id = -1;
		LinkedList<Activity> list = modelDS.findAll();
		for (Activity a : list) {
			if (a.equals(act))
				id = a.getId();
		}

		Activity activity = modelDS.findByKey(id);
		activity.setName("newName");
		activity.setType("newType");
		modelDS.update(activity);

		// database extrapolation
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Activity expected = null;
		while (rs.next()) {
			expected = new Activity();
			expected.setId(rs.getInt("id"));
			expected.setName(rs.getString("name"));
			expected.setType(rs.getString("type"));
			expected.setAddress(rs.getString("address"));
			expected.setCity(rs.getString("city"));
			expected.setProvince(rs.getString("province"));
			expected.setCap(rs.getInt("cap"));
			expected.setVatNumber(rs.getString("vat_number"));
			expected.setUserId(rs.getInt("user_id"));
		}

		// compare database result with the method tested
		assertNotNull(expected);
		assertNotNull(activity);
		assertEquals(expected, activity);

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
		Activity act = new Activity("name", "type", "address", "city", "province", 0, "vatNumber", 5);
		modelDS.insert(act);
		int id = -1;
		LinkedList<Activity> list = modelDS.findAll();
		for (Activity a : list) {
			if (a.equals(act))
				id = a.getId();
		}
		
		Activity activity = modelDS.findByKey(id);
		modelDS.remove(activity.getId()); // method to test

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
