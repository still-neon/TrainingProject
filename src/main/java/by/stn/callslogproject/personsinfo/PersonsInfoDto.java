package by.stn.callslogproject.personsinfo;

import lombok.Getter;

public class PersonsInfoDto {
	@Getter
	private Long id;
	private String fullName;

	public PersonsInfoDto(PersonsInfo personsInfo) {
		this.id = personsInfo.getId();
		this.fullName = personsInfo.getFullName();
	}

	@Override
	public String toString() {
		return fullName;
	}
}