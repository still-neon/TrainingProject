package by.stn.data_parser.tokens;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DateToken implements Token {
	private String date;
	private String pairs;
}