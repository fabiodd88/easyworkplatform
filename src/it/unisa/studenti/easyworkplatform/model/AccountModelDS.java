package it.unisa.studenti.easyworkplatform.model;

import java.sql.Connection;
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
 * Class that interacts with the database through the information of Account and User
 * 
 * @author AdminEWP
*/
public class AccountModelDS implements ModelInterface<User> {

	private static final String TABLE_NAME ="user";
	private static Connection connection = null;
	private static PreparedStatement preparedStatement = null;
	private static DataSource ds;

	// Static connection to the database
	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			ds = (DataSource) envCtx.lookup("jdbc/dbtest");
			connection = ds.getConnection();
		 } catch (NamingException | SQLException e) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost/dbtest", "root", "");
				connection.setAutoCommit(false);
			} catch (SQLException | ClassNotFoundException ex) {
				e.printStackTrace();
			}
		 }
	}

	/**
	 * Insert a new instance of user
	 * @param user - User to insert
	 * @throws SQLException if a database insert error occurs.
	 */
	@Override
	public void insert(User user) throws SQLException {
		String insertSQL = "INSERT INTO " + AccountModelDS.TABLE_NAME
				+ " (name, surname, birth_date, birth_place, address, city, province, cap, tax_code, email, password, secondary_key) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			////connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getSurname());
			preparedStatement.setDate(3, (java.sql.Date) user.getBirthdate());
			preparedStatement.setString(4, user.getBirthplace());
			preparedStatement.setString(5, user.getAddress());
			preparedStatement.setString(6, user.getCity());
			preparedStatement.setString(7, user.getProvince());
			preparedStatement.setInt(8, user.getCap());
			preparedStatement.setString(9, user.getTaxCode());
			preparedStatement.setString(10, user.getEmail());
			preparedStatement.setString(11,  user.getPassword());
			preparedStatement.setString(12,  user.getSecondKey());
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
		}
	}

	/**
	 * Update an existing user
	 * @param user - User to update
	 * @throws SQLException if a database update error occurs.
	 */
	@Override
	public void update(User user) throws SQLException {

		String updateSql = "UPDATE " + AccountModelDS.TABLE_NAME
				+ " SET name = ?, surname = ?, birth_date = ?, birth_place = ?, address = ?, city = ?, province = ?, cap = ?, tax_code = ?, email = ?, password = ?, secondary_key = ?"
				+ " WHERE (id = ?)";
		try {
			////connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getSurname());
			preparedStatement.setDate(3, (java.sql.Date) user.getBirthdate());
			preparedStatement.setString(4, user.getBirthplace());
			preparedStatement.setString(5, user.getAddress());
			preparedStatement.setString(6, user.getCity());
			preparedStatement.setString(7, user.getProvince());
			preparedStatement.setInt(8, user.getCap());
			preparedStatement.setString(9, user.getTaxCode());
			preparedStatement.setString(10, user.getEmail());
			preparedStatement.setString(11,  user.getPassword());
			preparedStatement.setString(12,  user.getSecondKey());
			preparedStatement.setInt(13, user.getId());
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
		}
	}

	/**
	 * Remove a user with a specific id
	 * @param id - User id to remove
	 * @throws SQLException if a database delete error occurs.
	 */
	@Override
	public void remove(int id) throws SQLException {
		String removeSql = "DELETE FROM " + AccountModelDS.TABLE_NAME + " WHERE (id = ?)";
		try {
			////connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(removeSql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (Exception e) {
		}
	}

	/**
	 * Find a user by its id
	 * @param id - User id to find
	 * @return User found
	 * @throws SQLException if a database select error occurs. 
	 */
	@Override
	public User findByKey(int id) throws SQLException {
		User user = null;
		String selectSql = "SELECT * FROM " + AccountModelDS.TABLE_NAME + " WHERE (id = ?)";
		try {
			////connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(id);
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setSecondKey(rs.getString("secondary_key"));
				user.setName(rs.getString("name"));
				user.setSurname(rs.getString("surname"));
				user.setBirthdate(rs.getDate("birth_date"));
				user.setBirthplace(rs.getString("birth_place"));
				user.setAddress(rs.getString("address"));
				user.setCity(rs.getString("city"));
				user.setProvince(rs.getString("province"));
				user.setCap(rs.getInt("cap"));
				user.setTaxCode(rs.getString("tax_code"));
			}
			connection.commit();
		} catch (Exception e) {
		}
		return user;
	}

	/**
	 * Return a List of all the User
	 * @return List of User
	 * @throws SQLException - if a database select error occurs.
	 */
	@Override
	public LinkedList<User> findAll() throws SQLException {
		LinkedList<User> listAccount = new LinkedList<User>();
		String selectSql = "SELECT * FROM " + AccountModelDS.TABLE_NAME;
		try {
			////connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setSecondKey(rs.getString("secondary_key"));
				user.setName(rs.getString("name"));
				user.setSurname(rs.getString("surname"));
				user.setBirthdate(rs.getDate("birth_date"));
				user.setBirthplace(rs.getString("birth_place"));
				user.setAddress(rs.getString("address"));
				user.setCity(rs.getString("city"));
				user.setProvince(rs.getString("province"));
				user.setCap(rs.getInt("cap"));
				user.setTaxCode(rs.getString("tax_code"));
				listAccount.add(user);
			}
			connection.commit();
		} catch (Exception e) {
		}
		return listAccount;
	}

	/**
	 * Find a user by his email
	 * @param email - User email to find
	 * @return User found
	 * @throws SQLException - if a database select error occurs.
	 */
	public User findByEmail(String email) throws SQLException {
		User user = null;
		String selectSql = "SELECT * FROM " + AccountModelDS.TABLE_NAME + " WHERE email = ?";
		try {
			////connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			preparedStatement.setString(1, email);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setSurname(rs.getString("surname"));
				user.setBirthdate(rs.getDate("birth_date"));
				user.setBirthplace(rs.getString("birth_place"));
				user.setAddress(rs.getString("address"));
				user.setCity(rs.getString("city"));
				user.setProvince(rs.getString("province"));
				user.setCap(rs.getInt("cap"));
				user.setTaxCode(rs.getString("tax_code"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setSecondKey(rs.getString("secondary_key"));
			}
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * Close connection to the database
	 * @throws SQLException - if a database error occurs.
	 */
	@Override
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
