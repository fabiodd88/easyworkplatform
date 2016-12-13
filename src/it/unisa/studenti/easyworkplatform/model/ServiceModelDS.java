package it.unisa.studenti.easyworkplatform.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class ServiceModelDS implements ModelInterface<Service> {

	// private static DataSource ds;
	private static final String TABLE_NAME = "service";
	private static Connection connection;
	private static PreparedStatement preparedStatement;

	// Costruttore ausiliare prima dell'ideazione della Classe Astratta per la
	// connessione a database con nomi diversi
	public ServiceModelDS() {
	}

	public ServiceModelDS(String nomeDb) {
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
	public void insert(Service service) throws SQLException {
		String insertSql = "INSERT INTO " + ServiceModelDS.TABLE_NAME
				+ "(employee, quantity, variation, note, receipt_data, return_date, article_id, customer_id)"
				+ " VALUES (?,?,?,?,?,?,?,?)";
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(insertSql);
			preparedStatement.setString(1, service.getEmployee());
			preparedStatement.setInt(2, service.getQuantity());
			preparedStatement.setString(3, service.getVariation());
			preparedStatement.setString(4, service.getNote());
			preparedStatement.setDate(5, (Date) service.getReceiptDate());
			preparedStatement.setDate(6, (Date) service.getReturnDate());
			preparedStatement.setInt(7, service.getArticleId());
			preparedStatement.setInt(8, service.getCustomerId());
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
		}
	}

	@Override
	public void update(Service service) throws SQLException {
		String updateSql = "UPDATE" + ServiceModelDS.TABLE_NAME + "SET (employeee=?, quantity=?, variation=?, note=?,"
				+ "receipt_date=?, return_date=?, article_id=?, customer_id=?) WHERE (id==?)";
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setString(1, service.getEmployee());
			preparedStatement.setInt(2, service.getQuantity());
			preparedStatement.setString(3, service.getVariation());
			preparedStatement.setString(4, service.getNote());
			preparedStatement.setDate(5, (Date) service.getReceiptDate());
			preparedStatement.setDate(6, (Date) service.getReturnDate());
			preparedStatement.setInt(7, service.getArticleId());
			preparedStatement.setInt(8, service.getCustomerId());
			preparedStatement.setInt(9, service.getId());
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
		}
	}

	@Override
	public void remove(int id) throws SQLException {
		String removeSql = "DELETE FROM" + ServiceModelDS.TABLE_NAME + " WHERE (id == ?)";
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
	public Service findByKey(int id) throws SQLException {
		String selectSql = "SELECT * FROM " + ServiceModelDS.TABLE_NAME + " WHERE (id == ?)";
		Service service = null;
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(selectSql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				service = new Service();
				service.setEmployee(rs.getString("employee"));
				service.setQuantity(rs.getInt("quantity"));
				service.setVariation(rs.getString("variation"));
				service.setNote(rs.getString("note"));
				service.setReceiptDate(rs.getDate("receipt_data"));
				service.setReturnDate(rs.getDate("return_date"));
				service.setArticleId(rs.getInt("article_id"));
				service.setCustomerId(rs.getInt("customer_id"));
			}
			connection.commit();
		} catch (SQLException e) {
		}
		return service;

	}

	@Override
	public LinkedList<Service> findAll() throws SQLException {
		LinkedList<Service> listService = new LinkedList<Service>();
		String selectSql = "SELECT * FROM " + ServiceModelDS.TABLE_NAME + ";";
		Service service = new Service();
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(selectSql);
			ResultSet rs = preparedStatement.executeQuery(selectSql);
			while (rs.next()) {
				service.setEmployee(rs.getString("employee"));
				service.setQuantity(rs.getInt("quantity"));
				service.setVariation(rs.getString("variation"));
				service.setNote(rs.getString("note"));
				service.setReceiptDate(rs.getDate("receipt_data"));
				service.setReturnDate(rs.getDate("return_date"));
				service.setArticleId(rs.getInt("article_id"));
				service.setCustomerId(rs.getInt("customer_id"));
				listService.add(service);
			}
		} catch (SQLException e) {
		}
		return listService;
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
