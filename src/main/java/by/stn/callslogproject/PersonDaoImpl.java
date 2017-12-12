package by.stn.callslogproject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by EugenKrasotkin on 12/12/2017.
 */
public class PersonDaoImpl implements PersonDao {
    public Person getPersonById(int id) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM person WHERE id=" + id);
            if (rs.next()) {
                return extractPersonFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Set<Person> getAllPerson() {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM person");
            Set persons = new HashSet();
            while (rs.next()) {
                Person person = extractPersonFromResultSet(rs);
                persons.add(person);
            }
            return persons;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private Person extractPersonFromResultSet(ResultSet rs) throws SQLException {
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