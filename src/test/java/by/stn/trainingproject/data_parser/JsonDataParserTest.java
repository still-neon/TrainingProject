package by.stn.trainingproject.data_parser;

import by.stn.data_parser.Launcher;
import by.stn.data_parser.parser.JsonDataParser;
import by.stn.data_parser.tokens.DateToken;
import by.stn.data_parser.tokens.TextNumberPairToken;
import by.stn.data_parser.tokens.Token;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.ParseException;
import java.util.List;

public class JsonDataParserTest extends DataParserTest {
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
}