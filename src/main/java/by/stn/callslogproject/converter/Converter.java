package by.stn.callslogproject.converter;

import by.stn.callslogproject.callslog.CallsLogColumnsManager;
import by.stn.callslogproject.callslog.CallsLogEntry;
import by.stn.callslogproject.personsinfo.PersonsInfo;
import by.stn.callslogproject.personsinfo.PersonsInfoDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Converter {
	public List<CallsLogEntry> getStoredData(Object[][] data) {
		List<CallsLogEntry> entities = new ArrayList<>();

		for (Object[] entity : data) {
			CallsLogEntry callsLogEntry = new CallsLogEntry((Long) entity[CallsLogColumnsManager.CallsLogColumns.ID.getIndex()]);
			callsLogEntry.setCallType((CallsLogEntry.CallType) entity[CallsLogColumnsManager.CallsLogColumns.CALL_TYPE.getIndex()]);
			try {
				callsLogEntry.setCaller(getPersonsInfo((PersonsInfoDto) entity[CallsLogColumnsManager.CallsLogColumns.CALLER.getIndex()]));
				callsLogEntry.setAddressee(getPersonsInfo((PersonsInfoDto) entity[CallsLogColumnsManager.CallsLogColumns.ADDRESSEE.getIndex()]));
			} catch (Exception e) {
				e.printStackTrace();
			}
			callsLogEntry.setStartDate((Date) entity[CallsLogColumnsManager.CallsLogColumns.START_DATE.getIndex()]);
			callsLogEntry.setEndDate((Date) entity[CallsLogColumnsManager.CallsLogColumns.END_DATE.getIndex()]);
			entities.add(callsLogEntry);
		}
		return entities;
	}

	public Object[][] getDisplayedData(List<CallsLogEntry> callsLogEntries) {
		Object[][] tableData = new Object[callsLogEntries.size()][CallsLogColumnsManager.CallsLogColumns.values().length];

		for (CallsLogEntry callsLogEntry : callsLogEntries) {
			tableData[callsLogEntries.indexOf(callsLogEntry)] = new Object[]{callsLogEntry.getCallType(), getPersonsInfoDto(callsLogEntry.getCaller()), getPersonsInfoDto(callsLogEntry.getAddressee()), callsLogEntry.getStartDate(), callsLogEntry.getEndDate(), callsLogEntry.getId()};
		}
		return tableData;
	}

	public PersonsInfoDto getPersonsInfoDto(PersonsInfo personsInfo) {
		return new PersonsInfoDto(personsInfo);
	}

	private PersonsInfo getPersonsInfo(PersonsInfoDto personsInfoDto) {
		return new PersonsInfo(personsInfoDto.getId());
	}
}