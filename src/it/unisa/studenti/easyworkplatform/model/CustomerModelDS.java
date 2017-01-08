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
 * 	CustomerModelDs
 *	Class that interacts with the database through the information of Customer
 *	@author AdminEWP
*/
public class CustomerModelDS implements ModelInterface<Customer> {

	private static DataSource ds;
	private static final String TABLE_NAME = "pizzeria_customer";
	private static Connection connection;
	private static PreparedStatement preparedStatement;

	/**
	 * Empty constructor
	 */
	public CustomerModelDS() {
	}

	/**
	 * Parametric constructor with the name of the database
	 * @param nomeDb of the database
	 */
	public CustomerModelDS(String nomeDb) {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			ds = (DataSource) envCtx.lookup("jdbc/"+nomeDb);

		 } catch (NamingException e) {
			 e.printStackTrace();
		 }
	}

	/**
	 * @see it.unisa.studenti.easyworkplatform.model.ModelInterface#insert(java.lang.Object)
	 */
	@Override
	public void insert(Customer customer) throws SQLException {

		String insertSql = "INSERT INTO " + CustomerModelDS.TABLE_NAME
				+ "(name, surname, birth_date, birth_place, address, city, province, cap, phone_number, newsletter, email)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			connection=ds.getConnection();
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
	 * @see it.unisa.studenti.easyworkplatform.model.ModelInterface#update(java.lang.Object)
	 */
	@Override
	public void update(Customer customer) throws SQLException {
		String updateSql = "UPDATE " + CustomerModelDS.TABLE_NAME
				+ " SET name=?,surname=?,birth_date=?,birth_place=?,address=?,city=?,province=?,"
				+ " cap=?,phone_number=?,newsletter=?,email=?" + "WHERE (id = ?)";
		try {
			connection=ds.getConnection();
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
	 * @see it.unisa.studenti.easyworkplatform.model.ModelInterface#remove(int)
	 */
	@Override
	public void remove(int id) throws SQLException {
		String removeSql = "DELETE FROM " + CustomerModelDS.TABLE_NAME + " WHERE (id = ?)";
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
	public Customer findByKey(int id) throws SQLException {
		String selectSql = "SELECT * FROM " + CustomerModelDS.TABLE_NAME + " WHERE (id = ?)";
		Customer customer = null;
		try {
			connection=ds.getConnection();
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
	 * Return a list of specific customers
	 * @param attribute of customer
	 * @param toSearch parameter
	 * @return
	 * @throws SQLException
	 */
	public LinkedList<Customer> findByField(String attribute, String toSearch) throws SQLException{
		LinkedList<Customer> listCustomer = new LinkedList<Customer>();
		String selectSql = "SELECT * FROM " + CustomerModelDS.TABLE_NAME+" WHERE ("+attribute+" LIKE ?)";
		Customer customer = new Customer();
		try {
			connection=ds.getConnection();
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
	 * @see it.unisa.studenti.easyworkplatform.model.ModelInterface#findAll()
	 */
	@Override
	public LinkedList<Customer> findAll() throws SQLException {
		LinkedList<Customer> listCustomer = new LinkedList<Customer>();
		String selectSql = "SELECT * FROM " + CustomerModelDS.TABLE_NAME+ ";";
		try {
			connection=ds.getConnection();
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
