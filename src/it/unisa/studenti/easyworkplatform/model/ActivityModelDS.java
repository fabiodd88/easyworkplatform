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

	
	private static final String TABLE_NAME = "event";
	private String activityName;
	private static DataSource ds;
	private static Connection connection = null;
	private static PreparedStatement preparedStatement = null;

	 {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			ds = (DataSource) envCtx.lookup("jdbc/"+activityName);
		} catch (NamingException e) {

		}
	}
	
	@Override
	public void insert(Activity entity) throws SQLException {
		// TODO Auto-generated method stub
		
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
