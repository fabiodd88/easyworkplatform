package it.unisa.studenti.easyworkplatform.model;

import java.sql.SQLException;
import java.util.LinkedList;

/*	ModelInterface <A>
 *	Interface that collects all the common methods 
 */
public interface ModelInterface<A> {
	public void insert(A entity) throws SQLException;
	public void update(A entity) throws SQLException;
	public void remove(int id) throws SQLException;
	public A findByKey(int id) throws SQLException;
	public LinkedList<A> findAll() throws SQLException;
	public void closeConnection() throws SQLException;
}
