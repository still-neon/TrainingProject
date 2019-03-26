package by.stn.data_parser.parser;

import by.stn.data_parser.tokens.DateToken;
import by.stn.data_parser.tokens.TextNumberPairToken;
import lombok.Getter;

import java.util.Date;

public class DataParserHelper {
	@Getter
	private static final String DATE_FORMAT = "MMMM yyyy";
	private static final String DOLLAR_CURRENCY_SIGN = "$";
	private static final String EMPTY_VALUE = "";
	private static final String INVALID_NUMBER_SEPARATOR = ",";
	private static final String VALID_NUMBER_SEPARATOR = ".";

	public TextNumberPairToken createTextNumberPairToken(String text, String number) {
		TextNumberPairToken token = new TextNumberPairToken();

		token.setText(text);

		if (number.contains(DOLLAR_CURRENCY_SIGN)) {
			token.setCurrency(DOLLAR_CURRENCY_SIGN);
			number = number.replace(DOLLAR_CURRENCY_SIGN, EMPTY_VALUE);
		}
		if (number.contains(INVALID_NUMBER_SEPARATOR)) {
			number = number.replace(INVALID_NUMBER_SEPARATOR, VALID_NUMBER_SEPARATOR);
		}
		token.setNumber(Double.valueOf(number));
		return token;
	}

	public DateToken createDateToken(Date date) {
		return new DateToken(date);
	}
}