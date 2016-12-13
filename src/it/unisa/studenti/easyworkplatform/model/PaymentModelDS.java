package it.unisa.studenti.easyworkplatform.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class PaymentModelDS implements ModelInterface<Payment> {

	// private static DataSource ds;
	private static final String TABLE_NAME = "customer";
	private static Connection connection;
	private static PreparedStatement preparedStatement;

	public PaymentModelDS() {
	}

	public PaymentModelDS(String nomeDb) {
		try {
			// Context initCtx = new InitialContext();
			// Context envCtx = (Context) initCtx.lookup("java:comp/env");
			// ds = (DataSource)
			// initCtx.lookup("jdbc:mysql://localhost/easy_work_platform");

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/easy_work_platform", "root", "");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		// } catch (NamingException e) {
		// e.printStackTrace();
		// }
	}

	@Override
	public void insert(Payment payment) throws SQLException {
		String insertSql = "INSERT INTO " + PaymentModelDS.TABLE_NAME
				+ "(amount, date_payment, service_id, service_customer_id, service_article_id) VALUES (?,?,?,?,?)";
		try {
			connection.setAutoCommit(false);
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

	@Override
	public void update(Payment payment) throws SQLException {
		String updateSql = "UPDATE " + PaymentModelDS.TABLE_NAME
				+ " SET (amount=?, date_payment=?, service_id=?, service_customer_id=?,"
				+ " service_article_id=?) WHERE (id = ?)";
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setDouble(1, payment.getAmount());
			preparedStatement.setDate(2, (Date) payment.getDate());
			preparedStatement.setInt(3, payment.getServiceId());
			preparedStatement.setInt(4, payment.getServiceCustomerId());
			preparedStatement.setInt(5, payment.getServiceArticleId());
			preparedStatement.setInt(5, payment.getId());
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
		}
	}

	@Override
	public void remove(int id) throws SQLException {
		String removeSql = "DELETE FROM " + PaymentModelDS.TABLE_NAME + " WHERE (id = ?)";
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(removeSql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
		}
	}

	@Override
	public Payment findByKey(int id) throws SQLException {
		String selectSql = "SELECT * FROM " + PaymentModelDS.TABLE_NAME + " WHERE (id = ?)";
		Payment payment = null;
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(selectSql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				payment = new Payment();
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

	@Override
	public LinkedList<Payment> findAll() throws SQLException {
		LinkedList<Payment> listPayment = new LinkedList<Payment>();
		String selectSql = "SELECT * FROM " + PaymentModelDS.TABLE_NAME;
		Payment payment = new Payment();
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(selectSql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
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
