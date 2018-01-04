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
        CallsLogEntry callsLog = new CallsLogEntry((long) rs.getInt("id"));
        callsLog.setCallType(rs.getInt("calltype"));
        try {
            callsLog.setCaller(new PersonsDaoImpl().get(rs.getInt("callerid"))); //нужно засетить настоящих персонов а не создавать новых
            callsLog.setAddressee(new PersonsDaoImpl().get(rs.getInt("addresseeid"))); //нужно засетить настоящих персонов а не создавать новых
        } catch (Exception e) {
            e.printStackTrace();
        }
        callsLog.setEndDate(rs.getDate("startdate"));
        callsLog.setStartDate(rs.getDate("enddate"));
        return callsLog;
    }

    @Override
    protected void setParametersForUpdateQuery(PreparedStatement query, CallsLogEntry entity) throws SQLException {
        query.setInt(1, entity.getCallType().getId());
        query.setLong(2, entity.getCaller().getId());
        query.setLong(3, entity.getAddressee().getId());
        query.setDate(4, (Date) entity.getStartDate());
        query.setDate(5, (Date) entity.getStartDate());
        query.setLong(6, entity.getId());
    }

    @Override
    protected void setParametersForInsertQuery(PreparedStatement query, CallsLogEntry entity) throws SQLException {
        query.setInt(1, entity.getCallType().getId());
        query.setLong(2, entity.getCaller().getId());
        query.setLong(3, entity.getAddressee().getId());
        query.setDate(4, (Date) entity.getStartDate());
        query.setDate(5, (Date) entity.getStartDate());
    }
}