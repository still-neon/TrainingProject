package by.stn.data_parser.data_record;

import by.stn.data_parser.entity.AbstractEntity;
import lombok.Getter;

import java.util.Date;

public class DataRecord extends AbstractEntity {
	private final static String BYN_SYMBOL = "Br";
	private final static String USD_SYMBOL = "$";
	private final static String EURO_SYMBOL = "€";
	private final static String UNDEFINED_SYMBOL = "";
	@Getter
	private long id;
	private String name;
	private String value;
	private Currency currency;
	private String description;
	private Date date;
	private String timestamp;

	public DataRecord(long id) {
		super(id);
	}

	public enum Currency {
		BYN(BYN_SYMBOL), USD(USD_SYMBOL), EURO(EURO_SYMBOL), UNDEFINED(UNDEFINED_SYMBOL);

		@Getter
		private String symbol;

		Currency(String symbol) {
			this.symbol = symbol;
		}
	}
}