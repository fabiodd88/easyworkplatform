package it.unisa.studenti.easyworkplatform.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import it.unisa.studenti.easyworkplatform.model.Payment;
import it.unisa.studenti.easyworkplatform.model.PaymentModelDS;
import junit.framework.TestCase;

public class TestPaymentModelDS extends TestCase {

	private PaymentModelDS modelDS;
	private Connection connection;
	private static final String TABLE_NAME = "pizzeria_payment";

	protected void setUp() throws Exception {
		modelDS = new PaymentModelDS("dbtest");
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
		LinkedList<Payment> listPayment = modelDS.findAll();

		// database extrapolation
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + "");
		ResultSet rs = ps.executeQuery();
		int size = 0;
		while (rs.next()) {
			Payment expected = new Payment();
			expected.setAmount(rs.getDouble("amount"));
			expected.setDate(rs.getDate("date_payment"));
			expected.setServiceId(rs.getInt("service_id"));
			expected.setServiceCustomerId(rs.getInt("service_customer_id"));
			expected.setServiceArticleId(rs.getInt("service_article_id"));
			assertEquals(true, listPayment.get(size).equals(expected));
			size++;
		}

		// compare database result with the method tested
		assertEquals(size, listPayment.size());
	}

	public void testInsert() throws SQLException, ClassNotFoundException {
		// create an instance to be test
		Date d = Date.valueOf("2017-01-01");
		Payment payment = new Payment(0.0, d,1,1,1);
		modelDS.insert(payment); // method to test
		
		int id = -1;
		LinkedList<Payment> list = modelDS.findAll();
		for (Payment a : list) {
			if (a.equals(payment))
				id = a.getId();
		}

		// database extrapolation
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Payment expected = null;
		while (rs.next()) {
			expected = new Payment();
			expected.setId(rs.getInt("id"));
			expected.setAmount(rs.getDouble("amount"));
			expected.setDate(rs.getDate("date_payment"));
			expected.setServiceId(rs.getInt("service_id"));
			expected.setServiceCustomerId(rs.getInt("service_customer_id"));
			expected.setServiceArticleId(rs.getInt("service_article_id"));
		}

		// compare database result with the method tested
		assertNotNull(expected);
		assertNotNull(payment);
		assertEquals(expected, payment);

		modelDS.remove(expected.getId()); // return to the initial state of the
											// database before test
	}

	public void testFindByKey() throws SQLException, ClassNotFoundException {
		// create an instance to be test
		Date d = Date.valueOf("2017-01-01");
		Payment pay = new Payment(0.0, d,1,1,1);
		modelDS.insert(pay); 
		int id = -1;
		LinkedList<Payment> list = modelDS.findAll();
		for (Payment a : list) {
			if (a.equals(pay))
				id = a.getId();
		}

		// method to test
		Payment payment = modelDS.findByKey(id);

		// database extrapolation
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Payment expected = null;
		while (rs.next()) {
			expected = new Payment();
			expected.setId(rs.getInt("id"));
			expected.setAmount(rs.getDouble("amount"));
			expected.setDate(rs.getDate("date_payment"));
			expected.setServiceId(rs.getInt("service_id"));
			expected.setServiceCustomerId(rs.getInt("service_customer_id"));
			expected.setServiceArticleId(rs.getInt("service_article_id"));
		}

		// compare database result with the method tested
		assertNotNull(expected);
		assertNotNull(payment);
		assertEquals(expected, payment);

		modelDS.remove(expected.getId()); // return to the initial state of the
											// database before test
	}

	public void testFindByField() throws SQLException, ClassNotFoundException {
		// create an instance to be test
		Date d = Date.valueOf("2017-01-01");
		Payment pay = new Payment(0.0, d,1,1,1);
		modelDS.insert(pay); 

		// method to test
		LinkedList<Payment> listPayment = modelDS.findByField("date_payment", "2017-01-01");

		// database extrapolation
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE date_payment LIKE ?");
		ps.setString(1, "2017_01_01"+"%");
		ResultSet rs = ps.executeQuery();
		Payment expected = null;
		int index = 0;
		while (rs.next()) {
			expected = new Payment();
			expected.setId(rs.getInt("id"));
			expected.setAmount(rs.getDouble("amount"));
			expected.setDate(rs.getDate("date_payment"));
			expected.setServiceId(rs.getInt("service_id"));
			expected.setServiceCustomerId(rs.getInt("service_customer_id"));
			expected.setServiceArticleId(rs.getInt("service_article_id"));
			assertEquals(true, listPayment.get(index).equals(expected));
			index++;
		}

		modelDS.remove(expected.getId()); // return to the initial state of the
											// database before test
	}

	public void testUpdate() throws SQLException, ClassNotFoundException {
		// create an instance to be test
		Date d = Date.valueOf("2017-01-01");
		Payment pay = new Payment(0.0, d,1,1,1);
		modelDS.insert(pay); 
		int id = -1;
		LinkedList<Payment> list = modelDS.findAll();
		for (Payment a : list) {
			if (a.equals(pay))
				id = a.getId();
		}

		Payment payment = modelDS.findByKey(id);
		payment.setDate(Date.valueOf("2017-02-02"));
		payment.setAmount(11.11);
		modelDS.update(payment);

		// database extrapolation
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Payment expected = null;
		while (rs.next()) {
			expected = new Payment();
			expected.setId(rs.getInt("id"));
			expected.setAmount(rs.getDouble("amount"));
			expected.setDate(rs.getDate("date_payment"));
			expected.setServiceId(rs.getInt("service_id"));
			expected.setServiceCustomerId(rs.getInt("service_customer_id"));
			expected.setServiceArticleId(rs.getInt("service_article_id"));
		}

		// compare database result with the method tested
		assertNotNull(expected);
		assertNotNull(payment);
		assertEquals(expected, payment);

		modelDS.remove(expected.getId()); // return to the initial state of the
											// database before test
	}

	public void testRemove() throws SQLException, ClassNotFoundException {
		// create an instance to be test
		Date d = Date.valueOf("2017-01-01");
		Payment pay = new Payment(0.0, d,1,1,1);
		modelDS.insert(pay); 
		int id = -1;
		LinkedList<Payment> list = modelDS.findAll();
		for (Payment a : list) {
			if (a.equals(pay))
				id = a.getId();
		}
		
		Payment article = modelDS.findByKey(id);
		modelDS.remove(article.getId()); // method to test

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
