package by.stn.callslogproject;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by EugenKrasotkin on 12/12/2017.
 */
public class PersonDao extends AbstractEntityDao<Person> {
    private static final String PERSON_TABLE_NAME = "person";

    @Override
    protected String getTableName() {
        return PERSON_TABLE_NAME;
    }

    @Override
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