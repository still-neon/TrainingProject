package by.stn.java_exercises.modul_3.ex_7.receiver;

import by.stn.java_exercises.modul_3.ex_7.Entity;
import by.stn.java_exercises.modul_3.ex_7.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(tableName = "receivers", columnsNames = {"receiver"})
public class ReceiverInfo extends AbstractEntity {
	private String receiver;

	ReceiverInfo(long num) {
		super(num);
	}
}