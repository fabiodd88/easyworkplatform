package it.unisa.studenti.easyworkplatform.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import it.unisa.studenti.easyworkplatform.model.Service;
import it.unisa.studenti.easyworkplatform.model.ServiceModelDS;
import junit.framework.TestCase;

public class TestServiceModelDS extends TestCase {

	private ServiceModelDS modelDS;
	private Connection connection;
	private static final String TABLE_NAME = "pizzeria_service";

	protected void setUp() throws Exception {
		modelDS = new ServiceModelDS("dbtest");
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/dbtest", "root", "");
		connection.setAutoCommit(false);
	}

	protected void tearDown() throws Exception {
		modelDS = null;
		if (null != connection) {
			connection.close();
			connection = null;
		}
	}

	public void testFindAll() throws SQLException, ClassNotFoundException {
		// method to test
		LinkedList<Service> listService = modelDS.findAll();

		// database extrapolation
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + "");
		ResultSet rs = ps.executeQuery();
		int size = 0;
		while (rs.next()) {
			Service expected = new Service();
			expected.setId(rs.getInt("id"));
			expected.setName(rs.getString("name"));
			expected.setEmployee(rs.getString("employee"));
			expected.setQuantity(rs.getInt("quantity"));
			expected.setVariation(rs.getString("variation"));
			expected.setNote(rs.getString("note"));
			expected.setReceiptDate(rs.getDate("receipt_date"));
			expected.setReturnDate(rs.getDate("return_date"));
			expected.setArticleId(rs.getInt("article_id"));
			expected.setCustomerId(rs.getInt("customer_id"));
			assertEquals(true, listService.get(size).equals(expected));
			size++;
		}

		// compare database result with the method tested
		assertEquals(size, listService.size());
	}

	public void testInsert() throws SQLException, ClassNotFoundException {
		// create an instance to be test
		Date d = Date.valueOf("2017-01-01");
		Service service = new Service("name", "employee", 1, "variation", "note", d, d, 1, 1);
		modelDS.insert(service); // method to test

		// database extrapolation
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE name = ?");
		ps.setString(1, "name");
		ResultSet rs = ps.executeQuery();
		Service expected = null;
		while (rs.next()) {
			expected = new Service();
			expected.setId(rs.getInt("id"));
			expected.setName(rs.getString("name"));
			expected.setEmployee(rs.getString("employee"));
			expected.setQuantity(rs.getInt("quantity"));
			expected.setVariation(rs.getString("variation"));
			expected.setNote(rs.getString("note"));
			expected.setReceiptDate(rs.getDate("receipt_date"));
			expected.setReturnDate(rs.getDate("return_date"));
			expected.setArticleId(rs.getInt("article_id"));
			expected.setCustomerId(rs.getInt("customer_id"));
		}

		// compare database result with the method tested
		assertNotNull(expected);
		assertNotNull(service);
		assertEquals(expected, service);

		modelDS.remove(expected.getId()); // return to the initial state of the
											// database before test
	}

	public void testFindByKey() throws SQLException, ClassNotFoundException {
		// create an instance to be test
		Date d = Date.valueOf("2017-01-01");
		Service ser = new Service("name", "employee", 1, "variation", "note", d, d, 1, 1);
		modelDS.insert(ser); 
		int id = -1;
		LinkedList<Service> list = modelDS.findAll();
		for (Service a : list) {
			if (a.equals(ser))
				id = a.getId();
		}

		// method to test
		Service service = modelDS.findByKey(id);

		// database extrapolation
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Service expected = null;
		while (rs.next()) {
			expected = new Service();
			expected.setId(rs.getInt("id"));
			expected.setName(rs.getString("name"));
			expected.setEmployee(rs.getString("employee"));
			expected.setQuantity(rs.getInt("quantity"));
			expected.setVariation(rs.getString("variation"));
			expected.setNote(rs.getString("note"));
			expected.setReceiptDate(rs.getDate("receipt_date"));
			expected.setReturnDate(rs.getDate("return_date"));
			expected.setArticleId(rs.getInt("article_id"));
			expected.setCustomerId(rs.getInt("customer_id"));
		}

		// compare database result with the method tested
		assertNotNull(expected);
		assertNotNull(service);
		assertEquals(expected, service);

		modelDS.remove(expected.getId()); // return to the initial state of the
											// database before test
	}

	public void testFindByField() throws SQLException, ClassNotFoundException {
		// create an instance to be test
		Date d = Date.valueOf("2017-01-01");
		Service ser = new Service("name", "employee", 1, "variation", "note", d, d, 1, 1);
		modelDS.insert(ser); 

		// method to test
		LinkedList<Service> listActivity = modelDS.findByField("employee", "employee");

		// database extrapolation
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE employee LIKE ?");
		ps.setString(1, "employee"+"%");
		ResultSet rs = ps.executeQuery();
		Service expected = null;
		int index = 0;
		while (rs.next()) {
			expected = new Service();
			expected.setId(rs.getInt("id"));
			expected.setName(rs.getString("name"));
			expected.setEmployee(rs.getString("employee"));
			expected.setQuantity(rs.getInt("quantity"));
			expected.setVariation(rs.getString("variation"));
			expected.setNote(rs.getString("note"));
			expected.setReceiptDate(rs.getDate("receipt_date"));
			expected.setReturnDate(rs.getDate("return_date"));
			expected.setArticleId(rs.getInt("article_id"));
			expected.setCustomerId(rs.getInt("customer_id"));
			assertEquals(true, listActivity.get(index).equals(expected));
			index++;
		}

		modelDS.remove(expected.getId()); // return to the initial state of the
											// database before test
	}

	public void testUpdate() throws SQLException, ClassNotFoundException {
		// create an instance to be test
		Date d = Date.valueOf("2017-01-01");
		Service ser = new Service("name", "employee", 1, "variation", "note", d, d, 1, 1);
		modelDS.insert(ser); 
		int id = -1;
		LinkedList<Service> list = modelDS.findAll();
		for (Service a : list) {
			if (a.equals(ser))
				id = a.getId();
		}

		Service service = modelDS.findByKey(id);
		service.setName("newName");
		service.setEmployee("newEmployee");
		modelDS.update(service);

		// database extrapolation
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Service expected = null;
		while (rs.next()) {
			expected = new Service();
			expected.setId(rs.getInt("id"));
			expected.setName(rs.getString("name"));
			expected.setEmployee(rs.getString("employee"));
			expected.setQuantity(rs.getInt("quantity"));
			expected.setVariation(rs.getString("variation"));
			expected.setNote(rs.getString("note"));
			expected.setReceiptDate(rs.getDate("receipt_date"));
			expected.setReturnDate(rs.getDate("return_date"));
			expected.setArticleId(rs.getInt("article_id"));
			expected.setCustomerId(rs.getInt("customer_id"));
		}

		// compare database result with the method tested
		assertNotNull(expected);
		assertNotNull(service);
		assertEquals(expected, service);

		modelDS.remove(expected.getId()); // return to the initial state of the
											// database before test
	}

	public void testRemove() throws SQLException, ClassNotFoundException {
		// create an instance to be test
		Date d = Date.valueOf("2017-01-01");
		Service ser = new Service("name", "employee", 1, "variation", "note", d, d, 1, 1);
		modelDS.insert(ser); 
		int id = -1;
		LinkedList<Service> list = modelDS.findAll();
		for (Service a : list) {
			if (a.equals(ser))
				id = a.getId();
		}
		
		Service service = modelDS.findByKey(id);
		modelDS.remove(service.getId()); // method to test

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
