package by.stn.callslogproject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by EugenKrasotkin on 12/12/2017.
 */
public class CallsLogDaoImpl {
    public CallsLog getCallsLogById(int id) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM callslog WHERE id=" + id);
            if (rs.next()) {
                return extractCallsLogFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Set<CallsLog> getAllCallsLog() {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM callslog");
            Set callsLogs = new HashSet();
            while (rs.next()) {
                CallsLog callsLog = extractCallsLogFromResultSet(rs);
                callsLogs.add(callsLog);
            }
            return callsLogs;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private CallsLog extractCallsLogFromResultSet(ResultSet rs) throws SQLException {
        CallsLog callsLog = new CallsLog();
        callsLog.setId(rs.getInt("id"));
        //callsLog.setCallType(rs.getInt("calltype"));
        callsLog.setCallerId(new PersonDaoImpl().getPersonById(rs.getInt("callerid")));
        callsLog.setAddresseeId(new PersonDaoImpl().getPersonById(rs.getInt("addresseeid")));
        callsLog.setEndDate(rs.getDate("startdate"));
        callsLog.setStartDate(rs.getDate("enddate"));
        return callsLog;
    }
}