package by.stn.java_exercises.modul_3.ex_7.expense;

import by.stn.java_exercises.modul_3.ex_7.Entity;
import by.stn.java_exercises.modul_3.ex_7.entity.AbstractEntity;
import by.stn.java_exercises.modul_3.ex_7.receiver.ReceiverInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity(tableName = "expenses", columnsNames = {"paydate", "receiver", "value"})
public class ExpenseEntry extends AbstractEntity {
	private Date paydate;
	private ReceiverInfo receiver;
	private Double value;

	public ExpenseEntry(long num) {
		super(num);
	}
}