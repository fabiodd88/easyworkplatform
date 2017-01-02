package it.unisa.studenti.easyworkplatform.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * 	AccountModelDs
 *	Class that interacts with the database through the information of Account and User
 * 	@author AdminEWP
*/
public class AccountModelDS implements ModelInterface<User> {

//	 private static DataSource ds;
	private static final String TABLE_NAME = "user";
	private static Connection connection = null;
	private static PreparedStatement preparedStatement = null;

	// Static connection to the database
	static {
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

	/**
	 * @see it.unisa.studenti.easyworkplatform.model.ModelInterface#insert(java.lang.Object)
	 */
	@Override
	public void insert(User user) throws SQLException {
		String insertSQL = "INSERT INTO " + AccountModelDS.TABLE_NAME
				+ " (tax_code, name, surname, birth_date, birth_place, address, city, province, cap, email, password, secondary_key)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, user.getTaxCode());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getSurename());
			preparedStatement.setDate(4, (java.sql.Date) user.getBirthdate());
			preparedStatement.setString(5, user.getBirthplace());
			preparedStatement.setString(6, user.getAddress());
			preparedStatement.setString(7, user.getCity());
			preparedStatement.setString(8, user.getProvince());
			preparedStatement.setInt(9, user.getCap());
			preparedStatement.setString(10, user.getEmail());
			String password = user.getPassword();
			String cryptedPassword = toSHA1(password.getBytes());
			preparedStatement.setString(11, cryptedPassword);
			String secondKey = user.getPassword();
			String cryptedSecondKey = toSHA1(secondKey.getBytes());
			preparedStatement.setString(12, cryptedSecondKey);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
		}
	}

	/**
	 * @see it.unisa.studenti.easyworkplatform.model.ModelInterface#update(java.lang.Object)
	 */
	@Override
	public void update(User user) throws SQLException {

		String updateSql = "UPDATE " + AccountModelDS.TABLE_NAME
				+ " SET (tax_code = ?, name = ?, surname = ?, birth_date = ?, birth_place = ?, address = ?, city = ?, province = ?, cap = ?, email = ?, password = ?, secondaryKey = ?)"
				+ " WHERE (id = ?)";
		try {
			preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setString(1, user.getTaxCode());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getSurename());
			preparedStatement.setDate(4, (java.sql.Date) user.getBirthdate());
			preparedStatement.setString(5, user.getBirthplace());
			preparedStatement.setString(6, user.getAddress());
			preparedStatement.setString(7, user.getCity());
			preparedStatement.setString(8, user.getProvince());
			preparedStatement.setInt(9, user.getCap());
			preparedStatement.setString(10, user.getEmail());
			String password = user.getPassword();
			String cryptedPassword = toSHA1(password.getBytes());
			preparedStatement.setString(11, cryptedPassword);
			String secondKey = user.getPassword();
			String cryptedSecondKey = toSHA1(secondKey.getBytes());
			preparedStatement.setString(12, cryptedSecondKey);
			preparedStatement.setInt(13, user.getId());
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
		String removeSql = "DELETE FROM " + AccountModelDS.TABLE_NAME + " WHERE (id = ?)";
		try {
			preparedStatement = connection.prepareStatement(removeSql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (Exception e) {
		}
	}

	/**
	 * @see it.unisa.studenti.easyworkplatform.model.ModelInterface#findByKey(int)
	 */
	@Override
	public User findByKey(int id) throws SQLException {
		User user = null;
		String selectSql = "SELECT * FROM " + AccountModelDS.TABLE_NAME + " WHERE (id = ?)";
		try {
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
				user.setSurename(rs.getString("surname"));
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
	 * @see it.unisa.studenti.easyworkplatform.model.ModelInterface#findAll()
	 */
	@Override
	public LinkedList<User> findAll() throws SQLException {
		LinkedList<User> listAccount = new LinkedList<User>();
		String selectSql = "SELECT * FROM " + AccountModelDS.TABLE_NAME;
		try {
			preparedStatement = connection.prepareStatement(selectSql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setSecondKey(rs.getString("secondary_key"));
				user.setName(rs.getString("name"));
				user.setSurename(rs.getString("surname"));
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
	 * @param email of the user
	 * @return User
	 * @throws SQLException
	 */
	public User findByEmail(String email) throws SQLException {
		User user = null;
		String selectSql = "SELECT * FROM " + AccountModelDS.TABLE_NAME + " WHERE (email = ?)";
		try {
			preparedStatement = connection.prepareStatement(selectSql);
			preparedStatement.setString(1, email);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setSecondKey(rs.getString("secondary_key"));
				user.setName(rs.getString("name"));
				user.setSurename(rs.getString("surname"));
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
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * @see it.unisa.studenti.easyworkplatform.model.ModelInterface#closeConnection()
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

	/**
	 * Encrypt date
	 * @param convertMe
	 * @return encrypted String
	 */
	private static String toSHA1(byte[] convertMe) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return new String(md.digest(convertMe));
	}

}
