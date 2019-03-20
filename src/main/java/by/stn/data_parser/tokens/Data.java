package by.stn.data_parser.tokens;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
public class Data {
	@Getter
	private String date;
	@Getter
	private List<TextNumberPairToken> pairs;
}