package com.communeup.to;

/**
 * Represents Parser COnfiguration.
 * 
 * @author rtempalli
 *
 */
public class ParserConfig {

	public ParserConfig(String url, String inputElement, String parentElement,
			String jsonSchema) {
		this.url = url;
		this.jsonSchema = jsonSchema;
		this.inputElement = inputElement;
		this.parentElement = parentElement;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getJsonSchema() {
		return jsonSchema;
	}

	public void setJsonSchema(String jsonSchema) {
		this.jsonSchema = jsonSchema;
	}

	public String getInputElement() {
		return inputElement;
	}

	public void setInputElement(String inputElement) {
		this.inputElement = inputElement;
	}

	public String getParentElement() {
		return parentElement;
	}

	public void setParentElement(String parentElement) {
		this.parentElement = parentElement;
	}

	private String url;
	private String jsonSchema;
	private String inputElement;
	private String parentElement;

}
