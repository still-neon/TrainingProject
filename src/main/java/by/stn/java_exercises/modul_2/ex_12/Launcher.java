package by.stn.java_exercises.modul_2.ex_12;

import by.stn.data_parser.parser.DataParserHelper;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Launcher {
	private static final String XSL_RELATIVE_FILE_PATH = "data_sets/data12/stylesheet.xsl";
	private static final String XML_RELATIVE_FILE_PATH = "data_sets/data12/pointsList.xml";
	private static final String HTML_RELATIVE_FILE_PATH = "data_sets/data12/pointsList.html";

	public static void main(String[] args) {
		DataParserHelper dataParserHelper = new DataParserHelper();

		Source xslDoc = new StreamSource(dataParserHelper.getFilePath(XSL_RELATIVE_FILE_PATH));
		Source xmlDoc = new StreamSource(dataParserHelper.getFilePath(XML_RELATIVE_FILE_PATH));
		try {
			Transformer transformer = TransformerFactory.newInstance().newTransformer(xslDoc);
			transformer.transform(xmlDoc, new StreamResult(System.out));
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}