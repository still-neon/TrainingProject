package by.stn.data_parser.tokens;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TextNumberPairToken implements Token {
	private String text;
	private Double value;
}