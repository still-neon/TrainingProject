package by.stn.trainingproject.data_parser;

import by.stn.data_parser.Launcher;
import by.stn.data_parser.parser.JsonDataParser;
import by.stn.data_parser.tokens.DateToken;
import by.stn.data_parser.tokens.TextNumberPairToken;
import by.stn.data_parser.tokens.Token;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class JsonDataParserTest {
	private static final String ERROR_MESSAGE_TEMPLATE = "Parsed %s value doesn't equal expected %s value. Actual: %s, Expected: %s";
	private static JsonDataParser dataParser;

	@BeforeClass
	public static void crateObject() {
		dataParser = new JsonDataParser();
	}

	@Test
	public void checkJsonDataParser() {
		List<Token> tokens = dataParser.getParsedData(Launcher.getJSON_DATA());

		try {
			checkDateParsing((DateToken) tokens.get(0), "August 2018");
			checkDateParsing((DateToken) tokens.get(4), "September 2018");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		checkNumberPairParsing((TextNumberPairToken) tokens.get(1), "любая, хрень", 275d, "");
		checkNumberPairParsing((TextNumberPairToken) tokens.get(2), "очень хорошо", 646.56, "");
		checkNumberPairParsing((TextNumberPairToken) tokens.get(3), "жрачка", 37.33, "");
		checkNumberPairParsing((TextNumberPairToken) tokens.get(5), "любая хрень 123", 217.33, "$");
		checkNumberPairParsing((TextNumberPairToken) tokens.get(6), "ни о чём,", 136d, "$");
		checkNumberPairParsing((TextNumberPairToken) tokens.get(7), "жрачка2", 200.15, "$");
	}

	private void checkDateParsing(DateToken dateToken, String dateValue) throws ParseException {
		Date date = new SimpleDateFormat(JsonDataParser.getDATE_FORMAT()).parse(dateValue);
		assertTrue(String.format(ERROR_MESSAGE_TEMPLATE, "date", "date", dateToken.getDate(), date), dateToken.getDate().equals(date));
	}

	private void checkNumberPairParsing(TextNumberPairToken textNumberPairToken, String text, Double number, String currency) {
		assertTrue(String.format(ERROR_MESSAGE_TEMPLATE, "text", "text", textNumberPairToken.getText(), text), textNumberPairToken.getText().equals(text));
		assertTrue(String.format(ERROR_MESSAGE_TEMPLATE, "number", "number", textNumberPairToken.getNumber(), number), textNumberPairToken.getNumber().equals(number));
		assertTrue(String.format(ERROR_MESSAGE_TEMPLATE, "currency", "currency", textNumberPairToken.getCurrency(), currency), textNumberPairToken.getCurrency().equals(currency));
	}
}