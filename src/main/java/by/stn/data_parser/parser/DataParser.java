package by.stn.data_parser.parser;

import by.stn.data_parser.tokens.Token;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.List;

public class DataParser {

	public List<Token> getParsedJSONData(String data) {
		try {
			JSONArray jo = (JSONArray) new JSONParser().parse(data);
			System.out.println(jo);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}