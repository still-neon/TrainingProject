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
	private final Class<T> type;

	public AbstractEntityDao(Class<T> type) {
		this.type = type;
	}

	protected abstract T getEntityFromResultSet(ResultSet resultSet) throws SQLException;

	protected abstract void setUpdateQueryArguments(PreparedStatement preparedStatement, T entity) throws SQLException;

	protected abstract void setInsertQueryArguments(PreparedStatement preparedStatement, T entity) throws SQLException;

	@Override
	public T get(long id) throws SQLException {
		ResultSet resultSet = getResultSet(String.format(GET_ENTITY_QUERY_FORMAT, getTableName(), id));
		return resultSet.next() ? getEntityFromResultSet(resultSet) : null;
	}

	@Override
	public List<T> getAll() throws SQLException {
		return getEntitiesFromResultSet(getResultSet(String.format(GET_ALL_QUERY_FORMAT, getTableName())));
	}

	@Override
	public long saveOrUpdate(T entity) throws SQLException {
		try (Connection connection = ConnectionFactory.getConnection()) {
			if (isNewRecord(entity)) {
				save(connection.prepareStatement(getPreparedQueryForInsert()), entity);
			} else {
				update(connection.prepareStatement(getPreparedQueryForUpdate()), entity);
			}
		}
		return entity.getId();
	}

	@Override
	public boolean delete(long id) throws SQLException {
		int result;
		try (Connection connection = ConnectionFactory.getConnection()) {
			Statement statement = connection.createStatement();
			result = statement.executeUpdate(String.format(DELETE_ENTITY_QUERY_FORMAT, getTableName(), id));
		}
		return result != 0;
	}

	private String getTableName() {
		return type.getAnnotation(Entity.class).tableName();
	}

	private String[] getColumnsNames() {
		return type.getAnnotation(Entity.class).columnsNames();
	}

	private ResultSet getResultSet(String query) throws SQLException {
		ResultSet resultSet;
		try (Connection connection = ConnectionFactory.getConnection()) {
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
		}
		return resultSet;
	}

	private List<T> getEntitiesFromResultSet(ResultSet resultSet) throws SQLException {
		List<T> entities = new ArrayList<>();
		while (resultSet.next()) {
			T entity = getEntityFromResultSet(resultSet);
			entities.add(entity);
		}
		return entities;
	}

	private String getPreparedQueryForUpdate() {
		StringBuilder querySetPart = new StringBuilder();
		for (String columnName : getColumnsNames()) {
			querySetPart.append(columnName).append(PREPARED_QUERY_PARAMETER_FOR_UPDATE);
		}
		return String.format(UPDATE_ENTITY_QUERY_FORMAT, getTableName(), getCorrectQueryPart(querySetPart));
	}

	private String getPreparedQueryForInsert() {
		StringBuilder columns = new StringBuilder();
		StringBuilder parameters = new StringBuilder();
		for (String columnName : getColumnsNames()) {
			columns.append(columnName).append(PREPARED_QUERY_COLUMN_SEPARATOR_SIGN);
			parameters.append(PREPARED_QUERY_PARAMETER_PLACE);
		}
		return String.format(INSERT_ENTITY_QUERY_FORMAT, getTableName(), getCorrectQueryPart(columns), getCorrectQueryPart(parameters));
	}

	private String getCorrectQueryPart(StringBuilder querySetPart) {
		querySetPart.deleteCharAt(querySetPart.length() - 1);
		return querySetPart.toString();
	}

	private boolean isNewRecord(T entity) {
		return entity.getId() == null;
	}

	private void save(PreparedStatement preparedStatement, T entity) throws SQLException {
		setInsertQueryArguments(preparedStatement, entity);
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		entity.setId(resultSet.getLong(1));
	}

	private void update(PreparedStatement preparedStatement, T entity) throws SQLException {
		setUpdateQueryArguments(preparedStatement, entity);
		preparedStatement.executeUpdate();
	}
}