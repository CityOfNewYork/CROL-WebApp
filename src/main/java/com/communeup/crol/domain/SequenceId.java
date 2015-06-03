package com.communeup.crol.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sequence")
public class SequenceId {

	@Id
	private String id;

	private String seq;

	public String getSeq() {
		return seq;
	}

}
