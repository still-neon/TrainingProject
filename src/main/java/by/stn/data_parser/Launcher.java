package by.stn.data_parser;

import by.stn.data_parser.parser.CsvDataParser;
import by.stn.data_parser.parser.JsonDataParser;
import by.stn.data_parser.tokens.Token;

import java.util.List;

public class Launcher {
	private static String jsonData = "[{\n" +
			"    \"date\": \"August 2018\",\n" +
			"    \"pairs\": [\n" +
			"    {\n" +
			"      \"text\": \"любая хрень\",\n" +
			"      \"value\": \"275.33\"\n" +
			"    },\n" +
			"    {\n" +
			"      \"text\": \"очень хорошо\",\n" +
			"      \"value\": \"646\"\n" +
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
			"      \"value\": \"217.33\"\n" +
			"    },\n" +
			"    {\n" +
			"      \"text\": \"ни о чём\",\n" +
			"      \"value\": \"136\"\n" +
			"    },\n" +
			"    {\n" +
			"      \"text\": \"жрачка2\",\n" +
			"      \"value\": \"200.15\"\n" +
			"    }\n" +
			"    ]\n" +
			"}]";

	private static String csvData = "\"August 2018\"\n" +
			"\"любая хрень\",\"275.33\"\n" +
			"\"жрачка\",37.33\n" +
			"\"September 2018\"\n" +
			"\"ни о чём\",\"136\"\n" +
			"\"жрачка2\",166.10";

	public static void main(String args[]) {
		JsonDataParser jsonDataParser = new JsonDataParser();
		CsvDataParser csvDataParser = new CsvDataParser();

		List<Token> parsedDataJson = jsonDataParser.getParsedData(jsonData);
		List<Token> parsedDataCsv = csvDataParser.getParsedData(csvData);
	}
}