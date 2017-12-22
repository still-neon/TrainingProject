package by.stn.callslogproject;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by EugenKrasotkin on 12/11/2017.
 */
public abstract class AbstractEntityDao<T extends Entity> implements EntityDao<T> {
    private static final String GET_ENTITY_QUERY_FORMAT = "SELECT * FROM %s WHERE id=%s";
    private static final String GET_ALL_QUERY_FORMAT = "SELECT * FROM %s";
    private static final String DELETE_ENTITY_QUERY_FORMAT = "DELETE FROM %s WHERE id=%s";
    private static final String UPDATE_ENTITY_QUERY_FORMAT = "UPDATE %s SET column1 = %s, column2 = %s, WHERE id=%s";
    private static final String INSERT_ENTITY_QUERY_FORMAT = "INSERT INTO %s (%s, %s) VALUES (123, 'A description of part 123.')";
    private ResultSet rs;

    protected abstract String getTableName();

    protected abstract T fromRS(ResultSet rs) throws SQLException;

    protected abstract Set<T> fromRS(ResultSet rs, Set<T> records) throws SQLException;

    public T get(long id) throws Exception { //опциональный параметр ...
        rs = getResultSet(GET_ENTITY_QUERY_FORMAT, id);
        return rs.next() ? fromRS(rs) : null;
    }

    @Override
    public Set<T> getAll() throws Exception {
        // TODO do method without copipaste
        return fromRS(getResultSet(GET_ALL_QUERY_FORMAT), new HashSet<T>());
    }

    @Override
    public long saveOrUpdate(T entity) throws Exception {
        long id = entity.getId();
        if (getResultSet(GET_ENTITY_QUERY_FORMAT, id).next()) {
            getResultSet(UPDATE_ENTITY_QUERY_FORMAT, id);
        } else if (!getResultSet(GET_ENTITY_QUERY_FORMAT, id).next()) {
            getResultSet(INSERT_ENTITY_QUERY_FORMAT);
        }
        return id;
        // TODO

    }

    @Override
    public boolean delete(long id) throws Exception {
        getResultSet(DELETE_ENTITY_QUERY_FORMAT, id);
        return !getResultSet(GET_ENTITY_QUERY_FORMAT, id).next();
        // проверять и возвращать тру если удалилось
    }

    public ResultSet getResultSet(String query, long... id) throws Exception {
        Statement stm = ConnectionFactory.getConnection().createStatement();
        return stm.executeQuery(String.format(query, getTableName(), id));
    }
}