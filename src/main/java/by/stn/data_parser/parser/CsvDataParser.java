package by.stn.data_parser.parser;

import by.stn.data_parser.tokens.DateToken;
import by.stn.data_parser.tokens.Token;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CsvDataParser extends DataParser {
	private static final String LINES_SEPARATOR = "\n";
	private static final String PAIR_SEPARATOR = ",";
	private static final int PAIR_PARTS_NUMBER = 2;
	private static final String QUOTE = "\"";
	private static final String EMPTY = "";
	private SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);

	public List<Token> getParsedData(String csvData) {
		csvData = deleteQuotes(csvData);
		String[] lines = csvData.split(LINES_SEPARATOR);

		return createTokens(lines);
	}

	private List<Token> createTokens(String[] lines) {
		List<Token> tokens = new ArrayList<>();

		for (String line : lines) {
			if (!line.contains(PAIR_SEPARATOR)) {
				try {
					tokens.add(new DateToken(format.parse(line)));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			} else {
				String[] pair = line.split(PAIR_SEPARATOR, PAIR_PARTS_NUMBER);
//				tokens.add(new TextNumberPairToken(pair[0], Double.valueOf(pair[1])));
			}
		}

		return tokens;
	}

	private String deleteQuotes(String line) {
		return line.replace(QUOTE, EMPTY);
	}
}