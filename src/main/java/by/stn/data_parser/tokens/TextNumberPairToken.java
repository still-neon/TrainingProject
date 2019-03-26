package by.stn.data_parser.tokens;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TextNumberPairToken implements Token {
	private String text;
	private Double number;
	private String currency;

	public TextNumberPairToken() {
		currency = "";
	}
}