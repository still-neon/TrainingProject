package by.stn.data_parser.tokens;

import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
public class Data {
	private Date date;
	private List<TextNumberPairToken> pairs;
}