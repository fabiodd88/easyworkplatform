package it.unisa.studenti.easyworkplatform.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ActivityModelDS implements ModelInterface<Activity> {

	private static final String TABLE_NAME = "activity";
	private static DataSource ds;
	private static Connection connection;
	private static PreparedStatement preparedStatement;

	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			ds = (DataSource) envCtx.lookup("jdbc/easy_work_platform");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(Activity activity) throws SQLException {

		String insertSql = "INSERT INTO " + ActivityModelDS.TABLE_NAME
				+ "(vat_number, name, type, address, city, province, cap, user_id)" + "VALUES (?,?,?,?,?,?,?,?)";
		try{
			connection = ds.getConnection();
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
		}
		catch(SQLException e){	}
		finally{
			try{
				if (preparedStatement != null)  preparedStatement.close();
				if (connection != null) 		connection.close();	
			}
			catch(SQLException e){	}
		}
	}

	@Override
	public void update(Activity activity) throws SQLException {
		String updateSql = "UPDATE " + ActivityModelDS.TABLE_NAME
				+ " SET vat_number = ?, name = ?, type = ?, address = ?, city = ?, province = ?, cap = ?)"
				+ " WHERE (id == ? && user_id == ?)";
		try{
			connection = ds.getConnection();
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
		}
		catch(SQLException e){	}
		finally{
			try{
				if (preparedStatement != null)  preparedStatement.close();
				if (connection != null) 		connection.close();	
			}
			catch(SQLException e){	}
		}
	}
	
	@Override
	public void remove(int id) throws SQLException {
		String removeSql = "DELETE FROM" + ActivityModelDS.TABLE_NAME + " WHERE (id == ?)";
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(removeSql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null)	preparedStatement.close();
			if (connection != null) connection.close();
		}

	}
	
	@Override
	public Activity findByKey(int id) throws SQLException {
		Activity activity = null;
		String selectSql = "SELECT * FROM " + ActivityModelDS.TABLE_NAME + " WHERE (id == ?)";
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery(selectSql);
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
			}
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return activity;
	}

	@Override
	public LinkedList<Activity> findAll() throws SQLException {
		LinkedList<Activity> listActivity = new LinkedList<Activity>();
		String selectSql = "SELECT * FROM " + ActivityModelDS.TABLE_NAME;
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			ResultSet rs = preparedStatement.executeQuery(selectSql);
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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return listActivity;
	}

}
