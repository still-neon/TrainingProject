package by.stn.java_exercises.modul_3.ex_7.entity;

import java.sql.SQLException;
import java.util.List;

public interface EntityDao<T extends Entity> {
	T get(long num) throws SQLException;

	List<T> getAll() throws SQLException;

	long saveOrUpdate(T entity) throws SQLException;

	boolean delete(long num) throws SQLException;
}