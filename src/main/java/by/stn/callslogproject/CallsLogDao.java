package by.stn.callslogproject;

import java.util.Set;

public interface CallsLogDao {
    CallsLog getCallsLogById(int id) throws Exception;

    Set<CallsLog> getAllCallsLog() throws Exception;
}