package by.stn.data_parser;

import by.stn.data_parser.parser.DataParser;
import by.stn.data_parser.tokens.Token;

import java.util.List;

public class Launcher {
	private static String dataJSON = "[{\n" +
			"    \"date\": \"August 2018\",\n" +
			"    \"pairs\": [\n" +
			"    {\n" +
			"      \"text\": \"любая хрень\",\n" +
			"      \"value\": \"275,33\"\n" +
			"    },\n" +
			"    {\n" +
			"      \"text\": \"очень хорошо\",\n" +
			"      \"value\": \"$646\"\n" +
			"    },\n" +
			"    {\n" +
			"      \"text\": \"жрачка\",\n" +
			"      \"value\": \"37.33\"\n" +
			"    }\n" +
			"    ]\n" +
			"},\n" +
			"{\n" +
			"    \"date\": \"September 2018\",\n" +
			"    \"pairs\": [\n" +
			"    {\n" +
			"      \"text\": \"любая хрень\",\n" +
			"      \"value\": \"217,33\"\n" +
			"    },\n" +
			"    {\n" +
			"      \"text\": \"ни о чём\",\n" +
			"      \"value\": \"$136\"\n" +
			"    },\n" +
			"    {\n" +
			"      \"text\": \"жрачка2\",\n" +
			"      \"value\": \"200.15\"\n" +
			"    }\n" +
			"    ]\n" +
			"}]";

	public static void main(String args[]) {
		DataParser dataParser = new DataParser();
		List<Token> parsedData = dataParser.getParsedJSONData(dataJSON);
	}
}