package it.unisa.studenti.easyworkplatform.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class AccountModelDS  implements ModelInterface<User>{
	
	private static DataSource ds;
	private static final String TABLE_NAME = "user";
	private static Connection connection = null;
	private static PreparedStatement preparedStatement = null;

	
	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			ds = (DataSource) envCtx.lookup("jdbc/easy_work_platform");
		} catch (NamingException e) {

		}
	}

	@Override
	public void insert(User user) throws SQLException {
		String insertSQL;

		insertSQL = "INSERT INTO " + AccountModelDS.TABLE_NAME + " (EMAIL, PASSWORD) VALUES (?, ?)";		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, user.getEmail());
			String password = user.getPassword();
			String cryptedPassword = toSHA1(password.getBytes());
			preparedStatement.setString(2, cryptedPassword);
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
	public void update(User user) throws SQLException {
		
		String updateSql = "UPDATE " +AccountModelDS.TABLE_NAME + " SET password=? WHERE id=?"; //MOD SPAZI IN QUERY
		
		try{
			connection = ds.getConnection();
			preparedStatement =	connection.prepareStatement(updateSql);
			String password = user.getPassword();  //MOD
			String cryptedPassword = toSHA1(password.getBytes()); //MOD
			System.out.println(cryptedPassword);
			preparedStatement.setString(1,cryptedPassword); // MOD
			preparedStatement.setInt(2, user.getId());
			preparedStatement.executeUpdate();
			connection.commit();
		}catch(SQLException e){
			//e.printStackTrace(); per debug
			return;
		}
		finally
		{
			if (preparedStatement != null)  preparedStatement.close(); //MOD
			if (connection != null) 		connection.close();			
		}
		
	}

	@Override
	public void remove(int id) throws SQLException {
		 try{
			  connection=ds.getConnection();
			  String removeSql="DELETE FROM "+AccountModelDS.TABLE_NAME+" WHERE ID = ?";
			  preparedStatement=connection.prepareStatement(removeSql); 
			  preparedStatement.setInt(1, id);
			  preparedStatement.executeUpdate();
			  connection.commit();
		 }
		 catch(SQLException e){
			 //e.printStackTrace();
			 return;
		 }
		 finally {
			try {
				if (preparedStatement != null) preparedStatement.close();
			 } 
			finally {
				 if (connection != null) connection.close();
			 }
		 }
		
	}

	@Override
	public User findByKey(int id) throws SQLException {
		User bean = new User(null,null,null);
		 String selectSQL = "SELECT * FROM " + 
				 		AccountModelDS.TABLE_NAME + " WHERE ID = ?";
		 try {
			 connection = ds.getConnection();
			 preparedStatement = connection.prepareStatement(selectSQL);
			 preparedStatement.setInt(1, id);
			 ResultSet rs = preparedStatement.executeQuery();
			 while (rs.next()) 
			 {
				 bean.setId(rs.getInt("id"));
				 bean.setEmail(rs.getString("email"));
				 bean.setPassword(rs.getString("password"));
			 }
		 } finally {
			 
			 try {
				if (preparedStatement != null) preparedStatement.close();
			 } finally {
				 if (connection != null) connection.close();
			 }
		 }
		 return bean;
	}

	@Override
	public LinkedList<User> findAll() throws SQLException {
		try{
			LinkedList<User> toReturn = new LinkedList<User>();
			connection=ds.getConnection();
			
			String sql = "SELECT * FROM " + AccountModelDS.TABLE_NAME + ";";
			
			preparedStatement=connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				User user = new User(null,null,null);
				user.setId(rs.getInt(1));
				user.setEmail(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setSecondKey(rs.getString(4));
				toReturn.add(user);
			}
			
			return toReturn;
		}
		catch(SQLException e)
		{
			return null;
		}
		finally {
				try {
					if (preparedStatement != null) preparedStatement.close();
				 } 
				finally {
					 if (connection != null) connection.close();
				 }
		}
		 
	}

	
	public User findByName(String name) throws SQLException {
		
		try{
			connection=ds.getConnection();
			
			String sql="SELECT * FROM " + AccountModelDS.TABLE_NAME + " WHERE EMAIL = ?";
			
			
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			ResultSet rs = preparedStatement.executeQuery();
			User user = new User(null,null,null);
			if(rs.next()){
				user.setId(rs.getInt(1));
				user.setEmail(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setSecondKey(rs.getString(4));
				return user;
			}
			else{
				return null;
			}
		}
		catch(SQLException e){
			return null;
		}
		finally {
				try {
					if (preparedStatement != null) preparedStatement.close();
				 } 
				finally {
					 if (connection != null) connection.close();
				 }
		}
	}
	
	
	
	private static String toSHA1(byte[] convertMe) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-1");
		}
		catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		} 
		return new String(md.digest(convertMe));
	}

	
	
}
