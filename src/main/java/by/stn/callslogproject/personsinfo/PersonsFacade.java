package by.stn.callslogproject.personsinfo;

import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class PersonsFacade {
	@Setter
	private PersonsService personsService;

	public List<String> getPersonsNames() {
		List<String> personsNames = new ArrayList<>();
		for (PersonsInfo personsInfo : personsService.getPersonsInfo()) {
			personsNames.add(personsInfo.getFullName());
		}
		return personsNames;
	}
}
