package by.stn.data_parser.parser;

import by.stn.data_parser.tokens.Data;
import by.stn.data_parser.tokens.DateToken;
import by.stn.data_parser.tokens.TextNumberPairToken;
import by.stn.data_parser.tokens.Token;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class JsonDataParser extends DataParser {

	public List<Token> getParsedData(String jsonData) {
		Gson gson = new GsonBuilder().setDateFormat(DATE_FORMAT).create();
		Data[] dataArray = gson.fromJson(jsonData, Data[].class);

		return createTokens(dataArray);
	}

	private List<Token> createTokens(Data[] dataArray) {
		List<Token> tokens = new ArrayList<>();

		for (Data data : dataArray) {
			tokens.add(new DateToken(data.getDate()));

			for (TextNumberPairToken pair : data.getPairs()) {
				setNumberValue(pair);
				tokens.add(pair);
			}
		}

		return tokens;
	}

	private void setNumberValue(TextNumberPairToken token) {
		String numberValue = token.getValue();
		if (numberValue.contains("$")) {
			token.setCurrency("$");
			numberValue = numberValue.replace("$", "");
		} else {
			token.setCurrency("");
		}
		if (numberValue.contains(",")) {
			numberValue = numberValue.replace(",", ".");
		}
		token.setNumber(Double.valueOf(numberValue));
	}
}