package it.unisa.studenti.easyworkplatform.model;

import java.sql.SQLException;
import java.util.LinkedList;

/**
 * 	ModelInterface <A>
 *	Interface that collects all the common methods
 *	@author AdminEWP 
 */
public interface ModelInterface<A> {
	
	/**
	 * Insert a new instance of entity
	 * @param entity
	 * @throws SQLException
	 */
	public void insert(A entity) throws SQLException;
	
	/**
	 * Update an existing entity
	 * @param entity
	 * @throws SQLException
	 */
	public void update(A entity) throws SQLException;
	
	/**
	 * Remove an entity with a specific id
	 * @param id
	 * @throws SQLException
	 */
	public void remove(int id) throws SQLException;
	
	/**
	 * Find an entity by its id
	 * @param id
	 * @return entity A
	 * @throws SQLException
	 */
	public A findByKey(int id) throws SQLException;
	
	/**
	 * Return a List of all the entity
	 * @return List<A>
	 * @throws SQLException
	 */
	public LinkedList<A> findAll() throws SQLException;
	
	/** Close connection to the database
	 * @throws SQLException
	 */
	public void closeConnection() throws SQLException;
}
