package it.unisa.studenti.easyworkplatform.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class ArticleModelDS implements ModelInterface<Article> {

	// private static DataSource ds;
	private static final String TABLE_NAME = "article";
	private static Connection connection;
	private static PreparedStatement preparedStatement;

	// Costruttore ausiliare prima dell'ideazione della Classe Astratta per la
	// connessione a database con nomi diversi
	public ArticleModelDS() {
	}

	public ArticleModelDS(String nomeDb) {
		try {
			// Context initCtx = new InitialContext();
			// Context envCtx = (Context) initCtx.lookup("java:comp/env");
			// ds = (DataSource)
			// initCtx.lookup("jdbc:mysql://localhost/easy_work_platform");

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/easy_work_platform", "root", "");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		// } catch (NamingException e) {
		// e.printStackTrace();
		// }
	}

	@Override
	public void insert(Article article) throws SQLException {
		String insertSql = "INSERT INTO " + ArticleModelDS.TABLE_NAME + "(name, price, desciption, duration)"
				+ " VALUES (?,?,?,?)";
		try {
			connection.setAutoCommit(false);
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

	@Override
	public void update(Article article) throws SQLException {
		String updateSql = "UPDATE " + ArticleModelDS.TABLE_NAME
				+ " SET(name = ?, price = ?, desciption = ?, duration = ?)" + " WHERE (id = ?)";
		try {
			connection.setAutoCommit(false);
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

	@Override
	public void remove(int id) throws SQLException {
		String removeSql = "DELETE FROM " + ArticleModelDS.TABLE_NAME + " WHERE (id = ?)";
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(removeSql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
		}
	}

	@Override
	public Article findByKey(int id) throws SQLException {
		Article article = null;
		String selectSql = "SELECT * FROM " + ArticleModelDS.TABLE_NAME + " WHERE (id = ?)";
		try {
			connection.setAutoCommit(false);
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

	@Override
	public LinkedList<Article> findAll() throws SQLException {
		LinkedList<Article> listArticle = new LinkedList<Article>();
		String selectSql = "SELECT * FROM " + ArticleModelDS.TABLE_NAME;
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(selectSql);
			ResultSet rs = preparedStatement.executeQuery();
			Article article = new Article();
			while (rs.next()) {
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
