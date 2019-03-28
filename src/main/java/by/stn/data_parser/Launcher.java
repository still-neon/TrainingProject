package by.stn.data_parser;

import by.stn.data_parser.parser.CsvDataParser;
import by.stn.data_parser.parser.JsonDataParser;
import by.stn.data_parser.parser.XmlDataParser;
import by.stn.data_parser.tokens.Token;
import lombok.Getter;

import java.io.File;
import java.util.List;


public class Launcher {
	private static final String PATH = System.getProperty("user.dir");
	private static final String FS = System.getProperty("file.separator");
	private static final String DATA_SETS_DIRECTORY_PATH = PATH + FS + "src" + FS + "main" + FS + "resources" + FS + "data_parser" + FS;
	@Getter
	private static final String XML_FILE_PATH = DATA_SETS_DIRECTORY_PATH + "data.xml";
	@Getter
	private static final String JSON_DATA = "[{\n" +
			"    \"date\": \"August 2018\",\n" +
			"    \"pairs\": [\n" +
			"    {\n" +
			"      \"text\": \"любая, хрень\",\n" +
			"      \"value\": \"275\"\n" +
			"    },\n" +
			"    {\n" +
			"      \"text\": \"очень хорошо\",\n" +
			"      \"value\": \"646,56\"\n" +
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
			"      \"text\": \"любая хрень 123\",\n" +
			"      \"value\": \"$217,33\"\n" +
			"    },\n" +
			"    {\n" +
			"      \"text\": \"ни о чём,\",\n" +
			"      \"value\": \"$136\"\n" +
			"    },\n" +
			"    {\n" +
			"      \"text\": \"жрачка2\",\n" +
			"      \"value\": \"$200.15\"\n" +
			"    }\n" +
			"    ]\n" +
			"}]";

	@Getter
	private static final String CSV_DATA = "\"August 2018\"\n" +
			"\"любая хрень\",\"275\"\n" +
			"\"очень хорошо\",\"646,56\"\n" +
			"\"жрачка\",37.33\n" +
			"\"September 2018\"\n" +
			"\"любая хрень 123\",\"$217,33\"\n" +
			"\"ни о чём\",\"$136\"\n" +
			"\"жрачка2\",$200.15";

	public static void main(String args[]) {
		File file = new File(PATH + "data.xml");
		System.out.println(PATH);
		JsonDataParser jsonDataParser = new JsonDataParser();
		CsvDataParser csvDataParser = new CsvDataParser();
		XmlDataParser xmlDataParser = new XmlDataParser();

//		List<Token> parsedDataJson = jsonDataParser.getParsedData(JSON_DATA);
//		List<Token> parsedDataCsv = csvDataParser.getParsedData(CSV_DATA);
		List<Token> parsedDataXml = xmlDataParser.getParsedData(XML_FILE_PATH);
	}
}