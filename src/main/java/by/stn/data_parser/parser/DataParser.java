package by.stn.data_parser.parser;

import by.stn.data_parser.tokens.DateToken;
import by.stn.data_parser.tokens.TextNumberPairToken;
import by.stn.data_parser.tokens.Token;
import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataParser {
	private static final String JSON_DATA_KEY1 = "date";
	private static final String JSON_DATA_KEY2 = "pairs";
	private static final String JSON_DATA_KEY3 = "text";
	private static final String JSON_DATA_KEY4 = "value";
	private static final String MONTH_AND_YEAR_SEPARATOR = " ";
	private static final int PARTS_NUMBER = 2;
	private List<Token> tokens;

	public List<Token> getParsedJSONData(String jsonData) {
		tokens = new ArrayList<>();
		Gson gson = new Gson();

//		jsonData = "{'date' : 'August 2018'}";

		DateToken tok = gson.fromJson(jsonData, DateToken.class);

//		try {
//			for (Object object : (JSONArray) new JSONParser().parse(jsonData)) {
//				parseDate((JSONObject) object);
//				parseTextValuePairs((JSONObject) object);
//			}
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		return tokens;
	}

	private void parseDate(Gson gson) {

//		String[] pair = ((Map<String, String>) object).get(JSON_DATA_KEY1).split(MONTH_AND_YEAR_SEPARATOR, PARTS_NUMBER);
//		tokens.add(new DateToken(pair[0], Integer.valueOf(pair[1])));
	}

	private void parseTextValuePairs(JSONObject object) {
		for (Object pair : ((Map<String, JSONArray>) object).get(JSON_DATA_KEY2)) {
			tokens.add(new TextNumberPairToken(((Map<String, String>) pair).get(JSON_DATA_KEY3), Double.valueOf(((Map<String, String>) pair).get(JSON_DATA_KEY4))));
		}
	}
}