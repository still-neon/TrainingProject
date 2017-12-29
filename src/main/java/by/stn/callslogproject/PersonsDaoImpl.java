package by.stn.callslogproject;

import java.sql.*;

/**
 * Created by EugenKrasotkin on 12/12/2017.
 */
public class PersonsDaoImpl extends AbstractEntityDao<PersonsInfo> implements PersonsDao {
    private static final String PERSONINFO_TABLE_NAME = "person";
    private static final String[] PERSONINFO_COLUMNS_NAMES = {"fullName", "organizationName", "phone", "email", "creationdate"};

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
        PersonsInfo person = new PersonsInfo(rs.getInt("id"));
        person.setFullName(rs.getString("fullName"));
        person.setOrganizationName(rs.getString("organizationName"));
        person.setPhone(rs.getString("phone"));
        person.setEmail(rs.getString("email"));
        person.setCreationDate(rs.getDate("creationdate"));
        return person;
    }

    @Override
    protected void setParametersForQuery(PreparedStatement query, PersonsInfo entity) throws SQLException {
        query.setString(1,entity.getFullName());
        query.setString(2,entity.getOrganizationName());
        query.setString(3,entity.getPhone());
        query.setString(4, entity.getEmail());
        query.setDate(5, (Date) entity.getCreationDate());
    }
}