package by.stn.data_parser;

import by.stn.data_parser.parser.CsvDataParser;
import by.stn.data_parser.parser.JsonDataParser;
import by.stn.data_parser.parser.XmlDataParser;
import by.stn.data_parser.tokens.Token;
import lombok.Getter;

import java.util.List;
import java.util.Set;


public class Launcher {
	@Getter
	private static final String XML_RELATIVE_FILE_PATH = "data_sets/data.xml";
	@Getter
	private static final String JSON_RELATIVE_FILE_PATH = "data_sets/data.json";
	@Getter
	private static final String CSV_RELATIVE_FILE_PATH = "data_sets/data.csv";
	@Getter
	private static final String FILE_PATH = "data_sets/text.txt";

	public static void main(String args[]) {
		JsonDataParser jsonDataParser = new JsonDataParser();
		CsvDataParser csvDataParser = new CsvDataParser();
		XmlDataParser xmlDataParser = new XmlDataParser();

//		List<String> parsedDataJson = jsonDataParser.getParsedData(FILE_PATH);
		Set<String> parsedDataCsv = csvDataParser.getParsedData(FILE_PATH);
		for (String str : parsedDataCsv) {
			System.out.println(str);
		}
		List<Token> parsedDataXml = xmlDataParser.getParsedData(XML_RELATIVE_FILE_PATH);
	}
}