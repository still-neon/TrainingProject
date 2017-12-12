package by.stn.callslogproject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by EugenKrasotkin on 12/12/2017.
 */
public class PersonDaoImpl extends AbstractEntityDao<Person> implements PersonDao {
    private static final String PERSON_TABLE_NAME = "person";

    @Override
    protected String getTableName() {
        return PERSON_TABLE_NAME;
    }

    public Person getPersonById(int id) throws Exception {
        Connection connection = ConnectionFactory.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM person WHERE id=" + id);
        return rs.next() ? extractPersonFromResultSet(rs) : null;
    }

    public Set<Person> getAllPerson() throws Exception {
        Connection connection = ConnectionFactory.getConnection();

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM person");
        Set persons = new HashSet();
        while (rs.next()) {
            Person person = extractPersonFromResultSet(rs);
            persons.add(person);
        }
        return persons;
    }

    @Override
    protected Person fromRS(ResultSet rs) {
        Person person = new Person();
        person.setId(rs.getInt("id"));
        person.setName(rs.getString("name"));
        person.setOrganization(rs.getString("organization"));
        person.setPhone(rs.getString("phone"));
        person.setEmail(rs.getString("email"));
        person.setCreationDate(rs.getDate("creationdate"));
        return person;
    }

}