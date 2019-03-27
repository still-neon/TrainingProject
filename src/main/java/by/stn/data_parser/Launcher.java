package by.stn.data_parser;

import by.stn.data_parser.parser.CsvDataParser;
import by.stn.data_parser.parser.JsonDataParser;
import by.stn.data_parser.parser.XmlDataParser;
import by.stn.data_parser.tokens.Token;
import lombok.Getter;

import java.util.List;


public class Launcher {
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

	@Getter
	private static final String XML_DATA = "<records>\n" +
			"\t<record>\n" +
			"\t\t<date>August 2018</date>\n" +
			"\t\t<pairs>\n" +
			"\t\t\t<pair>\t\t\t\n" +
			"\t\t\t\t<text>любая, хрень</text>\n" +
			"\t\t\t\t<value>275</value>\n" +
			"\t\t\t</pair>\n" +
			"\t\t\t<pair>\t\t\t\n" +
			"\t\t\t\t<text>очень хорошо</text>\n" +
			"\t\t\t\t<value>646,56</value>\n" +
			"\t\t\t</pair>\n" +
			"\t\t\t<pair>\t\t\t\n" +
			"\t\t\t\t<text>жрачка</text>\n" +
			"\t\t\t\t<value>37.33</value>\n" +
			"\t\t\t</pair>\n" +
			"\t\t</pairs>\n" +
			"\t</record>\n" +
			"\t<record>\n" +
			"\t\t<date>September 2018</date>\n" +
			"\t\t<pairs>\n" +
			"\t\t\t<pair>\t\t\t\n" +
			"\t\t\t\t<text>любая хрень 123</text>\n" +
			"\t\t\t\t<value>$217,33</value>\n" +
			"\t\t\t</pair>\n" +
			"\t\t\t<pair>\t\t\t\n" +
			"\t\t\t\t<text>ни о чём,</text>\n" +
			"\t\t\t\t<value>$136</value>\n" +
			"\t\t\t</pair>\n" +
			"\t\t\t<pair>\t\t\t\n" +
			"\t\t\t\t<text>жрачка2</text>\n" +
			"\t\t\t\t<value>$200.15</value>\n" +
			"\t\t\t</pair>\n" +
			"\t\t</pairs>\n" +
			"\t</record>\n" +
			"</records>";

	public static void main(String args[]) {
		JsonDataParser jsonDataParser = new JsonDataParser();
		CsvDataParser csvDataParser = new CsvDataParser();
		XmlDataParser xmlDataParser = new XmlDataParser();

//		List<Token> parsedDataJson = jsonDataParser.getParsedData(JSON_DATA);
//		List<Token> parsedDataCsv = csvDataParser.getParsedData(CSV_DATA);
		List<Token> parsedDataXml = xmlDataParser.getParsedData(XML_DATA);
	}
}