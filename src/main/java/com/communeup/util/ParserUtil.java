package com.communeup.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.amazonaws.util.json.JSONArray;
import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;
import com.communeup.to.ParserConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class ParserUtil {

	/**
	 * Use this method to Parse any input with any Parser.
	 * 
	 * @param inputPayload
	 * @param parserConfig
	 * @return
	 */
	public static String parseInput(String inputPayload, ParserConfig parserConfig) {
		String parserOutput = "";

		try {
			URL url = new URL(parserConfig.getUrl());

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String input = "{\"source\":\"" + inputPayload.replaceAll("\n", " ") + "\"}";

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			JSONArray addresses = null;
			JSONObject topObject = null;
			String output = "", JSON_DATA = null;

			while ((JSON_DATA = br.readLine()) != null) {
				output += JSON_DATA;
			}

			try {
				topObject = new JSONObject(output);
				addresses = topObject.getJSONArray(parserConfig.getParentElement());
				conn.disconnect();

				parserOutput = addresses.toString();
			} catch (JSONException e) {
				e.printStackTrace();
				parserOutput = "Parser Failed";
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
			parserOutput = "Parser Failed";
		} catch (IOException e) {
			e.printStackTrace();
			parserOutput = "Parser Failed";
		}

		return "\"" + parserConfig.getParentElement() + "\":" + pretty(parserOutput);
	}

	private static String pretty(String parserOutput) {
		JsonParser parser = new JsonParser();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonElement el = parser.parse(parserOutput);
		parserOutput = gson.toJson(el);
		return parserOutput;
	}

}
