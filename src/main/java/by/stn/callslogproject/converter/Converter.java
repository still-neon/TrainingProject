package by.stn.callslogproject.converter;

import by.stn.callslogproject.callslog.CallsLogEntry;
import by.stn.callslogproject.personsinfo.PersonsService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Converter {
	public List<CallsLogEntry> getStoredData(Object[][] data, PersonsService personsService) {
		List<CallsLogEntry> entities = new ArrayList<>();

		for (Object[] entity : data) {
			CallsLogEntry callsLogEntry = new CallsLogEntry((Long) entity[7]);
			callsLogEntry.setCallType((CallsLogEntry.CallType) entity[0]);
			try {
				callsLogEntry.setCaller(personsService.getPerson((Long) entity[2]));
				callsLogEntry.setAddressee(personsService.getPerson((Long) entity[4]));
			} catch (Exception e) {
				e.printStackTrace();
			}

			callsLogEntry.setStartDate((Date) entity[3]);
			callsLogEntry.setEndDate((Date) entity[4]);
			entities.add(callsLogEntry);
		}
		return entities;
	}

	public Object[][] getDisplayedData(List<CallsLogEntry> callsLogEntries) {
		Object[][] tableData = new Object[callsLogEntries.size()][7];

		for (CallsLogEntry callsLogEntry : callsLogEntries) {
			tableData[callsLogEntries.indexOf(callsLogEntry)] = new Object[]{callsLogEntry.getCallType().name(), callsLogEntry.getCaller().getFullName(), callsLogEntry.getCaller().getId(), callsLogEntry.getAddressee().getFullName(), callsLogEntry.getAddressee().getId(), callsLogEntry.getStartDate(), callsLogEntry.getEndDate(), callsLogEntry.getId()};
		}
		return tableData;
	}
}