package by.stn.callslogproject;

import java.sql.*;


/**
 * Created by EugenKrasotkin on 12/12/2017.
 */
public class CallsLogDaoImpl extends AbstractEntityDao<CallsLogEntry> implements CallsLogDao {
    private static final String CALLSLOGENTRY_TABLE_NAME = "callslog";
    private static final String[] CALLSLOGENTRY_COLUMNS_NAMES = {"calltype", "callerid", "addresseeid", "startdate", "enddate"};

    public String getTableName() {
        return CALLSLOGENTRY_TABLE_NAME;
    }

    public String[] getColumnsNames() {
        return CALLSLOGENTRY_COLUMNS_NAMES;
    }

    @Override
    protected CallsLogEntry toEntity(ResultSet rs) throws SQLException {
        CallsLogEntry callsLog = new CallsLogEntry(rs.getInt("id"));
        callsLog.setCallType(rs.getInt("calltype"));
        callsLog.setCaller(new PersonsInfo(rs.getInt("callerid"))); //нужно засетить настоящих персонов а не создавать новых
        callsLog.setAddressee(new PersonsInfo(rs.getInt("addresseeid"))); //нужно засетить настоящих персонов а не создавать новых
        callsLog.setEndDate(rs.getDate("startdate"));
        callsLog.setStartDate(rs.getDate("enddate"));
        return callsLog;
    }

    @Override
    protected void setParametersForQuery(PreparedStatement query, CallsLogEntry entity) throws SQLException {
        query.setInt(1, entity.getCallType().getId());
        query.setLong(2, entity.getCaller().getId());
        query.setLong(3, entity.getAddressee().getId());
        query.setDate(4, (Date) entity.getStartDate());
        query.setDate(5, (Date) entity.getStartDate());
    }

    @Override
    protected String getParametersForQuery(CallsLogEntry entity) throws SQLException {
        StringBuffer sb = new StringBuffer();
        sb.append(entity.getCallType().getId()).append(entity.getCaller().getId()).append(entity.getAddressee()
                .getId()).append(entity.getStartDate()).append(entity.getStartDate());
        return sb.toString();
    }
}