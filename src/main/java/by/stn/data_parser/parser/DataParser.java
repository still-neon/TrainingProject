package by.stn.data_parser.parser;

import by.stn.data_parser.tokens.Data;
import by.stn.data_parser.tokens.DateToken;
import by.stn.data_parser.tokens.TextNumberPairToken;
import by.stn.data_parser.tokens.Token;
import com.google.gson.Gson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DataParser {
	private static final String JSON_DATE_FORMAT = "MMMM yyyy";
	private SimpleDateFormat format;
	private List<Token> tokens;

	public List<Token> getParsedJSONData(String jsonData) {
		tokens = new ArrayList<>();
		format = new SimpleDateFormat(JSON_DATE_FORMAT);

		for (Data data : new Gson().fromJson(jsonData, Data[].class)) {
			updateTokensList(data);
		}

		return tokens;
	}

	private void updateTokensList(Data data) {
		tokens.add(getDateToken(data));

		for (TextNumberPairToken pair : data.getPairs()) {
			tokens.add(pair);
		}
	}

	private DateToken getDateToken(Data data) {
		try {
			return new DateToken(format.parse(data.getDate()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}