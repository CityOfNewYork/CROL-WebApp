package com.communeup.crol;

public class SequenceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String errCode;
	private String errMsg;

	public SequenceException(String errMsg) {
		this.errMsg = errMsg;
	}

}