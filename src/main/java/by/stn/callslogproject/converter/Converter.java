package by.stn.callslogproject.converter;

import by.stn.callslogproject.callslog.CallsLogColumnsConfigurator;
import by.stn.callslogproject.callslog.CallsLogEntry;
import by.stn.callslogproject.personsinfo.PersonInfo;
import by.stn.callslogproject.personsinfo.PersonInfoDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Converter {
	public List<CallsLogEntry> getDataToUpdate(Object[][] data) {
		List<CallsLogEntry> entities = new ArrayList<>();

		for (Object[] entity : data) {
			CallsLogEntry callsLogEntry = new CallsLogEntry((Long) entity[CallsLogColumnsConfigurator.CallsLogColumns.ID.getId()]);
			callsLogEntry.setCallType((CallsLogEntry.CallType) entity[CallsLogColumnsConfigurator.CallsLogColumns.CALL_TYPE.getId()]);
			callsLogEntry.setCaller(((PersonInfoDto) entity[CallsLogColumnsConfigurator.CallsLogColumns.CALLER.getId()]).getPersonInfo());
			callsLogEntry.setAddressee(((PersonInfoDto) entity[CallsLogColumnsConfigurator.CallsLogColumns.ADDRESSEE.getId()]).getPersonInfo());
			callsLogEntry.setStartDate((Date) entity[CallsLogColumnsConfigurator.CallsLogColumns.START_DATE.getId()]);
			callsLogEntry.setEndDate((Date) entity[CallsLogColumnsConfigurator.CallsLogColumns.END_DATE.getId()]);
			entities.add(callsLogEntry);
		}
		return entities;
	}

	public Object[][] getDataToDisplay(List<CallsLogEntry> callsLogEntries) {
		int recordsAmount = callsLogEntries.size();
		int columnsAmount = CallsLogColumnsConfigurator.getColumnsNames().length;

		Object[][] convertedData = new Object[recordsAmount][columnsAmount];

		for (CallsLogEntry callsLogEntry : callsLogEntries) {
			int recordNumber = callsLogEntries.indexOf(callsLogEntry);
			convertedData[recordNumber] = new Object[]{callsLogEntry.getCallType(), getPersonInfoDto(callsLogEntry.getCaller()),
					getPersonInfoDto(callsLogEntry.getAddressee()), callsLogEntry.getStartDate(), callsLogEntry.getEndDate(), callsLogEntry.getId()};
		}
		return convertedData;
	}

	public PersonInfoDto getPersonInfoDto(PersonInfo personInfo) {
		return new PersonInfoDto(personInfo);
	}
}