package by.stn.data_parser.tokens;


import lombok.Getter;
import lombok.Setter;

@Getter
public class TextNumberPairToken implements Token {
	private String text;
	private String value;
	@Setter
	private Double number;
	@Setter
	private String currency;
}