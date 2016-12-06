package it.unisa.studenti.easyworkplatform.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

	static{
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
		
		String insertSql="INSERT INTO "+ActivityModelDS.TABLE_NAME+
				"(idActivity,vatNumber,name,type,address,city,province,cap,userId)"
				+ "VALUES (?,?,?,?,?,?,?,?,?)";
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSql);
			preparedStatement.setInt(1, activity.getIdActivity());
			preparedStatement.setString(2, activity.getVatNumber());
			preparedStatement.setString(3, activity.getName());
			preparedStatement.setString(4, activity.getType());
			preparedStatement.setString(5, activity.getAddress());
			preparedStatement.setString(6, activity.getCity());
			preparedStatement.setString(7, activity.getProvince());
			preparedStatement.setInt(8, activity.getCap());
			preparedStatement.setInt(9, activity.getUserId());
			preparedStatement.executeUpdate();
			connection.commit();
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally
		{
			if (preparedStatement != null)  preparedStatement.close();
			if (connection != null) 		connection.close();			
		}
	}

	@Override
	public void update(Activity entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Activity findByKey(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<Activity> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
		
}
