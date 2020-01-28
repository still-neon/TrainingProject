package by.stn.java_exercises.modul_3.ex_7.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractEntity implements Entity {
	private Long num;

	public AbstractEntity(long num) {
		this.num = num;
	}
}