package by.stn.callslogproject;

import org.postgresql.jdbc2.optional.ConnectionPool;

import java.sql.*;
import java.util.Set;

/**
 * Created by EugenKrasotkin on 12/11/2017.
 */
public abstract class AbstractEntityDao<T extends MyEntity> implements EntityDao<T> {

    private static final String GET_QUERY_FORMAT = "SELECT * FROM %s WHERE id=%s";

    protected abstract String getTableName();
    protected abstract T fromRS(ResultSet rs);

    public T get(long id) throws Exception {
        Connection connection = ConnectionFactory.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(String.format(GET_QUERY_FORMAT, getTableName(), id);
        return rs.next() ? fromRS(rs) : null;
    }

    @Override
    public Set<T> getAll() throws Exception {
        // TODO
        throw new IllegalStateException("Method unimplemented yet!");
    }

    @Override
    public void saveOrUpdate(T entity) throws Exception {
// TODO
        throw new IllegalStateException("Method unimplemented yet!");
    }

    @Override
    public boolean delete(long id) throws Exception {
        // TODO
        throw new IllegalStateException("Method unimplemented yet!");
    }
}