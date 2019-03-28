package by.stn.data_parser;

import by.stn.data_parser.parser.CsvDataParser;
import by.stn.data_parser.parser.JsonDataParser;
import by.stn.data_parser.parser.XmlDataParser;
import by.stn.data_parser.tokens.Token;
import lombok.Getter;

import java.util.List;


public class Launcher {
	private static final String PATH = System.getProperty("user.dir");
	private static final String FS = System.getProperty("file.separator");
	private static final String DATA_SETS_DIRECTORY_PATH = PATH + FS + "src" + FS + "main" + FS + "resources" + FS + "data_parser" + FS;
	@Getter
	private static final String XML_FILE_PATH = DATA_SETS_DIRECTORY_PATH + "data.xml";
	@Getter
	private static final String JSON_FILE_PATH = DATA_SETS_DIRECTORY_PATH + "data.json";
	@Getter
	private static final String CSV_FILE_PATH = DATA_SETS_DIRECTORY_PATH + "data.csv";

	public static void main(String args[]) {
		JsonDataParser jsonDataParser = new JsonDataParser();
		CsvDataParser csvDataParser = new CsvDataParser();
		XmlDataParser xmlDataParser = new XmlDataParser();

		List<Token> parsedDataJson = jsonDataParser.getParsedData(JSON_FILE_PATH);
		List<Token> parsedDataCsv = csvDataParser.getParsedData(CSV_FILE_PATH);
		List<Token> parsedDataXml = xmlDataParser.getParsedData(XML_FILE_PATH);
	}
}