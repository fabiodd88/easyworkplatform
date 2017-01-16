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
 * Class that interacts with the database through the information of Customer
 *
 * @author AdminEWP
*/
public class CustomerModelDS implements ModelInterface<Customer> {

	private static DataSource ds;
	private String table = "_customer";
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private String tableName;
	
	/**
	 * Empty constructor
	 */
	public CustomerModelDS() {
	}

	/**
	 * Parametric constructor with the name of the database
	 * @param nomeDb - Name of the database
	 * @param activity - Name of the activity
	 */
	public CustomerModelDS(String nomeDb, String activity) {
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
	 * Insert a new instance of customer
	 * @param customer - Customer to insert
	 * @throws SQLException if a database insert error occurs.
	 */
	@Override
	public void insert(Customer customer) throws SQLException {

		String insertSql = "INSERT INTO " + tableName
				+ "(name, surname, birth_date, birth_place, address, city, province, cap, phone_number, newsletter, email)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			//connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSql);
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getSurname());
			preparedStatement.setDate(3, (Date) customer.getBirthdate());
			preparedStatement.setString(4, customer.getBirthplace());
			preparedStatement.setString(5, customer.getAddress());
			preparedStatement.setString(6, customer.getCity());
			preparedStatement.setString(7, customer.getProvince());
			preparedStatement.setInt(8, customer.getCap());
			preparedStatement.setString(9, customer.getPhoneNumber());
			preparedStatement.setInt(10, customer.getNewsletter());
			preparedStatement.setString(11, customer.getEmail());
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
		}
	}

	/**
	 * Update a existing customer
	 * @param customer - Customer to update
	 * @throws SQLException if a database update error occurs.
	 */
	public void update(Customer customer) throws SQLException {
		String updateSql = "UPDATE " + tableName
				+ " SET name=?,surname=?,birth_date=?,birth_place=?,address=?,city=?,province=?,"
				+ " cap=?,phone_number=?,newsletter=?,email=?" + "WHERE (id = ?)";
		try {
			//connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getSurname());
			preparedStatement.setDate(3, (Date) customer.getBirthdate());
			preparedStatement.setString(4, customer.getBirthplace());
			preparedStatement.setString(5, customer.getAddress());
			preparedStatement.setString(6, customer.getCity());
			preparedStatement.setString(7, customer.getProvince());
			preparedStatement.setInt(8, customer.getCap());
			preparedStatement.setString(9, customer.getPhoneNumber());
			preparedStatement.setInt(10, customer.getNewsletter());
			preparedStatement.setString(11, customer.getEmail());
			preparedStatement.setInt(12, customer.getId());
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
		}
	}

	/**
	 * Remove a customer with a specific id
	 * @param id - Customer id to remove
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
	 * Find a customer by its id
	 * @param id - Customer id to find
	 * @return Customer found
	 * @throws SQLException if a database select error occurs. 
	 */
	@Override
	public Customer findByKey(int id) throws SQLException {
		String selectSql = "SELECT * FROM " + tableName + " WHERE (id = ?)";
		Customer customer = null;
		try {
			//connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setName(rs.getString("name"));
				customer.setSurname(rs.getString("surname"));
				customer.setBirthdate(rs.getDate("birth_date"));
				customer.setBirthplace(rs.getString("birth_place"));
				customer.setAddress(rs.getString("address"));
				customer.setCity(rs.getString("city"));
				customer.setProvince(rs.getString("province"));
				customer.setCap(rs.getInt("cap"));
				customer.setPhoneNumber(rs.getString("phone_number"));
				customer.setNewsletter(rs.getInt("newsletter"));
				customer.setEmail(rs.getString("email"));
			}
			connection.commit();
		} catch (SQLException e) {
		}
		return customer;
	}

	/**
	 * Find a customer by a selected attribute and the parameter to search 
	 * @param attribute - Attribute of the customer
	 * @param toSearch - Parameters to search in the attribute field of the customer
	 * @return List of Customer
	 * @throws SQLException if a database select error occurs. 
	 */
	public LinkedList<Customer> findByField(String attribute, String toSearch) throws SQLException{
		LinkedList<Customer> listCustomer = new LinkedList<Customer>();
		String selectSql = "SELECT * FROM " + tableName +" WHERE ("+attribute+" LIKE ?)";
		Customer customer = new Customer();
		try {
			//connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			preparedStatement.setString(1, toSearch+"%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				customer.setId(rs.getInt("id"));
				customer.setName(rs.getString("name"));
				customer.setSurname(rs.getString("surname"));
				customer.setBirthdate(rs.getDate("birth_date"));
				customer.setBirthplace(rs.getString("birth_place"));
				customer.setAddress(rs.getString("address"));
				customer.setCity(rs.getString("city"));
				customer.setProvince(rs.getString("province"));
				customer.setCap(rs.getInt("cap"));
				customer.setPhoneNumber(rs.getString("phone_number"));
				customer.setNewsletter(rs.getInt("newsletter"));
				customer.setEmail(rs.getString("email"));
				listCustomer.add(customer);
			}
		} catch (SQLException e) {
		}
		return listCustomer;
	}
	
	/**
	 * Return a List of all the Customer
	 * @return List of Customer
	 * @throws SQLException - if a database select error occurs.
	 */
	@Override
	public LinkedList<Customer> findAll() throws SQLException {
		LinkedList<Customer> listCustomer = new LinkedList<Customer>();
		String selectSql = "SELECT * FROM " + tableName + ";";
		try {
			//connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setName(rs.getString("name"));
				customer.setSurname(rs.getString("surname"));
				customer.setBirthdate(rs.getDate("birth_date"));
				customer.setBirthplace(rs.getString("birth_place"));
				customer.setAddress(rs.getString("address"));
				customer.setCity(rs.getString("city"));
				customer.setProvince(rs.getString("province"));
				customer.setCap(rs.getInt("cap"));
				customer.setPhoneNumber(rs.getString("phone_number"));
				customer.setNewsletter(rs.getInt("newsletter"));
				customer.setEmail(rs.getString("email"));
				listCustomer.add(customer);
			}
		} catch (SQLException e) {
		}
		return listCustomer;
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
