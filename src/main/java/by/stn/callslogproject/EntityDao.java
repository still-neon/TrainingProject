package by.stn.callslogproject;

import java.util.Set;

public interface EntityDao<T extends MyEntity> {
    T get(long id) throws Exception;

    Set<T> getAll() throws Exception;

    long saveOrUpdate(T entity) throws Exception;

    boolean delete(long id) throws Exception;
}