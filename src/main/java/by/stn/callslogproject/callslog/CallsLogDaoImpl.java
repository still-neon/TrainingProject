package by.stn.callslogproject.callslog;

import by.stn.callslogproject.entity.AbstractEntityDao;
import by.stn.callslogproject.personsinfo.PersonsDao;
import lombok.Setter;

import java.sql.*;

/**
 * Created by EugenKrasotkin on 12/12/2017.
 */

public class CallsLogDaoImpl extends AbstractEntityDao<CallsLogEntry> implements CallsLogDao {
    @Setter
    private PersonsDao personsDao;

    public CallsLogDaoImpl() throws ClassNotFoundException {
        super((Class<CallsLogEntry>) Class.forName(CallsLogEntry.class.getName()));
    }

    @Override
    protected CallsLogEntry toEntity(ResultSet rs) throws Exception {
        CallsLogEntry callsLog = new CallsLogEntry((long) rs.getInt("id"));
        callsLog.setCallType(rs.getInt("calltype"));
        callsLog.setCaller(personsDao.get(rs.getInt("callerid")));
        callsLog.setAddressee(personsDao.get(rs.getInt("addresseeid")));
        callsLog.setEndDate(rs.getDate("startdate"));
        callsLog.setStartDate(rs.getDate("enddate"));
        return callsLog;
    }

    @Override
    protected void setUpdateQueryArguments(PreparedStatement query, CallsLogEntry entity) throws SQLException {
        setInsertQueryArguments(query, entity);
        query.setLong(6, entity.getId());
    }

    @Override
    protected void setInsertQueryArguments(PreparedStatement query, CallsLogEntry entity) throws SQLException {
        query.setInt(1, entity.getCallType().getId());
        query.setLong(2, entity.getCaller().getId());
        query.setLong(3, entity.getAddressee().getId());
        query.setDate(4, (Date) entity.getStartDate());
        query.setDate(5, (Date) entity.getStartDate());
    }
}