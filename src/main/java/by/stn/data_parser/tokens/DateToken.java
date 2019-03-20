package by.stn.data_parser.tokens;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
public class DateToken implements Token {
	private String date;
	private List<Map<String, String>> pairs;
}