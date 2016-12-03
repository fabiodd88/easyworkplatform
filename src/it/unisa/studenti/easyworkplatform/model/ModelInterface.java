package it.unisa.studenti.easyworkplatform.model;

import java.sql.SQLException;

public interface ModelInterface {
	public void insert(Object object)	throws SQLException;
	public void update(Object object)	throws SQLException;
	public void remove(int id)			throws SQLException;
	
}
