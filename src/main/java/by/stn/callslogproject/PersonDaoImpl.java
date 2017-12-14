package by.stn.callslogproject;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by EugenKrasotkin on 12/12/2017.
 */
public class PersonDaoImpl extends AbstractEntityDao<Person> implements PersonsDao {
    private static final String PERSON_TABLE_NAME = "person";

    @Override
    protected String getTableName() {
        return PERSON_TABLE_NAME;
    }

    @Override//переделать метод тк в сете может быть несколько записей
    protected Person fromRS(ResultSet rs) throws SQLException {
        Person person = new Person(rs.getInt("id"));
        person.setName(rs.getString("name"));
        person.setOrganization(rs.getString("organization"));
        person.setPhone(rs.getString("phone"));
        person.setEmail(rs.getString("email"));
        person.setCreationDate(rs.getDate("creationdate"));
        return person;
    }
}