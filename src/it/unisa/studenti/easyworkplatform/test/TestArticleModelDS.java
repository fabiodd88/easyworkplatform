package it.unisa.studenti.easyworkplatform.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import it.unisa.studenti.easyworkplatform.model.Article;
import it.unisa.studenti.easyworkplatform.model.ArticleModelDS;
import junit.framework.TestCase;

public class TestArticleModelDS extends TestCase {

	private ArticleModelDS modelDS;
	private Connection connection;
	private static final String TABLE_NAME = "pizzeria_article";

	protected void setUp() throws Exception {
		modelDS = new ArticleModelDS("dbtest","pizzeria_article");
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/dbtest", "root", "");
		connection.setAutoCommit(false);
	}

	protected void tearDown() throws Exception {
		modelDS = null;
		if (null != connection) {
			connection.close();
			connection = null;
		}
	}

	public void testFindAll() throws SQLException, ClassNotFoundException {
		// method to test
		LinkedList<Article> listArticle = modelDS.findAll();

		// database extrapolation
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + "");
		ResultSet rs = ps.executeQuery();
		int size = 0;
		while (rs.next()) {
			Article expected = new Article();
			expected.setId(rs.getInt("id"));
			expected.setName(rs.getString("name"));
			expected.setPrice(rs.getDouble("price"));
			expected.setDescription(rs.getString("description"));
			expected.setDuration(rs.getInt("duration"));
			assertEquals(true, listArticle.get(size).equals(expected));
			size++;
		}

		// compare database result with the method tested
		assertEquals(size, listArticle.size());
	}

	public void testInsert() throws SQLException, ClassNotFoundException {
		// create an instance to be test
		Article article = new Article("name", 0.0, "description", 0);
		modelDS.insert(article); // method to test

		// database extrapolation
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE name = ?");
		ps.setString(1, "name");
		ResultSet rs = ps.executeQuery();
		Article expected = null;
		while (rs.next()) {
			expected = new Article();
			expected.setId(rs.getInt("id"));
			expected.setName(rs.getString("name"));
			expected.setPrice(rs.getDouble("price"));
			expected.setDescription(rs.getString("description"));
			expected.setDuration(rs.getInt("duration"));
		}

		// compare database result with the method tested
		assertNotNull(expected);
		assertNotNull(article);
		assertEquals(expected, article);

		modelDS.remove(expected.getId()); // return to the initial state of the
											// database before test
	}

	public void testFindByKey() throws SQLException, ClassNotFoundException {
		// create an instance to be test
		Article art = new Article("name", 0.0, "description", 0);
		modelDS.insert(art);
		int id = -1;
		LinkedList<Article> list = modelDS.findAll();
		for (Article a : list) {
			if (a.equals(art))
				id = a.getId();
		}

		// method to test
		Article article = modelDS.findByKey(id);

		// database extrapolation
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Article expected = null;
		while (rs.next()) {
			expected = new Article();
			expected.setId(rs.getInt("id"));
			expected.setName(rs.getString("name"));
			expected.setPrice(rs.getDouble("price"));
			expected.setDescription(rs.getString("description"));
			expected.setDuration(rs.getInt("duration"));
		}

		// compare database result with the method tested
		assertNotNull(expected);
		assertNotNull(article);
		assertEquals(expected, article);

		modelDS.remove(expected.getId()); // return to the initial state of the
											// database before test
	}

	public void testFindByField() throws SQLException, ClassNotFoundException {
		// create an instance to be test
		Article act = new Article("name", 0.0, "description", 0);
		modelDS.insert(act);

		// method to test
		LinkedList<Article> listActivity = modelDS.findByField("description", "description");

		// database extrapolation
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE description LIKE ?");
		ps.setString(1, "description"+"%");
		ResultSet rs = ps.executeQuery();
		Article expected = null;
		int index = 0;
		while (rs.next()) {
			expected = new Article();
			expected.setId(rs.getInt("id"));
			expected.setName(rs.getString("name"));
			expected.setPrice(rs.getDouble("price"));
			expected.setDescription(rs.getString("description"));
			expected.setDuration(rs.getInt("duration"));
			assertEquals(true, listActivity.get(index).equals(expected));
			index++;
		}

		modelDS.remove(expected.getId()); // return to the initial state of the
											// database before test
	}

	public void testUpdate() throws SQLException, ClassNotFoundException {
		// create an instance to be test
		Article art = new Article("name", 0.0, "description", 0);
		modelDS.insert(art);
		int id = -1;
		LinkedList<Article> list = modelDS.findAll();
		for (Article a : list) {
			if (a.equals(art))
				id = a.getId();
		}

		Article article = modelDS.findByKey(id);
		article.setName("newName");
		article.setPrice(11.11);
		modelDS.update(article);

		// database extrapolation
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Article expected = null;
		while (rs.next()) {
			expected = new Article();
			expected.setId(rs.getInt("id"));
			expected.setName(rs.getString("name"));
			expected.setPrice(rs.getDouble("price"));
			expected.setDescription(rs.getString("description"));
			expected.setDuration(rs.getInt("duration"));
		}

		// compare database result with the method tested
		assertNotNull(expected);
		assertNotNull(article);
		assertEquals(expected, article);

		modelDS.remove(expected.getId()); // return to the initial state of the
											// database before test
	}

	public void testRemove() throws SQLException, ClassNotFoundException {
		// create an instance to be test
		Article art = new Article("name", 0.0, "description", 0);
		modelDS.insert(art);
		int id = -1;
		LinkedList<Article> list = modelDS.findAll();
		for (Article a : list) {
			if (a.equals(art))
				id = a.getId();
		}
		
		Article article = modelDS.findByKey(id);
		modelDS.remove(article.getId()); // method to test

		// database extrapolation
		PreparedStatement ps = connection.prepareStatement("SELECT count(*) FROM " + TABLE_NAME + " WHERE id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		int expected = 0;
		if (rs.next())
			expected = rs.getInt(1);
		assertEquals(expected, 0);
	}

}
