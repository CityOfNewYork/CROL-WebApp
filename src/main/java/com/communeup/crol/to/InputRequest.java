package com.communeup.crol.to;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Input Request Json
 *
 */
@JsonInclude(Include.NON_NULL)
@XmlRootElement(name = "InputRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InputRequest {

	private String lastRequestTime;

	public String getLastRequestTime() {
		return lastRequestTime;
	}

	public void setLastRequestTime(String lastRequestTime) {
		this.lastRequestTime = lastRequestTime;
	}

}
