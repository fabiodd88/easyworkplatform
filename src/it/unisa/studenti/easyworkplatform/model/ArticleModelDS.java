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

public class ArticleModelDS implements ModelInterface<Article>{

	private static final String TABLE_NAME = "article";
	private static DataSource ds;
	private static Connection connection;
	private static PreparedStatement preparedStatement;

	//Costruttore ausiliare prima dell'ideazione della Classe Astratta per la connessione a database con nomi diversi
	public ArticleModelDS() {	}

	public ArticleModelDS(String nomeDb) {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			ds = (DataSource) envCtx.lookup("jdbc/"+nomeDb);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}


	private void preparedStat(Article article){
		try {
			preparedStatement.setString(1, article.getName());
			preparedStatement.setDouble(2, article.getPrice());
			preparedStatement.setString(3, article.getDescription());
			preparedStatement.setDate(4, (java.sql.Date)article.getDuration());
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
	public void insert(Article article) throws SQLException {
		String insertSql = "INSERT INTO " + ArticleModelDS.TABLE_NAME
				+ "(article, price, desciption, duration)" + " VALUES (?,?,?,?)";
		connection = ds.getConnection();
		preparedStatement = connection.prepareStatement(insertSql);
		preparedStat(article);

	}

	@Override
	public void update(Article article) throws SQLException {
		String updateSql = "UPDATE " + ArticleModelDS.TABLE_NAME
				+ " SET(article = ?, price = ?, desciption = ?, duration = ?)" 
				+ " WHERE (idArticle == ?)";
		connection = ds.getConnection();
		preparedStatement = connection.prepareStatement(updateSql);
		preparedStat(article);
	}



	@Override
	public void remove(int id) throws SQLException {
		String removeSql = "DELETE FROM" + ArticleModelDS.TABLE_NAME + " WHERE (idArticle == ?)";
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
	public Article findByKey(int id) throws SQLException {
		Article article = new Article();
		String selectSql = "SELECT * FROM " + ArticleModelDS.TABLE_NAME + " WHERE (idArticle == ?)";
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery(selectSql);
			while (rs.next()) {
				article.setIdArticle(id);
				article.setName(rs.getString("name"));
				article.setPrice(rs.getDouble("price"));
				article.setDescription(rs.getString("description"));
				article.setDuration(rs.getDate("duration"));
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
		return article;
	}

	@Override
	public LinkedList<Article> findAll() throws SQLException {
		LinkedList<Article> listArticle = new LinkedList<Article>();
		String selectSql = "SELECT * FROM " + ArticleModelDS.TABLE_NAME;
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			ResultSet rs = preparedStatement.executeQuery(selectSql);
			Article article = new Article();
			while (rs.next()) {
				article.setIdArticle(rs.getInt("idArticle"));
				article.setName(rs.getString("name"));
				article.setPrice(rs.getDouble("price"));
				article.setDescription(rs.getString("description"));
				article.setDuration(rs.getDate("duration"));
				listArticle.add(article);
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
		return listArticle;
	}

}
