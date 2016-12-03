package it.unisa.studenti.easyworkplatform.model;

import java.sql.SQLException;
import java.util.LinkedList;

public interface ModelInterface<A> {
	public void insert(A entity) throws SQLException;
	public void update(A entity) throws SQLException;
	public void remove(int id) throws SQLException;
	public A findByKey(int id) throws SQLException;
	public LinkedList<A> findAll() throws SQLException;
}
