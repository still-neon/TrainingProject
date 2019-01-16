package by.stn.callslogproject.facade;

import by.stn.callslogproject.callslog.CallsLogEntry;
import by.stn.callslogproject.callslog.CallsLogService;
import by.stn.callslogproject.callslog.CallsLogTableManager;
import by.stn.callslogproject.personsinfo.PersonsInfo;
import by.stn.callslogproject.personsinfo.PersonsService;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Facade {
	@Setter
	private CallsLogService callsLogService;
	@Setter
	private PersonsService personsService;

	public void save(Object[][] data) {
		callsLogService.save(getCallsLogEntries(data));
	}

	public Object[][] getTableData() {
		return getUIData(callsLogService.getCallsLogEntries());
	}

	public List<String> getCallTypes() {
		List<String> callTypes = new ArrayList<>();
		for (CallsLogEntry.CallType callType : callsLogService.getCALL_TYPES()) {
			callTypes.add(callType.name());
		}
		return callTypes;
	}

	public List<String> getPersonsNames() {
		List<String> personsNames = new ArrayList<>();
		for (PersonsInfo personsInfo : personsService.getPersonsInfo()) {
			personsNames.add(personsInfo.getFullName());
		}
		return personsNames;
	}

	private List<CallsLogEntry> getCallsLogEntries(Object[][] data) {//сохранять в фасаде и перекидыва ть в сервис список
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

	private Object[][] getUIData(List<CallsLogEntry> callsLogEntries) {
		Object[][] tableData = new Object[callsLogEntries.size()][CallsLogTableManager.getCOLUMN_NAMES().length];

		for (CallsLogEntry callsLogEntry : callsLogEntries) {
			tableData[callsLogEntries.indexOf(callsLogEntry)] = new Object[]{callsLogEntry.getCallType(), callsLogEntry.getCaller().getFullName(), callsLogEntry.getCaller().getId(), callsLogEntry.getAddressee().getFullName(), callsLogEntry.getAddressee().getId(), callsLogEntry.getStartDate(), callsLogEntry.getEndDate(), callsLogEntry.getId()};
		}
		return tableData;
	}
}