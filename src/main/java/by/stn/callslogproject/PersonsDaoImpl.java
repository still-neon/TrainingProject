package by.stn.callslogproject;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by EugenKrasotkin on 12/12/2017.
 */
public class PersonsDaoImpl extends AbstractEntityDao<PersonsInfo> implements PersonsDao {
    private static final String PERSONINFO_TABLE_NAME = "person";
    private static final String[] PERSONINFO_COLUMNS_NAMES = {"id", "fullName", "organizationName", "phone", "email", "creationdate"};

    @Override
    protected String getTableName() {
        return PERSONINFO_TABLE_NAME;
    }

    @Override
    protected String[] getColumnsNames() {
        return PERSONINFO_COLUMNS_NAMES;
    }

    @Override
    protected PersonsInfo toEntity(ResultSet rs) throws SQLException {
        PersonsInfo person = new PersonsInfo(rs.getInt(PERSONINFO_COLUMNS_NAMES[0]));
        person.setFullName(rs.getString(PERSONINFO_COLUMNS_NAMES[1]));
        person.setOrganizationName(rs.getString(PERSONINFO_COLUMNS_NAMES[2]));
        person.setPhone(rs.getString(PERSONINFO_COLUMNS_NAMES[3]));
        person.setEmail(rs.getString(PERSONINFO_COLUMNS_NAMES[4]));
        person.setCreationDate(rs.getDate(PERSONINFO_COLUMNS_NAMES[5]));
        return person;
    }
}