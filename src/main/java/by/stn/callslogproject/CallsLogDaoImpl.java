package by.stn.callslogproject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by EugenKrasotkin on 12/12/2017.
 */
public class CallsLogDaoImpl extends AbstractEntityDao<CallsLogEntry> implements CallsLogDao {
    private static final String CALLSLOGENTRY_TABLE_NAME = "callslog";
    private static final String[] CALLSLOGENTRY_COLUMNS_NAMES = {"id","calltype", "callerid","addresseeid","startdate","enddate"};

    public String getTableName() {
        return CALLSLOGENTRY_TABLE_NAME;
    }

    public String[] getColumnsNames() {
        return CALLSLOGENTRY_COLUMNS_NAMES;
    }


    protected CallsLogEntry toEntity(ResultSet rs) throws SQLException {
        CallsLogEntry callsLog = new CallsLogEntry(rs.getInt(CALLSLOGENTRY_COLUMNS_NAMES[0]));
        callsLog.setCallType(rs.getInt(CALLSLOGENTRY_COLUMNS_NAMES[1]));
        callsLog.setCaller(new PersonsInfo(rs.getInt(CALLSLOGENTRY_COLUMNS_NAMES[2]))); //нужно засетить настоящих персонов а не создавать новых
        callsLog.setAddressee(new PersonsInfo(rs.getInt(CALLSLOGENTRY_COLUMNS_NAMES[3]))); //нужно засетить настоящих персонов а не создавать новых
        callsLog.setEndDate(rs.getDate(CALLSLOGENTRY_COLUMNS_NAMES[4]));
        callsLog.setStartDate(rs.getDate(CALLSLOGENTRY_COLUMNS_NAMES[5]));
        return callsLog;
    }

    void m() throws SQLException {
        String t = "";
        PreparedStatement preparedStatement = ConnectionFactory.getConnection().prepareStatement(t);
        for(String tr: CALLSLOGENTRY_COLUMNS_NAMES) {
            t+= tr + "=" +
        }
    }
}