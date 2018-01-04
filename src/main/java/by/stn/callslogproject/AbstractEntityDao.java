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
    private static final String UPDATE_ENTITY_QUERY_FORMAT = "UPDATE %s SET %s WHERE id=%s";
    private static final String INSERT_ENTITY_QUERY_FORMAT = "INSERT INTO %s (id,%s) VALUES (DEFAULT,%s) RETURNING id";

    protected abstract String getTableName();

    protected abstract String[] getColumnsNames();

    protected abstract T toEntity(ResultSet rs) throws Exception;

    protected abstract void setParametersForUpdateQuery(PreparedStatement query, T entity) throws SQLException;

    protected abstract void setParametersForInsertQuery(PreparedStatement query, T entity) throws SQLException;

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
        PreparedStatement pstm;
        try (Connection con = ConnectionFactory.getConnection()) {
            if (id == null) {
                pstm = con.prepareStatement(getPreparedQueryForInsert());
                setParametersForInsertQuery(pstm, entity);
                ResultSet rs = pstm.executeQuery();
                rs.next();
                id = rs.getLong(1);
            } else {
                pstm = con.prepareStatement(getPreparedQueryForUpdate());//нужно кидать полноценный запрос с вопросами
                setParametersForUpdateQuery(pstm, entity);
                pstm.executeUpdate();
            }
            //закрывать connection try(resources) vs finally
        }
        return id;
        // TODO
    }

    @Override
    public boolean delete(long id) throws Exception {
        int result;
        try (Connection con = ConnectionFactory.getConnection()) {
            result = con.createStatement().executeUpdate(String.format(DELETE_ENTITY_QUERY_FORMAT, getTableName(), id));
        }
        return result > 0;
    }

    private ResultSet getResultSet(String query, long... id) throws Exception {
        ResultSet rs;
        try (Connection con = ConnectionFactory.getConnection()) {
            Statement stm = con.createStatement();
            if (id.length > 0) {
                rs = stm.executeQuery(String.format(query, getTableName(), id[0]));
            } else {
                rs = stm.executeQuery(String.format(query, getTableName()));
            }
        }
        return rs;
    }

    private Set<T> toEntities(ResultSet rs) throws Exception {
        Set<T> result = new HashSet<T>();
        while (rs.next()) {
            T ent = toEntity(rs);
            result.add(ent);
        }
        return result;
    }

    private String getPreparedQueryForUpdate() {
        StringBuilder sb = new StringBuilder();
        for (String str : getColumnsNames()) {
            sb.append(str).append("=?,");
        }
        return String.format(UPDATE_ENTITY_QUERY_FORMAT, getTableName(), sb.deleteCharAt(sb.length() - 1).toString(), "?");
    }

    private String getPreparedQueryForInsert() {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (String str : getColumnsNames()) {
            sb1.append(str).append(",");
            sb2.append("?,");
        }
        return String.format(INSERT_ENTITY_QUERY_FORMAT, getTableName(), sb1.deleteCharAt(sb1.length() - 1).toString(), sb2.deleteCharAt(sb2.length() - 1).toString());
    }

    //private String getPreparedStatement(String namedQuery) {
    //return String.format(UPDATE_ENTITY_QUERY_FORMAT, getTableName(), namedQuery, "?");
    //доделать этот метод
    //}
}