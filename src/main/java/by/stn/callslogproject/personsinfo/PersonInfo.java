package by.stn.callslogproject.personsinfo;

import by.stn.callslogproject.Entity;
import by.stn.callslogproject.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity(tableName = "person", columnsNames = {"fullname", "organizationname", "phone", "email", "creationdate"})
public class PersonInfo extends AbstractEntity {
	private String fullName;
	private String organizationName;
	private String phone;
	private String email;
	private Date creationDate;

	public PersonInfo(Long id) {
		super(id);
	}
}