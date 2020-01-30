package by.stn.callslogproject.callslog;

import lombok.Getter;
import lombok.Setter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CallsLogService {
	@Getter
	private static final CallsLogEntry.CallType[] CALL_TYPES = {CallsLogEntry.CallType.INCOMING, CallsLogEntry.CallType.OUTGOING, CallsLogEntry.CallType.CONFERENCE};
	@Setter
	private CallsLogDao callsLogDao;

	public List<CallsLogEntry> getCallsLogEntries() throws SQLException {
		List<CallsLogEntry> callsLogEntries;

		callsLogEntries = callsLogDao.getAll();

		return callsLogEntries;
	}

	public void update(List<CallsLogEntry> dataToUpdate) throws SQLException {
		List<CallsLogEntry> dbData = callsLogDao.getAll();

		deleteRemovedData(dbData, dataToUpdate);

		saveUpdatedData(dbData, dataToUpdate);
	}

	private void deleteRemovedData(List<CallsLogEntry> dbData, List<CallsLogEntry> dataToUpdate) throws SQLException {
		List<CallsLogEntry> removedData = new ArrayList<>();

		for (CallsLogEntry dbCallsLogEntry : dbData) {
			boolean removed = true;
			for (CallsLogEntry updateCallsLogEntry : dataToUpdate)
				if (dbCallsLogEntry.getId() == updateCallsLogEntry.getId()) {
					removed = false;
					break;
				}
			if (removed) {
				removedData.add(dbCallsLogEntry);
			}
		}

		for (CallsLogEntry callsLogEntry : removedData) {
			callsLogDao.delete(callsLogEntry.getId());
		}
	}

	private void saveUpdatedData(List<CallsLogEntry> dbData, List<CallsLogEntry> dataToUpdate) throws SQLException {
		List<CallsLogEntry> updatedData = new ArrayList<>();

		for (CallsLogEntry callsLogEntry : dataToUpdate) {
			if (!dbData.contains(callsLogEntry)) {
				updatedData.add(callsLogEntry);
			}
		}

		for (CallsLogEntry callsLogEntry : updatedData) {
			callsLogDao.saveOrUpdate(callsLogEntry);
		}
	}
}