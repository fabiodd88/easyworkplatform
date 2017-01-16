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
 * Class that interacts with the database through the information of Activity
 *
 * @author AdminEWP
*/
public class ActivityModelDS implements ModelInterface<Activity> {

	private static DataSource ds;
	private static final String TABLE_NAME = "activity";
	private static Connection connection;
	private static PreparedStatement preparedStatement;

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
	 * Insert a new instance of activity
	 * @param activity - Activity to insert
	 * @throws SQLException if a database insert error occurs.
	 */
	@Override
	public void insert(Activity activity) throws SQLException {

		String insertSql = "INSERT INTO " + ActivityModelDS.TABLE_NAME
				+ "(vat_number, name, type, address, city, province, cap, user_id) VALUES (?,?,?,?,?,?,?,?)";
		try {
			//connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSql);
			preparedStatement.setString(1, activity.getVatNumber());
			preparedStatement.setString(2, activity.getName());
			preparedStatement.setString(3, activity.getType());
			preparedStatement.setString(4, activity.getAddress());
			preparedStatement.setString(5, activity.getCity());
			preparedStatement.setString(6, activity.getProvince());
			preparedStatement.setInt(7, activity.getCap());
			preparedStatement.setInt(8, activity.getUserId());
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
		}
	}

	/**
	 * Update an existing activity
	 * @param activity - Activity to update
	 * @throws SQLException if a database update error occurs.
	 */
	@Override
	public void update(Activity activity) throws SQLException {
		String updateSql = "UPDATE " + ActivityModelDS.TABLE_NAME
				+ " SET vat_number = ?, name = ?, type = ?, address = ?, city = ?, province = ?, cap = ?"
				+ " WHERE (id = ? && user_id = ?)";
		try {
			//connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setString(1, activity.getVatNumber());
			preparedStatement.setString(2, activity.getName());
			preparedStatement.setString(3, activity.getType());
			preparedStatement.setString(4, activity.getAddress());
			preparedStatement.setString(5, activity.getCity());
			preparedStatement.setString(6, activity.getProvince());
			preparedStatement.setInt(7, activity.getCap());
			preparedStatement.setInt(8, activity.getId());
			preparedStatement.setInt(9, activity.getUserId());
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
		}
	}

	/**
	 * Remove an activity with a specific id
	 * @param id - Activity id to remove
	 * @throws SQLException if a database delete error occurs.
	 */
	@Override
	public void remove(int id) throws SQLException {
		String removeSql = "DELETE FROM " + ActivityModelDS.TABLE_NAME + " WHERE (id = ?)";
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
	 * Find an activity by its id
	 * @param id - Activity id to find
	 * @return Activity found
	 * @throws SQLException if a database select error occurs. 
	 */
	@Override
	public Activity findByKey(int id) throws SQLException {
		Activity activity = null;
		String selectSql = "SELECT * FROM " + ActivityModelDS.TABLE_NAME + " WHERE (user_id = ?)";
		try {
			//connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				activity = new Activity();
				activity.setId(id);
				activity.setName(rs.getString("name"));
				activity.setType(rs.getString("type"));
				activity.setAddress(rs.getString("address"));
				activity.setCity(rs.getString("city"));
				activity.setProvince(rs.getString("province"));
				activity.setCap(rs.getInt("cap"));
				activity.setVatNumber(rs.getString("vat_number"));
				activity.setUserId(rs.getInt("user_id"));
			}
			connection.commit();
		} catch (SQLException e) {
		}
		return activity;
	}

	/**
	 * Find an activity by a selected attribute and the parameter to search 
	 * @param attribute - Attribute of the activity
	 * @param toSearch - Parameters to search in the attribute field of the activity
	 * @return List of Activity
	 * @throws SQLException if a database select error occurs. 
	 */
	public LinkedList<Activity> findByField(String attribute, String toSearch) throws SQLException{
		LinkedList<Activity> listActivity = new LinkedList<Activity>();
		String selectSql = "SELECT * FROM " +ActivityModelDS.TABLE_NAME+" WHERE ("+attribute+" LIKE ?)";
		Activity activity = new Activity();
		try {
			//connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			preparedStatement.setString(1, toSearch+"%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				activity.setId(rs.getInt("id"));
				activity.setName(rs.getString("name"));
				activity.setType(rs.getString("type"));
				activity.setAddress(rs.getString("address"));
				activity.setCity(rs.getString("city"));
				activity.setProvince(rs.getString("province"));
				activity.setCap(rs.getInt("cap"));
				activity.setVatNumber(rs.getString("vat_number"));
				activity.setUserId(rs.getInt("user_id"));
				listActivity.add(activity);
			}
		} catch (SQLException e) {
		}
		return listActivity;
	}
	
	/**
	 * Return a List of all the Activity
	 * @return List of Activity
	 * @throws SQLException - if a database select error occurs.
	 */
	@Override
	public LinkedList<Activity> findAll() throws SQLException {
		LinkedList<Activity> listActivity = new LinkedList<Activity>();
		String selectSql = "SELECT * FROM " + ActivityModelDS.TABLE_NAME;
		try {
			//connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Activity activity = new Activity();
				activity.setId(rs.getInt("id"));
				activity.setName(rs.getString("name"));
				activity.setType(rs.getString("type"));
				activity.setAddress(rs.getString("address"));
				activity.setCity(rs.getString("city"));
				activity.setProvince(rs.getString("province"));
				activity.setCap(rs.getInt("cap"));
				activity.setVatNumber(rs.getString("vat_number"));
				activity.setUserId(rs.getInt("user_id"));
				listActivity.add(activity);
			}
			connection.commit();
		} catch (SQLException e) {
		}
		return listActivity;
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
