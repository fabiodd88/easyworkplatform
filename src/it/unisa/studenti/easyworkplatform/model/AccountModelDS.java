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

public class AccountModelDS implements ModelInterface<User> {

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

	private void prepareStat(User user){
		try{
			preparedStatement.setString(1, user.getTaxCode());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getSurename());
			preparedStatement.setDate(4, (java.sql.Date) user.getBirthdate());
			preparedStatement.setString(5, user.getBirthplace());
			preparedStatement.setString(6, user.getAddress());
			preparedStatement.setString(7, user.getEmail());
			String password = user.getPassword();
			String cryptedPassword = toSHA1(password.getBytes());
			preparedStatement.setString(8, cryptedPassword);
			String secondKey = user.getPassword();
			String cryptedSecondKey = toSHA1(secondKey.getBytes());
			preparedStatement.setString(9, cryptedSecondKey);
			preparedStatement.executeUpdate();
			connection.commit();
		}
		catch(SQLException e){	}
		finally
		{
			try{
				if (preparedStatement != null)  preparedStatement.close();
				if (connection != null) 		connection.close();	
			}
			catch(SQLException e){	}
		}
	}


	@Override
	public void insert(User user) throws SQLException {
		String insertSQL = "INSERT INTO " 
				+ AccountModelDS.TABLE_NAME + " (taxCode, nameUser, sureNameUser, dateOfBirthUser, birthOfPlaceUser, addressUser, emailUser, password, secondaryKey)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		connection = ds.getConnection();
		preparedStatement = connection.prepareStatement(insertSQL);
		prepareStat(user);

	}

	@Override
	public void update(User user) throws SQLException {

		String updateSql = "UPDATE " + AccountModelDS.TABLE_NAME
				+ " SET (taxCode = ?, nameUser = ?, sureNameUser = ?, dateOfBirthUser = ?, birthOfPlaceUser = ?, addressUser = ?, emailUser = ?, password = ?, secondaryKey = ?)"
				+ " WHERE (idUser=?)";


		connection = ds.getConnection();
		preparedStatement = connection.prepareStatement(updateSql);
		prepareStat(user);
	}

	@Override
	public void remove(int id) throws SQLException {
		String removeSql = "DELETE FROM" + AccountModelDS.TABLE_NAME + " WHERE (idUser == ?)";
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(removeSql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null)
				preparedStatement.close();
			if (connection != null)
				connection.close();
		}

	}

	@Override
	public User findByKey(int id) throws SQLException {
		User user = new User();
		String selectSql = "SELECT * FROM " + AccountModelDS.TABLE_NAME + " WHERE (idUser = ?)";
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery(selectSql);
			while (rs.next()) {
				user.setId(id);
				user.setEmail(rs.getString("emailUser"));
				user.setPassword(rs.getString("password"));
				user.setSecondKey(rs.getString("secondaryKey"));
				user.setName(rs.getString("nameUser"));
				user.setSurename(rs.getString("surnameUser"));
				user.setBirthdate(rs.getDate("dateOfBirthUser"));
				user.setBirthplace(rs.getString("birthOfPlace"));
				user.setAddress(rs.getString("addressUser"));
				user.setCity(rs.getString("cityUser"));
				user.setProvince(rs.getString("provinceUser"));
				user.setCap(rs.getInt("capUser"));
				user.setTaxCode(rs.getString("taxCode"));

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
		return user;
	}

	@Override
	public LinkedList<User> findAll() throws SQLException {
		LinkedList<User> listAccount = new LinkedList<User>();
		String selectSql = "SELECT * FROM " + AccountModelDS.TABLE_NAME;
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			ResultSet rs = preparedStatement.executeQuery(selectSql);
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("idUser"));
				user.setEmail(rs.getString("emailUser"));
				user.setPassword(rs.getString("password"));
				user.setSecondKey(rs.getString("secondaryKey"));
				user.setName(rs.getString("nameUser"));
				user.setSurename(rs.getString("surnameUser"));
				user.setBirthdate(rs.getDate("dateOfBirthUser"));
				user.setBirthplace(rs.getString("birthOfPlace"));
				user.setAddress(rs.getString("addressUser"));
				user.setCity(rs.getString("cityUser"));
				user.setProvince(rs.getString("provinceUser"));
				user.setCap(rs.getInt("capUser"));
				user.setTaxCode(rs.getString("taxCode"));
				listAccount.add(user);
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
		return listAccount;
	}

	public User findByEmail(String email) throws SQLException {
		User user = new User();
		String selectSql = "SELECT * FROM " + AccountModelDS.TABLE_NAME + " WHERE (emailUser = ?)";
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			preparedStatement.setString(1, email);
			ResultSet rs = preparedStatement.executeQuery(selectSql);
			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setEmail(email);
				user.setPassword(rs.getString("password"));
				user.setSecondKey(rs.getString("secondaryKey"));
				user.setName(rs.getString("nameUser"));
				user.setSurename(rs.getString("surnameUser"));
				user.setBirthdate(rs.getDate("dateOfBirthUser"));
				user.setBirthplace(rs.getString("birthOfPlace"));
				user.setAddress(rs.getString("addressUser"));
				user.setCity(rs.getString("cityUser"));
				user.setProvince(rs.getString("provinceUser"));
				user.setCap(rs.getInt("capUser"));
				user.setTaxCode(rs.getString("taxCode"));
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
		return user;
	}

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
