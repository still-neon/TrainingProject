package by.stn.callslogproject;

import java.util.Set;

public interface CallsLogDao {
    CallsLog getCallsLogById(int id);

    Set<CallsLog> getAllCallsLog();
}