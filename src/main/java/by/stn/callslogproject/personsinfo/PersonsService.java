package by.stn.callslogproject.personsinfo;

import lombok.Setter;

import java.util.List;

public class PersonsService {
	@Setter
	private PersonsDao personsDao;

	public List<PersonsInfo> getPersonsInfo() {
		List<PersonsInfo> personsInfo = null;
		try {
			personsInfo = personsDao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return personsInfo;
	}
}
