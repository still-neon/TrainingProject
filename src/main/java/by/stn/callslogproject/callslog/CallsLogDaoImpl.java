package by.stn.callslogproject.callslog;

import by.stn.callslogproject.entity.AbstractEntityDao;
import by.stn.callslogproject.personsinfo.PersonDao;
import lombok.Setter;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallsLogDaoImpl extends AbstractEntityDao<CallsLogEntry> implements CallsLogDao {
	@Setter
	private PersonDao personDao;

	public CallsLogDaoImpl() throws ClassNotFoundException {
		super((Class<CallsLogEntry>) Class.forName(CallsLogEntry.class.getName()));
	}

	@Override
	protected CallsLogEntry getEntityFromResultSet(ResultSet resultSet) throws SQLException {
		CallsLogEntry callsLogEntry = new CallsLogEntry((long) resultSet.getInt("id"));
		callsLogEntry.setCallType(resultSet.getInt("calltype"));
		callsLogEntry.setCaller(personDao.get(resultSet.getInt("callerid")));
		callsLogEntry.setAddressee(personDao.get(resultSet.getInt("addresseeid")));
		callsLogEntry.setStartDate(resultSet.getDate("startdate"));
		callsLogEntry.setEndDate(resultSet.getDate("enddate"));
		return callsLogEntry;
	}

	@Override
	protected void setUpdateQueryArguments(PreparedStatement preparedStatement, CallsLogEntry callsLogEntry) throws SQLException {
		setInsertQueryArguments(preparedStatement, callsLogEntry);
		preparedStatement.setLong(6, callsLogEntry.getId());
	}

	@Override
	protected void setInsertQueryArguments(PreparedStatement preparedStatement, CallsLogEntry callsLogEntry) throws SQLException {
		preparedStatement.setInt(1, callsLogEntry.getCallType().getId());
		preparedStatement.setLong(2, callsLogEntry.getCaller().getId());
		preparedStatement.setLong(3, callsLogEntry.getAddressee().getId());
		preparedStatement.setDate(4, new Date(callsLogEntry.getStartDate().getTime()));
		preparedStatement.setDate(5, new Date(callsLogEntry.getEndDate().getTime()));
	}
}