package by.stn.callslogproject.entity;

import java.sql.SQLException;
import java.util.List;

public interface EntityDao<T extends Entity> {
	T get(long id) throws SQLException;

	List<T> getAll() throws SQLException;

	long saveOrUpdate(T entity) throws SQLException;

	boolean delete(long id) throws SQLException;
}