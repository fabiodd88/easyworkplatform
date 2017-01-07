package it.unisa.studenti.easyworkplatform.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**	
 * 	ServiceModelDs
 *	Class that interacts with the database through the information of Service
 *	@author AdminEWP
*/
public class ServiceModelDS implements ModelInterface<Service> {

	private static DataSource ds;
	private static final String TABLE_NAME = "service";
	private static Connection connection;
	private static PreparedStatement preparedStatement;

	/**
	 * Empty constructor
	 */
	public ServiceModelDS() {
	}

	/**
	 * Parametric constructor with the name of the database
	 * @param nomeDb of the database
	 */
	public ServiceModelDS(String nomeDb) {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			ds = (DataSource) envCtx.lookup("jdbc/dbtest");

//			Class.forName("com.mysql.jdbc.Driver");
//			connection = DriverManager.getConnection("jdbc:mysql://localhost/dbtest", "root", "");
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}

		 } catch (NamingException e) {
			 e.printStackTrace();
		 }
	}

	/**
	 * @see it.unisa.studenti.easyworkplatform.model.ModelInterface#insert(java.lang.Object)
	 */
	@Override
	public void insert(Service service) throws SQLException {
		String insertSql = "INSERT INTO " + ServiceModelDS.TABLE_NAME
				+ "(name, employee, quantity, variation, note, receipt_data, return_date, article_id, customer_id)"
				+ " VALUES (?, ?,?,?,?,?,?,?,?)";
		try {
			connection=ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSql);
			preparedStatement.setString(1, service.getName());
			preparedStatement.setString(2, service.getEmployee());
			preparedStatement.setInt(3, service.getQuantity());
			preparedStatement.setString(4, service.getVariation());
			preparedStatement.setString(5, service.getNote());
			preparedStatement.setDate(6, (Date) service.getReceiptDate());
			preparedStatement.setDate(7, (Date) service.getReturnDate());
			preparedStatement.setInt(8, service.getArticleId());
			preparedStatement.setInt(9, service.getCustomerId());
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
		}
	}

	/**
	 * @see it.unisa.studenti.easyworkplatform.model.ModelInterface#update(java.lang.Object)
	 */
	@Override
	public void update(Service service) throws SQLException {
		String updateSql = "UPDATE " + ServiceModelDS.TABLE_NAME + " SET (name=?, employeee=?, quantity=?, variation=?, note=?,"
				+ " receipt_date=?, return_date=?, article_id=?, customer_id=?) WHERE (id = ?)";
		try {
			connection=ds.getConnection();
			preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setString(1, service.getName());
			preparedStatement.setString(2, service.getEmployee());
			preparedStatement.setInt(3, service.getQuantity());
			preparedStatement.setString(4, service.getVariation());
			preparedStatement.setString(5, service.getNote());
			preparedStatement.setDate(6, (Date) service.getReceiptDate());
			preparedStatement.setDate(7, (Date) service.getReturnDate());
			preparedStatement.setInt(8, service.getArticleId());
			preparedStatement.setInt(9, service.getCustomerId());
			preparedStatement.setInt(10, service.getId());
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
		}
	}

	/**
	 * @see it.unisa.studenti.easyworkplatform.model.ModelInterface#remove(int)
	 */
	@Override
	public void remove(int id) throws SQLException {
		String removeSql = "DELETE FROM " + ServiceModelDS.TABLE_NAME + " WHERE (id = ?)";
		try {
			connection=ds.getConnection();
			preparedStatement = connection.prepareStatement(removeSql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
		}
	}

	/**
	 * @see it.unisa.studenti.easyworkplatform.model.ModelInterface#findByKey(int)
	 */
	@Override
	public Service findByKey(int id) throws SQLException {
		String selectSql = "SELECT * FROM " + ServiceModelDS.TABLE_NAME + " WHERE (id = ?)";
		Service service = null;
		try {
			connection=ds.getConnection();
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

	/** 
	 * Return a list of specific services
	 * @param attribute of services
	 * @param toSearch parameter
	 * @return
	 * @throws SQLException
	 */
	public LinkedList<Service> findByField(String attribute, String toSearch) throws SQLException{
		LinkedList<Service> listService = new LinkedList<Service>();
		String selectSql = "SELECT * FROM " +ServiceModelDS.TABLE_NAME+" WHERE ("+attribute+" LIKE ?%)";
		Service service = new Service();
		try {
			connection=ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			preparedStatement.setString(1, toSearch);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				service.setId(rs.getInt("id"));
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
	
	/**
	 * @see it.unisa.studenti.easyworkplatform.model.ModelInterface#findAll()
	 */
	@Override
	public LinkedList<Service> findAll() throws SQLException {
		LinkedList<Service> listService = new LinkedList<Service>();
		String selectSql = "SELECT * FROM " + ServiceModelDS.TABLE_NAME + ";";
		Service service = new Service();
		try {
			connection=ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			ResultSet rs = preparedStatement.executeQuery(selectSql);
			while (rs.next()) {
				service.setId(rs.getInt("id"));
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

	/**
	 * @see it.unisa.studenti.easyworkplatform.model.ModelInterface#closeConnection()
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
