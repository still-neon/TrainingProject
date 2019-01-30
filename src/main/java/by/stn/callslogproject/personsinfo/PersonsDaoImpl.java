package by.stn.callslogproject.personsinfo;

import by.stn.callslogproject.entity.AbstractEntityDao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonsDaoImpl extends AbstractEntityDao<PersonsInfo> implements PersonsDao {
	public PersonsDaoImpl() throws ClassNotFoundException {
		super((Class<PersonsInfo>) Class.forName(PersonsInfo.class.getName()));
	}

	@Override
	protected PersonsInfo resultSetToEntity(ResultSet rs) throws SQLException {
		PersonsInfo person = new PersonsInfo((long) rs.getInt("id"));
		person.setFullName(rs.getString("fullname"));
		person.setOrganizationName(rs.getString("organizationname"));
		person.setPhone(rs.getString("phone"));
		person.setEmail(rs.getString("email"));
		person.setCreationDate(rs.getDate("creationdate"));
		return person;
	}

	@Override
	protected void setUpdateQueryArguments(PreparedStatement query, PersonsInfo entity) throws SQLException {
		setInsertQueryArguments(query, entity);
		query.setLong(6, entity.getId());
	}

	@Override
	protected void setInsertQueryArguments(PreparedStatement query, PersonsInfo entity) throws SQLException {
		query.setString(1, entity.getFullName());
		query.setString(2, entity.getOrganizationName());
		query.setString(3, entity.getPhone());
		query.setString(4, entity.getEmail());
		query.setDate(5, new Date(entity.getCreationDate().getTime()));
	}
}