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

	public void save(List<CallsLogEntry> newData) {
		try {
			List<CallsLogEntry> oldData = callsLogDao.getAll();

			for (CallsLogEntry callsLogEntry : getDeletedData(newData, oldData)) {
				callsLogDao.delete(callsLogEntry.getId());
			}

			for (CallsLogEntry callsLogEntry : getUpdatedData(newData, oldData)) {
				callsLogDao.saveOrUpdate(callsLogEntry);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private List<CallsLogEntry> getUpdatedData(List<CallsLogEntry> newData, List<CallsLogEntry> dbData) {
		List<CallsLogEntry> updatedData = new ArrayList<>(newData);

		for (CallsLogEntry callsLogEntry : dbData) {
			if (updatedData.contains(callsLogEntry)) {
				updatedData.remove(callsLogEntry);
			}
		}
		return updatedData;
	}

	private List<CallsLogEntry> getDeletedData(List<CallsLogEntry> newData, List<CallsLogEntry> dbData) {
		List<CallsLogEntry> deletedData = new ArrayList<>();

		for (CallsLogEntry callsLogEntry : dbData) {
			if (isNotPresent(newData, callsLogEntry.getId())) {
				deletedData.add(callsLogEntry);
			}
		}
		return deletedData;
	}

	private boolean isNotPresent(List<CallsLogEntry> newData, long id) {
		for (CallsLogEntry callsLogEntry : newData) {
			if (callsLogEntry.getId() == id)
				return false;
		}
		return true;
	}
}