package by.stn.callslogproject.entity;

import java.util.List;

public interface EntityDao<T extends Entity> {
    T get(long id) throws Exception;

    List<T> getAll() throws Exception;

    long saveOrUpdate(T entity) throws Exception;

    boolean delete(long id) throws Exception;
}