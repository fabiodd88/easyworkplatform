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

public class ServiceModelDS implements ModelInterface<Service>{

	private static final String TABLE_NAME = "service";
	private static DataSource ds;
	private static Connection connection;
	private static PreparedStatement preparedStatement;

	//Costruttore ausiliare prima dell'ideazione della Classe Astratta per la connessione a database con nomi diversi
	public ServiceModelDS() {	}

	public ServiceModelDS(String nomeDb) {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			ds = (DataSource) envCtx.lookup("jdbc/"+nomeDb);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}


	private void preparedStat(Service service){
		try {
			preparedStatement.setString(1, service.getEmployee());
			preparedStatement.setInt(2, service.getQuantity());
			preparedStatement.setString(3, service.getVariation());
			preparedStatement.setString(4, service.getNote());
			preparedStatement.setDate(5, (Date) service.getRecepitDate());
			preparedStatement.setDate(6, (Date) service.getReturnDate());
			preparedStatement.setInt(7, service.getArticleId());
			preparedStatement.setInt(8, service.getCustomerId());
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
	public void insert(Service service) throws SQLException {
		String insertSql = "INSERT INTO " + ServiceModelDS.TABLE_NAME
				+ "(employee, quantity, variation, note, receipt_data, return_date, article_id, customer_id)" + " VALUES (?,?,?,?,?,?,?,?)";
		connection = ds.getConnection();
		preparedStatement = connection.prepareStatement(insertSql);
		preparedStat(service);	

		
	}

	@Override
	public void update(Service payment) throws SQLException {
		String selectSql="UPDATE"+ServiceModelDS.TABLE_NAME+
				"SET (employeee=?, quantity=?, variation=?, note=?," 
				+"receipt_date=?, return_date=?, article_id=?, customer_id=?) WHERE id=?";
		connection = ds.getConnection();
		preparedStatement = connection.prepareStatement(selectSql);
		preparedStat(payment);

		
	}

	@Override
	public void remove(int id) throws SQLException {
		String removeSql = "DELETE FROM" + ServiceModelDS.TABLE_NAME + " WHERE (id == ?)";
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(removeSql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
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
	}

	@Override
	public Service findByKey(int id) throws SQLException {
		String selectSql = "SELECT * FROM " + ServiceModelDS.TABLE_NAME + " WHERE (id == ?)";
		Service service = new Service();
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery(selectSql);
			while (rs.next()) {
				service.setEmployee(rs.getString("employee"));
				service.setQuantity(rs.getInt("quantity"));
				service.setVariation(rs.getString("variation"));
				service.setNote(rs.getString("note"));
				service.setRecepitDate(rs.getDate("receipt_data"));
				service.setReturnDate(rs.getDate("return_date"));
				service.setArticleId(rs.getInt("article_id"));
				service.setCustomerId(rs.getInt("customer_id"));
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
		return service;

	}

	@Override
	public LinkedList<Service> findAll() throws SQLException {
		LinkedList<Service> listService = new LinkedList<Service>();
		String selectSql = "SELECT * FROM " + ServiceModelDS.TABLE_NAME+";";
		Service service = new Service();
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			ResultSet rs = preparedStatement.executeQuery(selectSql);
			while (rs.next()) {
				service.setEmployee(rs.getString("employee"));
				service.setQuantity(rs.getInt("quantity"));
				service.setVariation(rs.getString("variation"));
				service.setNote(rs.getString("note"));
				service.setRecepitDate(rs.getDate("receipt_data"));
				service.setReturnDate(rs.getDate("return_date"));
				service.setArticleId(rs.getInt("article_id"));
				service.setCustomerId(rs.getInt("customer_id"));
				listService.add(service);
			}
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
		return listService;
	}

}
