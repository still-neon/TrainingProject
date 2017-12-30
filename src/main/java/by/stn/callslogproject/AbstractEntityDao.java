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
    private static final String UPDATE_ENTITY_QUERY_FORMAT = "UPDATE %s SET %s WHERE id=%d";
    private static final String INSERT_ENTITY_QUERY_FORMAT = "INSERT INTO %s (%s) VALUES (%s)";

    protected abstract String getTableName();

    protected abstract String[] getColumnsNames();

    protected abstract T toEntity(ResultSet rs) throws SQLException;

    protected abstract void setParametersForQuery(PreparedStatement query, T entity) throws SQLException;

    protected abstract String getParametersForQuery(T entity) throws SQLException;

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
        Long id = entity.getId();//проверка на null
        String namedQuery;
        PreparedStatement pstm;
        if (id == null) {
            namedQuery = getNamedQueryForInsert();
            pstm = ConnectionFactory.getConnection().prepareStatement(namedQuery);
            getParametersForQuery(entity);
            getResultSet(String.format(INSERT_ENTITY_QUERY_FORMAT, getTableName(), namedQuery, pstm, id));
        } else {
            namedQuery = getNamedQueryForUpdate();
            pstm = ConnectionFactory.getConnection().prepareStatement(namedQuery);//нужно кидать полноценный запрос с вопросами
            //закрывать connection try(resources) vs finally
            setParametersForQuery(pstm, entity);
            getResultSet(String.format(UPDATE_ENTITY_QUERY_FORMAT, getTableName(), pstm, id));
        }
        return getResultSet(GET_ENTITY_QUERY_FORMAT, id).getInt(1);
        // TODO
    }

    @Override
    public boolean delete(long id) throws Exception {
        return getResultSet(DELETE_ENTITY_QUERY_FORMAT, id).getInt(1) > 0;
    }

    private ResultSet getResultSet(String query, long... id) throws Exception {
        Statement stm = ConnectionFactory.getConnection().createStatement();
        if (id.length > 0) return stm.executeQuery(String.format(query, getTableName(), id[0]));
        else return stm.executeQuery(String.format(query, getTableName()));
    }

    private Set<T> toEntities(ResultSet rs) throws Exception {
        Set<T> result = new HashSet<T>();
        while (rs.next()) {
            T ent = toEntity(rs);
            result.add(ent);
        }
        return result;
    }

    private String getNamedQueryForUpdate() {
        StringBuilder sb = new StringBuilder();
        for (String str : getColumnsNames()) {
            sb.append(str).append("=?,");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    private String getNamedQueryForInsert() {
        StringBuilder sb = new StringBuilder();
        for (String str : getColumnsNames()) {
            sb.append(str).append(",");
        }
        String.format(UPDATE_ENTITY_QUERY_FORMAT, getTableName(), sb.deleteCharAt(sb.length() - 1).toString(), ?)
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
    protected getPreparedStatement(String namedQuery) {
        //доделать этот метод
    }
}