package by.stn.callslogproject.converter;

import by.stn.callslogproject.callslog.CallsLogEntry;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Converter {

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

	private Object[][] getUIData(List<CallsLogEntry> callsLogEntries) {//
		Object[][] tableData = new Object[callsLogEntries.size()][7];

		for (CallsLogEntry callsLogEntry : callsLogEntries) {//TODO: логика в объекте чтобы не знал про таблицу или конвертацию в отдельном классе конвертер (в одном слое) те только фасад
			tableData[callsLogEntries.indexOf(callsLogEntry)] = new Object[]{callsLogEntry.getCallType(), callsLogEntry.getCaller().getFullName(), callsLogEntry.getCaller().getId(), callsLogEntry.getAddressee().getFullName(), callsLogEntry.getAddressee().getId(), callsLogEntry.getStartDate(), callsLogEntry.getEndDate(), callsLogEntry.getId()};
		}
		return tableData;
	}
}
