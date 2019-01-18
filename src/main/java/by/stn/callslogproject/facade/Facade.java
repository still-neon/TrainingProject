package by.stn.callslogproject.facade;

import by.stn.callslogproject.callslog.CallsLogEntry;
import by.stn.callslogproject.callslog.CallsLogService;
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

	public Object[][] getTableData() {//TODO передавать объект интерфейса в котором логика трансформации колс логов в массив
		try {
			return getUIData(callsLogService.getCallsLogEntries());//TODO:эксепшен на фасаде, вернемся к теме
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	private Object[][] getUIData(List<CallsLogEntry> callsLogEntries) {//
		Object[][] tableData = new Object[callsLogEntries.size()][7];

		for (CallsLogEntry callsLogEntry : callsLogEntries) {//TODO: логика в объекте чтобы не знал про таблицу или конвертацию в отдельном классе конвертер (в одном слое) те только фасад
			tableData[callsLogEntries.indexOf(callsLogEntry)] = new Object[]{callsLogEntry.getCallType(), callsLogEntry.getCaller().getFullName(), callsLogEntry.getCaller().getId(), callsLogEntry.getAddressee().getFullName(), callsLogEntry.getAddressee().getId(), callsLogEntry.getStartDate(), callsLogEntry.getEndDate(), callsLogEntry.getId()};
		}
		return tableData;
	}
}