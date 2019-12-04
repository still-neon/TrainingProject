package by.stn.java_exercises.modul_2.ex_10_11;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javax.xml.stream.XMLStreamConstants.*;


public class PointsXMLParser {
	private List<Point> points;

	public List<Point> getDOMParsed(String filePath) {
		points = new ArrayList<>();
		Document document = null;

		try {
			DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			document = documentBuilder.parse(new File(filePath));
		} catch (SAXException | ParserConfigurationException | IOException e) {
			e.printStackTrace();
		}

		Element root = document.getDocumentElement();
		NodeList pointsList = root.getChildNodes();

		for (int m = 0; m < pointsList.getLength(); m++) {
			if (pointsList.item(m) instanceof Element) {
				Point point = new Point(pointsList.item(m).getNodeName(), ((Element) pointsList.item(m)).getAttribute("unit"));
				NodeList coordinateList = pointsList.item(m).getChildNodes();
				for (int n = 0; n < coordinateList.getLength(); n++) {
					if (coordinateList.item(n) instanceof Element) {
						point.setCoordinate(coordinateList.item(n).getNodeName(), Integer.valueOf(coordinateList.item(n).getTextContent()));
					}
				}
				points.add(point);
			}
		}
		return points;
	}

	public List<Point> getStAXParsed(String filePath) {
		points = new ArrayList<>();

		try {
			XMLStreamReader reader = XMLInputFactory.newFactory().createXMLStreamReader(new FileInputStream(filePath));

			while (reader.hasNext()) {
				int result = reader.next();
				if (isPoint(reader, result)) {
					points.add(getPoint(reader));
				}
			}
		} catch (FileNotFoundException | XMLStreamException e) {
			e.printStackTrace();
		}
		return points;
	}

	private Point getPoint(XMLStreamReader reader) throws XMLStreamException {
		Point point = new Point(reader.getLocalName(), reader.getAttributeValue(0));
		int result = reader.next();
		while (result != END_ELEMENT) {
			if (isCoordinateName(reader, result)) {
				point.addCoordinate(getCoordinate(reader));
			}
			result = reader.next();
		}
		return point;
	}

	private Map<String, Integer> getCoordinate(XMLStreamReader reader) throws XMLStreamException {
		String coordinateName = reader.getLocalName();
		Map<String, Integer> coordinate = new HashMap<>();
		int result = reader.next();
		if (isCoordinateValue(result)) {
			coordinate.put(coordinateName, Integer.valueOf(reader.getText()));
			reader.next();
		}
		return coordinate;
	}

	private Boolean isPoint(XMLStreamReader reader, int result) {
		return result == START_ELEMENT && !reader.getLocalName().equals("pointsList") && reader.getAttributeCount() == 1;
	}

	private Boolean isCoordinateName(XMLStreamReader reader, int result) {
		return result == START_ELEMENT && reader.getAttributeCount() == 0;
	}

	private Boolean isCoordinateValue(int result) {
		return result == CHARACTERS;
	}
}