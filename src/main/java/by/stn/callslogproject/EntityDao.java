package by.stn.callslogproject;

import java.sql.Statement;
import java.util.Set;

public interface EntityDao<T extends MyEntity> {
    T get(long id) throws Exception;

    Set<T> getAll() throws Exception;

    void saveOrUpdate(T entity) throws Exception;

    boolean delete(long id) throws Exception;

    Statement getStatement() throws Exception;
}