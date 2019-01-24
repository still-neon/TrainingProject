package by.stn.callslogproject.converter;

import by.stn.callslogproject.callslog.CallsLogEntry;
import by.stn.callslogproject.callslog.CallsLogTableManager;
import by.stn.callslogproject.personsinfo.PersonsService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Converter {
	public List<CallsLogEntry> getStoredData(Object[][] data, PersonsService personsService) {
		List<CallsLogEntry> entities = new ArrayList<>();

		for (Object[] entity : data) {
			CallsLogEntry callsLogEntry = new CallsLogEntry((Long) entity[CallsLogTableManager.TableColumns.ID.getIndex()]);
			callsLogEntry.setCallType(CallsLogEntry.CallType.valueOf((String) entity[CallsLogTableManager.TableColumns.CALL_TYPE.getIndex()]));
			try {
				callsLogEntry.setCaller(personsService.getPerson((Long) entity[CallsLogTableManager.TableColumns.CALLER_ID.getIndex()]));
				callsLogEntry.setAddressee(personsService.getPerson((Long) entity[CallsLogTableManager.TableColumns.ADDRESSEE_ID.getIndex()]));
			} catch (Exception e) {
				e.printStackTrace();
			}

			callsLogEntry.setStartDate((Date) entity[CallsLogTableManager.TableColumns.START_DATE.getIndex()]);
			callsLogEntry.setEndDate((Date) entity[CallsLogTableManager.TableColumns.END_DATE.getIndex()]);
			entities.add(callsLogEntry);
		}
		return entities;
	}

	public Object[][] getDisplayedData(List<CallsLogEntry> callsLogEntries) {
		Object[][] tableData = new Object[callsLogEntries.size()][CallsLogTableManager.TableColumns.values().length];

		for (CallsLogEntry callsLogEntry : callsLogEntries) {
			tableData[callsLogEntries.indexOf(callsLogEntry)] = new Object[]{callsLogEntry.getCallType().name(), callsLogEntry.getCaller().getFullName(), callsLogEntry.getCaller().getId(), callsLogEntry.getAddressee().getFullName(), callsLogEntry.getAddressee().getId(), callsLogEntry.getStartDate(), callsLogEntry.getEndDate(), callsLogEntry.getId()};
		}
		return tableData;
	}
}