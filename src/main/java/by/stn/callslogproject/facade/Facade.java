package by.stn.callslogproject.facade;

import by.stn.callslogproject.callslog.CallsLogEntry;
import by.stn.callslogproject.callslog.CallsLogService;
import by.stn.callslogproject.converter.Converter;
import by.stn.callslogproject.personsinfo.PersonsInfo;
import by.stn.callslogproject.personsinfo.PersonsService;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

public class Facade {
	@Setter
	private CallsLogService callsLogService;
	@Setter
	private PersonsService personsService;
	@Setter
	private Converter converter;

	public void save(Object[][] data) {
		callsLogService.save(converter.getStoredData(data));
	}

	public Object[][] getTableData() {
		try {
			return converter.getDisplayedData(callsLogService.getCallsLogEntries());//TODO:эксепшен на фасаде, вернемся к теме
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<CallsLogEntry.CallType> getCallTypes() {
		return Arrays.asList(callsLogService.getCALL_TYPES());
	}

	public List<PersonsInfo> getPersonsInfo() {
		return personsService.getPersonsInfo();
	}
}