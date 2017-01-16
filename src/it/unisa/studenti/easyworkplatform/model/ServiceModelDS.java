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
 * Class that interacts with the database through the information of Service
 *
 * @author AdminEWP
*/
public class ServiceModelDS implements ModelInterface<Service> {

	private static DataSource ds;
	private String table = "_service";
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private String tableName;
	
	/**
	 * Empty constructor
	 */
	public ServiceModelDS() {
	}

	/**
	 * Parametric constructor with the name of the database
	 * @param nomeDb - Name of the database
	 * @param activity - Name of the activity
	 */
	public ServiceModelDS(String nomeDb, String activity) {
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
	 * Insert a new instance of service
	 * @param service - Service to insert
	 * @throws SQLException if a database insert error occurs.
	 */
	@Override
	public void insert(Service service) throws SQLException {
		String insertSql = "INSERT INTO " + tableName
				+ "(employee, quantity, variation, note, receipt_date, return_date, article_id, customer_id)"
				+ " VALUES (?,?,?,?,?,?,?,?)";
		try {
			//connection = ds.getConnection();
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

	/**
	 * Update an existing service
	 * @param service - Service to update
	 * @throws SQLException if a database update error occurs.
	 */
	@Override
	public void update(Service service) throws SQLException {
		String updateSql = "UPDATE " + tableName + " SET employee=?, quantity=?, variation=?, note=?,"
				+ " receipt_date=?, return_date=?, article_id=?, customer_id=? WHERE (id = ?)";
		try {
			//connection = ds.getConnection();
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

	/**
	 * Remove a service with a specific id
	 * @param id - Service id to remove
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
	 * Find a service by its id
	 * @param id - Service id to find
	 * @return Service found
	 * @throws SQLException if a database select error occurs. 
	 */
	@Override
	public Service findByKey(int id) throws SQLException {
		String selectSql = "SELECT * FROM " + tableName + " WHERE (id = ?)";
		Service service = null;
		try {
			//connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				service = new Service();
				service.setId(rs.getInt("id"));
				service.setEmployee(rs.getString("employee"));
				service.setQuantity(rs.getInt("quantity"));
				service.setVariation(rs.getString("variation"));
				service.setNote(rs.getString("note"));
				service.setReceiptDate(rs.getDate("receipt_date"));
				service.setReturnDate(rs.getDate("return_date"));
				service.setArticleId(rs.getInt("article_id"));
				service.setCustomerId(rs.getInt("customer_id"));
			}
			connection.commit();
		} catch (SQLException e) {
		}
		return service;

	}

	/**
	 * Find a service by a selected attribute and the parameter to search 
	 * @param attribute - Attribute of the service
	 * @param toSearch - Parameters to search in the attribute field of the service
	 * @return List of Service
	 * @throws SQLException if a database select error occurs. 
	 */
	public LinkedList<Service> findByField(String attribute, String toSearch) throws SQLException{
		LinkedList<Service> listService = new LinkedList<Service>();
		String selectSql = "SELECT * FROM " + tableName+" WHERE ("+attribute+" LIKE ?)";
		Service service = new Service();
		try {
			//connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			preparedStatement.setString(1, toSearch+"%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				service.setId(rs.getInt("id"));
				service.setEmployee(rs.getString("employee"));
				service.setQuantity(rs.getInt("quantity"));
				service.setVariation(rs.getString("variation"));
				service.setNote(rs.getString("note"));
				service.setReceiptDate(rs.getDate("receipt_date"));
				service.setReturnDate(rs.getDate("return_date"));
				service.setArticleId(rs.getInt("article_id"));
				service.setCustomerId(rs.getInt("customer_id"));
				listService.add(service);
			}
		} catch (SQLException e) {
		}
		return listService;
	}
	
	/**
	 * Return a List of all the Service
	 * @return List of Service
	 * @throws SQLException - if a database select error occurs.
	 */
	@Override
	public LinkedList<Service> findAll() throws SQLException {
		LinkedList<Service> listService = new LinkedList<Service>();
		String selectSql = "SELECT * FROM " + tableName + ";";
		try {
			//connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			ResultSet rs = preparedStatement.executeQuery(selectSql);
			while (rs.next()) {
				Service service = new Service();
				service.setId(rs.getInt("id"));
				service.setEmployee(rs.getString("employee"));
				service.setQuantity(rs.getInt("quantity"));
				service.setVariation(rs.getString("variation"));
				service.setNote(rs.getString("note"));
				service.setReceiptDate(rs.getDate("receipt_date"));
				service.setReturnDate(rs.getDate("return_date"));
				service.setArticleId(rs.getInt("article_id"));
				service.setCustomerId(rs.getInt("customer_id"));
				listService.add(service);
			}
		} catch (SQLException e) {
		}
		return listService;
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
