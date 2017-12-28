package by.stn.callslogproject;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by EugenKrasotkin on 12/11/2017.
 */
public abstract class AbstractEntityDao<T extends Entity> implements EntityDao<T> {
    private static final String GET_ENTITY_QUERY_FORMAT = "SELECT * FROM %s WHERE id=%d";
    private static final String GET_ALL_QUERY_FORMAT = "SELECT * FROM %s";
    private static final String DELETE_ENTITY_QUERY_FORMAT = "DELETE FROM %s WHERE id=%d";
    private static final String UPDATE_ENTITY_QUERY_FORMAT = "UPDATE %s SET %s WHERE id=%d";//получить список колонок из ентит по аналогии с getName
    private static final String INSERT_ENTITY_QUERY_FORMAT = "INSERT INTO %s (%s, %s) VALUES (123, 'A description of part 123.')";

    protected abstract String getTableName();
    protected abstract String[] getColumnsNames();

    protected abstract T toEntity(ResultSet rs) throws SQLException;

    protected abstract void setParametersForQuery(Statement query, T entity);

    public T get(long id) throws Exception {
        ResultSet rs = getResultSet(GET_ENTITY_QUERY_FORMAT, id);
        return rs.next() ? toEntity(rs) : null;
    }

    @Override
    public Set<T> getAll() throws Exception {
        return toEntities(getResultSet(GET_ALL_QUERY_FORMAT));
    }

    @Override
    public long saveOrUpdate(T entity) throws Exception {
        long id = entity.getId();

        if (getResultSet(GET_ENTITY_QUERY_FORMAT, id).getInt(1) > 0) {
            // private
            String namedQuery = getNamedQueryForUpdate();

            setParametersForQuery(namedQuery, entity);

            getResultSet(UPDATE_ENTITY_QUERY_FORMAT, id);
        } else if (getResultSet(GET_ENTITY_QUERY_FORMAT, id).getInt(1) == 0) {
            getResultSet(INSERT_ENTITY_QUERY_FORMAT);
        }
        return id;
        // TODO
    }

    @Override
    public boolean delete(long id) throws Exception {
        return getResultSet(DELETE_ENTITY_QUERY_FORMAT, id).getInt(1) > 0;
    }

    public ResultSet getResultSet(String query, long... id) throws Exception {
        Statement stm = ConnectionFactory.getConnection().createStatement();
        if (id.length > 0) return stm.executeQuery(String.format(query, getTableName(), id[0]));
        else return stm.executeQuery(String.format(query, getTableName()));
    }

    protected Set<T> toEntities(ResultSet rs) throws Exception {
        Set<T> result = new HashSet<T>();
        while (rs.next()) {
            T ent = toEntity(rs);
            result.add(ent);
        }
        return result;
    }
    public String queryBuilder(String query, T entity) throws Exception {
        ResultSet rs = getResultSet(GET_ENTITY_QUERY_FORMAT, entity.getId());
        String temp = "";//Buffer or builder
        for(String str:getColumnsNames()) {
            temp = temp + str + "= ?";
        }



        return "";
    }
}