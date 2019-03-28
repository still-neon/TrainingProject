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

	public TextNumberPairToken createTextNumberPairToken(String text, String numberValue) {
		String currency = "";

		if (numberValue.contains(DOLLAR_CURRENCY_SIGN)) {
			currency = DOLLAR_CURRENCY_SIGN;
			numberValue = numberValue.replace(DOLLAR_CURRENCY_SIGN, EMPTY_VALUE);
		}
		if (numberValue.contains(INVALID_NUMBER_SEPARATOR)) {
			numberValue = numberValue.replace(INVALID_NUMBER_SEPARATOR, VALID_NUMBER_SEPARATOR);
		}

		Double number = Double.valueOf(numberValue);
		return new TextNumberPairToken(text, number, currency);
	}

	public DateToken createDateToken(Date date) {
		return new DateToken(date);
	}

	public String getFilePath(String relativeFilePath) {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResource(relativeFilePath).getFile();
	}
}