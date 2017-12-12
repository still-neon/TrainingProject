package by.stn.callslogproject;

import java.sql.SQLException;
import java.util.Set;

public interface PersonDao {
    Person getPersonById(int id) throws Exception;

    Set<Person> getAllPerson() throws Exception;
}