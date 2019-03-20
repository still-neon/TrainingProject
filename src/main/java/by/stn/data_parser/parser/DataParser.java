package by.stn.data_parser.parser;

import by.stn.data_parser.tokens.DateToken;
import by.stn.data_parser.tokens.TextNumberPairToken;
import by.stn.data_parser.tokens.Token;
import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class DataParser {
	private static final String JSON_DATA_KEY1 = "date";
	private static final String JSON_DATA_KEY2 = "pairs";
	private static final String JSON_DATA_KEY3 = "text";
	private static final String JSON_DATA_KEY4 = "value";
	private static final String JSON_DATE_FORMAT = "MMMM yyyy";
	private List<Token> tokens;

	public List<Token> getParsedJSONData(String jsonData) {
		tokens = new ArrayList<>();
		Gson gson = new Gson();

		try {
			List<JSONObject> jo = (JSONArray) new JSONParser().parse(jsonData);

			for (JSONObject obj : jo) {

				String str1 = obj.toString();
				String str2 = obj.toString();

			}

			for (Object data : new Gson().fromJson(jsonData, List.class)) {
				parseDate((Map<String, String>) data);
				parseTextValuePairs((Map<String, List<Map<String, String>>>) data);
			}

		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}


		return tokens;
	}

	private void parseDate(Map<String, String> data) {
		try {
			Gson gson = new Gson();
			String str1 = data.toString();
			DateToken tok = gson.fromJson(str1, DateToken.class);


			Date date = new SimpleDateFormat(JSON_DATE_FORMAT).parse(data.get(JSON_DATA_KEY1));
//			tokens.add(new DateToken(date));
			str1 = data.toString();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private void parseTextValuePairs(Map<String, List<Map<String, String>>> data) {
		for (Map<String, String> pairs : data.get(JSON_DATA_KEY2)) {
			tokens.add(new TextNumberPairToken(pairs.get(JSON_DATA_KEY3), Double.valueOf(pairs.get(JSON_DATA_KEY4))));
		}
	}
}