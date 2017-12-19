package by.stn.callslogproject;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by EugenKrasotkin on 12/11/2017.
 */
public abstract class AbstractEntityDao<T extends MyEntity> implements EntityDao<T> {
    private static final String GET_ENTITY_QUERY_FORMAT = "SELECT * FROM %s WHERE id=%s";
    private static final String GET_ALL_QUERY_FORMAT = "SELECT * FROM %s";
    private static final String DELETE_ENTITY_QUERY_FORMAT = "DELETE FROM %s WHERE id=%s";
    private static final String UPDATE_ENTITY_QUERY_FORMAT = "UPDATE %s SET column1 = value1, column2 = value2, ...WHERE id=%s";

    protected abstract String getTableName();
    protected abstract T fromRS(ResultSet rs) throws SQLException;

    public T get(long id) throws Exception {
        ResultSet rs = getStatement().executeQuery(String.format(GET_ENTITY_QUERY_FORMAT, getTableName(), id));
        return rs.next() ? fromRS(rs) : null;
    }

    @Override
    public Set<T> getAll() throws Exception {
        // TODO do method without copipaste
        ResultSet rs = getStatement().executeQuery(String.format(GET_ALL_QUERY_FORMAT, getTableName()));
        Set<T> records = new HashSet();

        while (rs.next()) {
            T t = fromRS(rs);
            records.add(t);
        }
        return records;
    }

    @Override
    public void saveOrUpdate(T entity) throws Exception {
        //getStatement().executeQuery(String.format(UPDATE_ENTITY_QUERY_FORMAT, getTableName(), id));
        // TODO
        throw new IllegalStateException("Method unimplemented yet!");
    }

    @Override
    public boolean delete(long id) throws Exception {
        getStatement().executeQuery(String.format(DELETE_ENTITY_QUERY_FORMAT, getTableName(), id));
        return true;
        // TODO
        //throw new IllegalStateException("Method unimplemented yet!");
    }

    @Override
    public Statement getStatement() throws Exception{
        Connection connection = ConnectionFactory.getConnection();
        Statement stmt = connection.createStatement();
        return stmt;
    }
}