package by.stn.data_parser.parser;

import by.stn.data_parser.data.Records;
import by.stn.data_parser.tokens.Token;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class XmlDataParser {
	private DataParserHelper dataParserHelper;

	public XmlDataParser() {
		dataParserHelper = new DataParserHelper();
	}

	public List<Token> getParsedData(String xmlData) {
		Records records = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Records.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			records = (Records) jaxbUnmarshaller.unmarshal(new StringReader(xmlData));
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return createTokens(records);
	}

	private List<Token> createTokens(Records notes) {
		List<Token> tokens = new ArrayList<>();

//		for (Data data : dataArray) {
//			tokens.add(dataParserHelper.createDateToken(data.getDate()));
//
//			for (Data.TextNumberPair pair : data.getPairs()) {
//				tokens.add(dataParserHelper.createTextNumberPairToken(pair.getText(), pair.getValue()));
//			}
//		}

		return tokens;
	}
}