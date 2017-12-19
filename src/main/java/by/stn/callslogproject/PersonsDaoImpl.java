package by.stn.callslogproject;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by EugenKrasotkin on 12/12/2017.
 */
public class PersonsDaoImpl extends AbstractEntityDao<PersonsInfo> implements PersonsDao {
    private static final String PERSON_TABLE_NAME = "person";

    @Override
    protected String getTableName() {
        return PERSON_TABLE_NAME;
    }

    @Override//переделать метод тк в сете может быть несколько записей
    protected PersonsInfo fromRS(ResultSet rs) throws SQLException {
        PersonsInfo person = new PersonsInfo(rs.getInt("id"));
        person.setFullName(rs.getString("fullName"));
        person.setOrganizationName(rs.getString("organizationName"));
        person.setPhone(rs.getString("phone"));
        person.setEmail(rs.getString("email"));
        person.setCreationDate(rs.getDate("creationdate"));
        return person;
    }
}