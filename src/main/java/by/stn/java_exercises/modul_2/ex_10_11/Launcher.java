package by.stn.java_exercises.modul_2.ex_10_11;

import by.stn.data_parser.parser.DataParserHelper;

import java.util.List;

public class Launcher {
	private static final String XML_RELATIVE_FILE_PATH = "data_sets/data/pointsList.xml";

	private static void print(List<Point> points) {
		for (Point point : points) {
			print(point);
		}
	}

	private static void print(Point point) {
		Object[] coordinates = point.getCoordinates().keySet().toArray();
		System.out.print(String.format("%s: ", point.getTag()));

		for (int i = 0; i < coordinates.length; i++) {
			System.out.print(String.format("%s = %s%s ", coordinates[i], point.getCoordinates().get(coordinates[i]), point.getUnit()));
		}
		System.out.println();
	}

	public static void main(String args[]) {
		PointsXMLParser parser = new PointsXMLParser();
//		print(parser.getDOMParsed(new DataParserHelper().getFilePath(XML_RELATIVE_FILE_PATH)));
		print(parser.getStAXParsed(new DataParserHelper().getFilePath(XML_RELATIVE_FILE_PATH)));
	}
}