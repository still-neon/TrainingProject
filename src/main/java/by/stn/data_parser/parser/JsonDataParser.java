package by.stn.data_parser.parser;

import by.stn.data_parser.tokens.Data;
import by.stn.data_parser.tokens.Token;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class JsonDataParser {
	private DataParserHelper dataParserHelper;

	public JsonDataParser() {
		dataParserHelper = new DataParserHelper();
	}

	public List<Token> getParsedData(String jsonData) {
		Gson gson = new GsonBuilder().setDateFormat(DataParserHelper.getDATE_FORMAT()).create();
		Data[] dataArray = gson.fromJson(jsonData, Data[].class);

		return createTokens(dataArray);
	}

	private List<Token> createTokens(Data[] dataArray) {
		List<Token> tokens = new ArrayList<>();

		for (Data data : dataArray) {
			tokens.add(dataParserHelper.createDateToken(data.getDate()));

			for (Data.TextNumberPair pair : data.getPairs()) {
				tokens.add(dataParserHelper.createTextNumberPairToken(pair.getText(), pair.getValue()));
			}
		}

		return tokens;
	}
}