package by.stn.trainingproject.data_parser;

import by.stn.data_parser.parser.CsvDataParser;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CsvDataParserTest {
	private static CsvDataParser dataParser;
	private static DataParserTestHelper dataParserTestHelper;

	@BeforeClass
	public static void crateObject() {
		dataParser = new CsvDataParser();
		dataParserTestHelper = new DataParserTestHelper();
	}

	@Test
	public void checkCsvDataParserNull() {
		try {
			Assert.assertNotNull("Null here!", null);
		} catch (AssertionError er) {
			throw er;
		}
	}

	@Test
	public void checkCsvDataParser() {
//		List<Token> tokens = dataParser.getParsedData(Launcher.getCSV_RELATIVE_FILE_PATH());
//
//		try {
//			dataParserTestHelper.checkDateParsing((DateToken) tokens.get(0), "August 2018");
//			dataParserTestHelper.checkDateParsing((DateToken) tokens.get(4), "September 2018");
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//
//		dataParserTestHelper.checkNumberPairParsing((TextNumberPairToken) tokens.get(1), "любая хрень", 275d, "");
//		dataParserTestHelper.checkNumberPairParsing((TextNumberPairToken) tokens.get(2), "очень хорошо", 646.56, "");
//		dataParserTestHelper.checkNumberPairParsing((TextNumberPairToken) tokens.get(3), "жрачка", 37.33, "");
//		dataParserTestHelper.checkNumberPairParsing((TextNumberPairToken) tokens.get(5), "любая хрень 123", 217.33, "$");
//		dataParserTestHelper.checkNumberPairParsing((TextNumberPairToken) tokens.get(6), "ни о чём", 136d, "$");
//		dataParserTestHelper.checkNumberPairParsing((TextNumberPairToken) tokens.get(7), "жрачка2", 200.15, "$");
	}
}