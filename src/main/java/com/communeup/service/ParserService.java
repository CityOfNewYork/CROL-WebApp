package com.communeup.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.stereotype.Service;

import com.communeup.crol.to.CrolInput;
import com.communeup.to.ParserConfig;
import com.communeup.util.ParserUtil;

@Service
public class ParserService {

	private Map<String, List<ParserConfig>> parserConfigMap;

	private static final String parserConfigFile = "parserConfig.properties";

	public ParserService() {
		buildParserConfig();

		if (parserConfigMap != null) {
			System.out.println(parserConfigMap.size() + " Properties Loaded !");
		}
	}

	private void buildParserConfig() {
		try {
			Properties properties = new Properties();

			InputStream stream = getClass().getClassLoader().getResourceAsStream(parserConfigFile);
			properties.load(stream);

			if (properties != null && properties.size() > 0) {
				for(Object object : properties.keySet()) {
					String key = (String)object;
					String value = (String)properties.get(key);

					String noticeTypes[] = key.split(",");
					String parserParams[] = value.split(",");

					// Create Parser
					ParserConfig parserConfig = new ParserConfig(parserParams[0],
							parserParams[1], parserParams[2],
							(parserParams.length == 4) ? parserParams[3] : "");

					// For each Notice Type .. add Parser.
					for (String noticeType : noticeTypes) {
						if (parserConfigMap == null) {
							parserConfigMap = new HashMap<String, List<ParserConfig>>();
						}

						List<ParserConfig> parsers = parserConfigMap.get(noticeType);
						if (parsers == null) {
							parsers = new ArrayList<ParserConfig>();
						}
						parsers.add(parserConfig);

						parserConfigMap.put(noticeType, parsers);
					}
				}
			}
		} catch(Exception ex) {
			System.out.println("================== PROPERTY FILE NOT FOUND ====================");
			ex.printStackTrace();
		}
	}

	public static void main1(String[] args) {
		String additionalDescription = "NOTICE IS HEREBY GIVEN, pursuant to law, that the New York City Department of Consumer Affairs will hold a Public Hearing on Wednesday, January 28, 2015, at 2:00 P.M., at 66 John Street, 11th Floor, in the Borough of Manhattan, on the following petitions for sidewalk café revocable consent: 1. 132 Mulberry Inc. 132 Mulberry Street in the Borough of Manhattan.";

		CrolInput crolInput = new CrolInput();
		crolInput.setAdditionalDescription(additionalDescription);

		ParserService service = new ParserService();
		String noticeType = "Tender";

		String text = service.parseInput(noticeType, crolInput);
		System.out.println(text);
	}

	public String parseInput(String noticeType, CrolInput input) {
		String output = null;
		List<ParserConfig> parsers = parserConfigMap.get(noticeType);

		for (ParserConfig parser : parsers) {
			output = ParserUtil.parseInput(input.getFieldValue(parser.getInputElement()), parser);
		}

		return output;
	}

}
