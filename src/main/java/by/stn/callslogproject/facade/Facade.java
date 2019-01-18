package by.stn.callslogproject.facade;

import by.stn.callslogproject.callslog.CallsLogEntry;
import by.stn.callslogproject.callslog.CallsLogService;
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


}