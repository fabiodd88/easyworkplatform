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
//		
//		String insertSql="INSERT INTO "+ActivityModelDS.TABLE_NAME+
//				"(idActivity,vatNumber,nameActivity,tipology,addressActivity,userId)"
//				+ "VALUES (?,?,?,?,?,?)";
//		try {
//			connection = ds.getConnection();
//			preparedStatement = connection.prepareStatement(insertSql);
//			preparedStatement.setString(1, activity.);
//
//			preparedStatement.executeUpdate();
//			connection.commit();
//		} 
//		catch (Exception e) {
//			e.printStackTrace();
//		} 
//		finally
//		{
//			if (preparedStatement != null)  preparedStatement.close();
//			if (connection != null) 		connection.close();			
//		}
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
