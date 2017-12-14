package by.stn.callslogproject;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by EugenKrasotkin on 12/12/2017.
 */
public class CallsLogDao extends AbstractEntityDao<CallsLog>  {
    private static final String PERSON_TABLE_NAME = "callslog";
    public String getTableName(){
        return PERSON_TABLE_NAME;
    };

    protected CallsLog fromRS(ResultSet rs) throws SQLException {
        CallsLog callsLog = new CallsLog(rs.getInt("id"));
        //callsLog.setCallType(rs.getInt("calltype"));
        //callsLog.setCallerId(new PersonDao().get(rs.getInt("callerid")));
        //callsLog.setAddresseeId(new PersonDao().getPersonById(rs.getInt("addresseeid")));
        callsLog.setEndDate(rs.getDate("startdate"));
        callsLog.setStartDate(rs.getDate("enddate"));
        return callsLog;
    }
}