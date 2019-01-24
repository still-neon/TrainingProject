package by.stn.callslogproject.facade;

import by.stn.callslogproject.callslog.CallsLogEntry;
import by.stn.callslogproject.callslog.CallsLogService;
import by.stn.callslogproject.converter.Converter;
import by.stn.callslogproject.personsinfo.PersonsInfo;
import by.stn.callslogproject.personsinfo.PersonsService;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Facade {
	@Setter
	private CallsLogService callsLogService;
	@Setter
	private PersonsService personsService;
	@Setter
	private Converter converter;

	public void save(Object[][] data) {
		callsLogService.save(converter.getStoredData(data, personsService));
	}

	public Object[][] getTableData() {//TODO передавать объект интерфейса в котором логика трансформации колс логов в массив
		try {
			return converter.getDisplayedData(callsLogService.getCallsLogEntries());//TODO:эксепшен на фасаде, вернемся к теме
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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
}