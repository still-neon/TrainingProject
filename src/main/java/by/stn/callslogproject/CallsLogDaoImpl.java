package by.stn.callslogproject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

/**
 * Created by EugenKrasotkin on 12/12/2017.
 */
public class CallsLogDaoImpl extends AbstractEntityDao<CallsLogEntry> implements CallsLogDao {
    private static final String PERSON_TABLE_NAME = "callslog";
    public String getTableName(){
        return PERSON_TABLE_NAME;
    };

    protected CallsLogEntry fromRS(ResultSet rs) throws SQLException {
        CallsLogEntry callsLog = new CallsLogEntry(rs.getInt("id"));
        callsLog.setCallType(rs.getInt("calltype"));
        callsLog.setCaller(new PersonsInfo(rs.getInt("callerid"))); //нужно засетить настоящих персонов а не создавать новых
        callsLog.setAddressee(new PersonsInfo(rs.getInt("addresseeid"))); //нужно засетить настоящих персонов а не создавать новых
        callsLog.setEndDate(rs.getDate("startdate"));
        callsLog.setStartDate(rs.getDate("enddate"));
        return callsLog;
    }
    @Override
    protected Set<CallsLogEntry> fromRS(ResultSet rs, Set<CallsLogEntry> records) throws SQLException {
        while (rs.next()) {
            CallsLogEntry callsLog = fromRS(rs);
            records.add(callsLog);
        }
        return records;
    }
}