package it.unisa.studenti.easyworkplatform.model;

import java.sql.SQLException;
import java.util.LinkedList;

/**
 *	Interface that collects all the common methods
 *
 *	@author AdminEWP 
 */
public interface ModelInterface<A> {
	
	/**
	 * Insert a new instance of entity
	 * @param entity - Entity to insert into the database
	 * @throws SQLException if a database insert error occurs.
	 */
	public void insert(A entity) throws SQLException;
	
	/**
	 * Update an existing entity
	 * @param entity - Entity to update into the database
	 * @throws SQLException if a database update error occurs.
	 */
	public void update(A entity) throws SQLException;
	
	/**
	 * Remove an entity with a specific id
	 * @param id - Entity id
	 * @throws SQLException if a database delete error occurs.
	 */
	public void remove(int id) throws SQLException;
	
	/**
	 * Find an entity by its id
	 * @param id - Entity id
	 * @return entity of type A
	 * @throws SQLException if a database select error occurs.
	 */
	public A findByKey(int id) throws SQLException;
	
	/**
	 * Return a List of all the entity
	 * @return List of entity
	 * @throws SQLException if a database select error occurs.
	 */
	public LinkedList<A> findAll() throws SQLException;
	
	/** Close connection to the database
	 * @throws SQLException if a database error occurs.
	 */
	public void closeConnection() throws SQLException;
}
