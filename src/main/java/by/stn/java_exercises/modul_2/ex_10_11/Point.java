package by.stn.java_exercises.modul_2.ex_10_11;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@NoArgsConstructor
public class Point {
	@Setter
	private String tag;
	@Setter
	private String unit;
	private Map<String, Integer> coordinates;

	Point(String tag, String unit) {
		this.tag = tag;
		this.unit = unit;
		coordinates = new LinkedHashMap<>();
	}

	public void setCoordinate(String coordinate, Integer value) {
		coordinates.put(coordinate, value);
	}

	public void addCoordinate(Map<String, Integer> coordinate) {
		coordinates.putAll(coordinate);
	}
}