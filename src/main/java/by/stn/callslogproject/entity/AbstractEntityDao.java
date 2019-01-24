package by.stn.callslogproject.entity;

import by.stn.callslogproject.Entity;
import by.stn.callslogproject.connection.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractEntityDao<T extends by.stn.callslogproject.entity.Entity> implements EntityDao<T> {
    private static final String GET_ENTITY_QUERY_FORMAT = "SELECT * FROM %s WHERE id=%d";
    private static final String GET_ALL_QUERY_FORMAT = "SELECT * FROM %s";
    private static final String DELETE_ENTITY_QUERY_FORMAT = "DELETE FROM %s WHERE id=%d";
    private static final String UPDATE_ENTITY_QUERY_FORMAT = "UPDATE %s SET %s WHERE id=?";
    private static final String INSERT_ENTITY_QUERY_FORMAT = "INSERT INTO %s (id,%s) VALUES (DEFAULT,%s) RETURNING id";
    private static final String PREPARED_QUERY_PARAMETER_SIGN = "?";
    private static final String PREPARED_QUERY_EQUAL_SIGN = "=";
    private static final String PREPARED_QUERY_COLUMN_SEPARATOR_SIGN = ",";
    private static final String PREPARED_QUERY_PARAMETER_PLACE = PREPARED_QUERY_PARAMETER_SIGN + PREPARED_QUERY_COLUMN_SEPARATOR_SIGN;
    private static final String PREPARED_QUERY_PARAMETER_FOR_UPDATE = PREPARED_QUERY_EQUAL_SIGN + PREPARED_QUERY_PARAMETER_PLACE;

    protected abstract T resultSetToEntity(ResultSet rs) throws Exception;

    protected abstract void setUpdateQueryArguments(PreparedStatement query, T entity) throws SQLException;

    protected abstract void setInsertQueryArguments(PreparedStatement query, T entity) throws SQLException;

    private final Class<T> type;

    public AbstractEntityDao(Class<T> type) {
        this.type = type;
    }

    @Override
    public T get(long id) throws Exception {
        ResultSet rs = getResultSet(GET_ENTITY_QUERY_FORMAT, id);
        return rs.next() ? resultSetToEntity(rs) : null;
    }

    @Override
    public List<T> getAll() throws Exception {
        return resultSetToEntities(getResultSet(GET_ALL_QUERY_FORMAT));
    }

    @Override
    public long saveOrUpdate(T entity) throws SQLException {
        Long id = entity.getId();
        PreparedStatement pstm;
        try (Connection con = ConnectionFactory.getConnection()) {
            if (id == null) {
                pstm = con.prepareStatement(getPreparedQueryForInsert());
                setInsertQueryArguments(pstm, entity);
                ResultSet rs = pstm.executeQuery();
                rs.next();
                id = rs.getLong(1);
            } else {
                pstm = con.prepareStatement(getPreparedQueryForUpdate());
                setUpdateQueryArguments(pstm, entity);
                pstm.executeUpdate();
            }
        }
        return id;
    }

    @Override
    public boolean delete(long id) throws SQLException {
        int result;
        try (Connection con = ConnectionFactory.getConnection()) {
            result = con.createStatement().executeUpdate(String.format(DELETE_ENTITY_QUERY_FORMAT, getTableName(), id));
        }
        return result > 0;
    }

    private String getTableName() {
        return type.getAnnotation(Entity.class).tableName();
    }

    private String[] getColumnsNames() {
        return type.getAnnotation(Entity.class).columnsNames();
    }

    private ResultSet getResultSet(String query, long... id) throws SQLException {
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

    private List<T> resultSetToEntities(ResultSet rs) throws Exception {
        List<T> result = new ArrayList<T>();
        while (rs.next()) {
            T ent = resultSetToEntity(rs);
            result.add(ent);
        }
        return result;
    }

    private String getPreparedQueryForUpdate() {
        StringBuilder sb = new StringBuilder();
        for (String str : getColumnsNames()) {
            sb.append(str).append(PREPARED_QUERY_PARAMETER_FOR_UPDATE);
        }
        return String.format(UPDATE_ENTITY_QUERY_FORMAT, getTableName(), sb.deleteCharAt(sb.length() - 1).toString());
    }

    private String getPreparedQueryForInsert() {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (String str : getColumnsNames()) {
            sb1.append(str).append(PREPARED_QUERY_COLUMN_SEPARATOR_SIGN);
            sb2.append(PREPARED_QUERY_PARAMETER_PLACE);
        }
        return String.format(INSERT_ENTITY_QUERY_FORMAT, getTableName(), sb1.deleteCharAt(sb1.length() - 1).toString(), sb2.deleteCharAt(sb2.length() - 1).toString());
    }
}