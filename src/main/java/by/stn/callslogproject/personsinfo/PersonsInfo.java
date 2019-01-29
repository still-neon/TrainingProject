package by.stn.callslogproject.personsinfo;

import by.stn.callslogproject.Entity;
import by.stn.callslogproject.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity(tableName = "person", columnsNames = {"fullname", "organizationname", "phone", "email", "creationdate"})
public class PersonsInfo extends AbstractEntity {
    @Getter
    @Setter
    private String fullName;//TODO: personDTO на ui
    @Getter
    @Setter
    private String organizationName;
    @Getter
    @Setter
    private String phone;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private Date creationDate;

    public PersonsInfo(Long id) {
        super(id);
    }

	@Override
	public String toString() {
		return fullName;
	}
}