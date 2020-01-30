package by.stn.callslogproject.personsinfo;

import by.stn.callslogproject.entity.AbstractEntityDao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDaoImpl extends AbstractEntityDao<PersonInfo> implements PersonDao {

	public PersonDaoImpl() throws ClassNotFoundException {
		super((Class<PersonInfo>) Class.forName(PersonInfo.class.getName()));
	}

	@Override
	protected PersonInfo getEntityFromResultSet(ResultSet resultSet) throws SQLException {
		PersonInfo personInfo = new PersonInfo((long) resultSet.getInt("id"));
		personInfo.setFullName(resultSet.getString("fullname"));
		personInfo.setOrganizationName(resultSet.getString("organizationname"));
		personInfo.setPhone(resultSet.getString("phone"));
		personInfo.setEmail(resultSet.getString("email"));
		personInfo.setCreationDate(resultSet.getDate("creationdate"));
		return personInfo;
	}

	@Override
	protected void setUpdateQueryArguments(PreparedStatement preparedStatement, PersonInfo personInfo) throws SQLException {
		setInsertQueryArguments(preparedStatement, personInfo);
		preparedStatement.setLong(6, personInfo.getId());
	}

	@Override
	protected void setInsertQueryArguments(PreparedStatement preparedStatement, PersonInfo personInfo) throws SQLException {
		preparedStatement.setString(1, personInfo.getFullName());
		preparedStatement.setString(2, personInfo.getOrganizationName());
		preparedStatement.setString(3, personInfo.getPhone());
		preparedStatement.setString(4, personInfo.getEmail());
		preparedStatement.setDate(5, new Date(personInfo.getCreationDate().getTime()));
	}
}