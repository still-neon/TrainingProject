package by.stn.callslogproject.personsinfo;

import lombok.Getter;

public class PersonInfoDto {
	@Getter
	private Long id;
	private String fullName;

	public PersonInfoDto(PersonInfo personInfo) {
		this.id = personInfo.getId();
		this.fullName = personInfo.getFullName();
	}

	public PersonInfo getPersonInfo() {
		PersonInfo personInfo = new PersonInfo(id);
		personInfo.setFullName(fullName);
		return personInfo;
	}

	@Override
	public String toString() {
		return fullName;
	}
}