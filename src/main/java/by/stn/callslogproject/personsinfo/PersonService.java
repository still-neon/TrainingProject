package by.stn.callslogproject.personsinfo;

import lombok.Setter;

import java.sql.SQLException;
import java.util.List;

@Setter
public class PersonService {
	private PersonDao personDao;

	public List<PersonInfo> getPersonsInfo() {//TODO: эксепшен
		List<PersonInfo> personsInfo = null;
		try {
			personsInfo = personDao.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personsInfo;
	}
}