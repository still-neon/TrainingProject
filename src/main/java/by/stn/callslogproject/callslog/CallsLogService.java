package by.stn.callslogproject.callslog;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class CallsLogService {
	@Getter
	private static final CallsLogEntry.CallType[] CALL_TYPES = {CallsLogEntry.CallType.INCOMING, CallsLogEntry.CallType.OUTGOING, CallsLogEntry.CallType.CONFERENCE};
	@Setter
	private CallsLogDao callsLogDao;

	public List<CallsLogEntry> getCallsLogEntries() throws Exception {
		List<CallsLogEntry> callsLogEntries;

		callsLogEntries = callsLogDao.getAll();

		return callsLogEntries;
	}

	public void save(List<CallsLogEntry> updatedData) throws Exception {
		List<CallsLogEntry> dbData = callsLogDao.getAll();

		for (CallsLogEntry callsLogEntry : getDeletedData(updatedData, dbData)) {
			callsLogDao.delete(callsLogEntry.getId());
		}

		for (CallsLogEntry callsLogEntry : getSavedData(updatedData, dbData)) {
			callsLogDao.saveOrUpdate(callsLogEntry);
		}
	}

	private List<CallsLogEntry> getSavedData(List<CallsLogEntry> updatedData, List<CallsLogEntry> dbData) {
		for (CallsLogEntry callsLogEntry : dbData) {
			if (updatedData.contains(callsLogEntry)) {
				updatedData.remove(callsLogEntry);
			}
		}
		return updatedData;
	}

	private List<CallsLogEntry> getDeletedData(List<CallsLogEntry> updatedData, List<CallsLogEntry> dbData) {
		List<CallsLogEntry> deletedData = new ArrayList<>();
		for (CallsLogEntry callsLogEntry : dbData) {
			if (!updatedData.contains(callsLogEntry)) {
				deletedData.add(callsLogEntry);
			}
		}
		return deletedData;
	}
}