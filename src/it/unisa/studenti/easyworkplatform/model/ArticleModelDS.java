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


/**
 * 	ArticleModelDs
 *	Class that interacts with the database through the information of Article
 */
public class ArticleModelDS implements ModelInterface<Article> {

	private static DataSource ds;
	private static final String TABLE_NAME = "pizzeria_article";
	private static Connection connection;
	private static PreparedStatement preparedStatement;

	/**
	 * Empty constructor
	 */
	public ArticleModelDS() {}

	/**
	 * Parametric constructor with the name of the database
	 * @param nomeDb of the database
	 */
	public ArticleModelDS(String nomeDb) {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			ds = (DataSource) envCtx.lookup("jdbc/"+nomeDb);
		}  catch (NamingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see it.unisa.studenti.easyworkplatform.model.ModelInterface#insert(java.lang.Object)
	 */
	@Override
	public void insert(Article article) throws SQLException {
		String insertSql = "INSERT INTO " + ArticleModelDS.TABLE_NAME + "(name, price, description, duration)"
				+ " VALUES (?,?,?,?)";
		try {
			connection=ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSql);
			preparedStatement.setString(1, article.getName());
			preparedStatement.setDouble(2, article.getPrice());
			preparedStatement.setString(3, article.getDescription());
			preparedStatement.setInt(4, article.getDuration());
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
		}
	}

	/**
	 * @see it.unisa.studenti.easyworkplatform.model.ModelInterface#update(java.lang.Object)
	 */
	@Override
	public void update(Article article) throws SQLException {
		String updateSql = "UPDATE " + ArticleModelDS.TABLE_NAME
				+ " SET name = ?, price = ?, description = ?, duration = ?" + " WHERE (id = ?)";
		try {
			connection=ds.getConnection();
			preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setString(1, article.getName());
			preparedStatement.setDouble(2, article.getPrice());
			preparedStatement.setString(3, article.getDescription());
			preparedStatement.setInt(4, article.getDuration());
			preparedStatement.setInt(5, article.getId());
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
		String removeSql = "DELETE FROM " + ArticleModelDS.TABLE_NAME + " WHERE (id = ?)";
		try {
			connection=ds.getConnection();
			preparedStatement = connection.prepareStatement(removeSql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
		}
	}

	/**
	 * @see it.unisa.studenti.easyworkplatform.model.ModelInterface#findByKey(int)
	 */
	@Override
	public Article findByKey(int id) throws SQLException {
		Article article = null;
		String selectSql = "SELECT * FROM " + ArticleModelDS.TABLE_NAME + " WHERE (id = ?)";
		try {
			connection=ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				article = new Article();
				article.setId(id);
				article.setName(rs.getString("name"));
				article.setPrice(rs.getDouble("price"));
				article.setDescription(rs.getString("description"));
				article.setDuration(rs.getInt("duration"));
			}
			connection.commit();
		} catch (SQLException e) {
		}
		return article;
	}

	/** 
	 * Return a list of specific articles
	 * @param attribute of articles
	 * @param toSearch parameter
	 * @return
	 * @throws SQLException
	 */
	public LinkedList<Article> findByField(String attribute, String toSearch) throws SQLException{
		LinkedList<Article> listArticle = new LinkedList<Article>();
		String selectSql = "SELECT * FROM " +ArticleModelDS.TABLE_NAME+" WHERE ("+attribute+" LIKE ?)";
		Article article = new Article();
		try {
			connection=ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			preparedStatement.setString(1, toSearch+"%");
			ResultSet rs =  preparedStatement.executeQuery();
			while (rs.next()) {
				article.setId(rs.getInt("id"));
				article.setName(rs.getString("name"));
				article.setPrice(rs.getDouble("price"));
				article.setDescription(rs.getString("description"));
				article.setDuration(rs.getInt("duration"));
				listArticle.add(article);
			}
		} catch (SQLException e) {
		}
		return listArticle;
	}

	/**
	 * @see it.unisa.studenti.easyworkplatform.model.ModelInterface#findAll()
	 */
	@Override
	public LinkedList<Article> findAll() throws SQLException {
		LinkedList<Article> listArticle = new LinkedList<Article>();
		String selectSql = "SELECT * FROM " + ArticleModelDS.TABLE_NAME+";";
		try {
			connection=ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Article article = new Article();
				article.setId(rs.getInt("id"));
				article.setName(rs.getString("name"));
				article.setPrice(rs.getDouble("price"));
				article.setDescription(rs.getString("description"));
				article.setDuration(rs.getInt("duration"));
				listArticle.add(article);
			}
			connection.commit();
		} catch (SQLException e) {
		}
		return listArticle;
	}

	/**
	 * @see it.unisa.studenti.easyworkplatform.model.ModelInterface#closeConnection()
	 */
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
