package it.unisa.studenti.easyworkplatform.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**	
 * Class that interacts with the database through the information of Payment
 *
 * @author AdminEWP
*/
public class PaymentModelDS implements ModelInterface<Payment> {

	private String table = "_payment";
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static DataSource ds;
	private String tableName;
	
	/**
	 * Empty constructor
	 */
	public PaymentModelDS() {
	}

	/**
	 * Parametric constructor with the name of the database
	 * @param nomeDb - Name of the database
	 * @param activity - Name of the activity
	 */
	public PaymentModelDS(String nomeDb, String activity) {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			ds = (DataSource) envCtx.lookup("jdbc/"+nomeDb);
			connection = ds.getConnection();
			this.tableName = activity.toLowerCase()+table;
		 } catch (NamingException | SQLException e) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost/"+nomeDb, "root", "");
				connection.setAutoCommit(false);
			} catch (SQLException | ClassNotFoundException ex) {
				e.printStackTrace();
			}
		 }
	}

	/**
	 * Insert a new instance of payment
	 * @param payment - Payment to insert
	 * @throws SQLException if a database insert error occurs.
	 */
	@Override
	public void insert(Payment payment) throws SQLException {
		String insertSql = "INSERT INTO " + tableName
				+ "(amount, date_payment, service_id, service_customer_id, service_article_id) VALUES (?,?,?,?,?)";
		try {
			//connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSql);
			preparedStatement.setDouble(1, payment.getAmount());
			preparedStatement.setDate(2, (Date) payment.getDate());
			preparedStatement.setInt(3, payment.getServiceId());
			preparedStatement.setInt(4, payment.getServiceCustomerId());
			preparedStatement.setInt(5, payment.getServiceArticleId());
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
		}
	}

	/**
	 * Update an existing payment
	 * @param payment - Payment to update
	 * @throws SQLException if a database update error occurs.
	 */
	@Override
	public void update(Payment payment) throws SQLException {
		String updateSql = "UPDATE " + tableName
				+ " SET amount=?, date_payment=?, service_id=?, service_customer_id=?,"
				+ " service_article_id=? WHERE (id = ?)";
		try {
			//connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setDouble(1, payment.getAmount());
			preparedStatement.setDate(2, (Date) payment.getDate());
			preparedStatement.setInt(3, payment.getServiceId());
			preparedStatement.setInt(4, payment.getServiceCustomerId());
			preparedStatement.setInt(5, payment.getServiceArticleId());
			preparedStatement.setInt(6, payment.getId());
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
		}
	}

	/**
	 * Remove a payment with a specific id
	 * @param id - Payment id to remove
	 * @throws SQLException if a database delete error occurs.
	 */
	@Override
	public void remove(int id) throws SQLException {
		String removeSql = "DELETE FROM " + tableName + " WHERE (id = ?)";
		try {
			//connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(removeSql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
		}
	}

	/**
	 * Find a payment by its id
	 * @param id - Payment id to find
	 * @return Payment found
	 * @throws SQLException if a database select error occurs. 
	 */
	@Override
	public Payment findByKey(int id) throws SQLException {
		String selectSql = "SELECT * FROM " + tableName + " WHERE (id = ?)";
		Payment payment = null;
		try {
			//connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				payment = new Payment();
				payment.setId(rs.getInt("id"));
				payment.setAmount(rs.getDouble("amount"));
				payment.setDate(rs.getDate("date_payment"));
				payment.setServiceId(rs.getInt("service_id"));
				payment.setServiceCustomerId(rs.getInt("service_customer_id"));
				payment.setServiceArticleId(rs.getInt("service_article_id"));
			}
			connection.commit();
		} catch (SQLException e) {
		}
		return payment;

	}

	/**
	 * Find a payment by a selected attribute and the parameter to search 
	 * @param attribute - Attribute of the payment
	 * @param toSearch - Parameters to search in the attribute field of the payment
	 * @return List of Payment
	 * @throws SQLException if a database select error occurs. 
	 */
	public LinkedList<Payment> findByField(String attribute, String toSearch) throws SQLException{
		LinkedList<Payment> listPayment = new LinkedList<Payment>();
		String selectSql = "SELECT * FROM " +tableName+" WHERE ("+attribute+" LIKE ?)";
		Payment payment = new Payment();
		try {
			//connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			preparedStatement.setString(1, toSearch+"%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				payment.setId(rs.getInt("id"));
				payment.setAmount(rs.getDouble("amount"));
				payment.setDate(rs.getDate("date_payment"));
				payment.setServiceId(rs.getInt("service_id"));
				payment.setServiceCustomerId(rs.getInt("service_customer_id"));
				payment.setServiceArticleId(rs.getInt("service_article_id"));
				listPayment.add(payment);
			}
		} catch (SQLException e) {
		}
		return listPayment;
	}
	
	/**
	 * Return a List of all the Payment
	 * @return List of Payment
	 * @throws SQLException - if a database select error occurs.
	 */
	@Override
	public LinkedList<Payment> findAll() throws SQLException {
		LinkedList<Payment> listPayment = new LinkedList<Payment>();
		String selectSql = "SELECT * FROM " + tableName+";";
		try {
			//connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Payment payment = new Payment();
				payment.setId(rs.getInt("id"));
				payment.setAmount(rs.getDouble("amount"));
				payment.setDate(rs.getDate("date_payment"));
				payment.setServiceId(rs.getInt("service_id"));
				payment.setServiceCustomerId(rs.getInt("service_customer_id"));
				payment.setServiceArticleId(rs.getInt("service_article_id"));
				listPayment.add(payment);
			}
		} catch (SQLException e) {
		}
		return listPayment;
	}

	/**
	 * Close connection to the database
	 * @throws SQLException - if a database error occurs.
	 */
	public void closeConnection() throws SQLException {
		try {
			if (preparedStatement != null)
				preparedStatement.close();
		} finally {
			if (connection != null)
				connection.close();
		}
	}

}
