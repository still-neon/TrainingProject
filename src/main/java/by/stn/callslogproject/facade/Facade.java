package by.stn.callslogproject.facade;

import by.stn.callslogproject.callslog.CallsLogEntry;
import by.stn.callslogproject.callslog.CallsLogService;
import by.stn.callslogproject.converter.Converter;
import by.stn.callslogproject.personsinfo.PersonInfo;
import by.stn.callslogproject.personsinfo.PersonInfoDto;
import by.stn.callslogproject.personsinfo.PersonService;
import lombok.Setter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Setter
public class Facade {
	private CallsLogService callsLogService;
	private PersonService personService;
	private Converter converter;

	public void update(Object[][] data) {
		try {
			callsLogService.update(converter.getDataToUpdate(data));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Object[][] getDataToDisplay() {
		try {
			return converter.getDataToDisplay(callsLogService.getCallsLogEntries());//TODO:эксепшен на фасаде, вернемся к теме
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<CallsLogEntry.CallType> getCallTypes() {
		return Arrays.asList(callsLogService.getCALL_TYPES());
	}

	public List<PersonInfoDto> getPersonsInfoDto() {
		List<PersonInfoDto> personsInfoDto = new ArrayList<>();
		for (PersonInfo personInfo : personService.getPersonsInfo()) {
			personsInfoDto.add(converter.getPersonInfoDto(personInfo));
		}
		return personsInfoDto;
	}
}