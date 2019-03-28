package by.stn.data_parser.tokens;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TextNumberPairToken implements Token {
	private String text;
	private Double number;
	private String currency;
}