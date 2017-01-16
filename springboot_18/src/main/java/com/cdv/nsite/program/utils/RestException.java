package com.cdv.nsite.program.utils;

public class RestException extends RuntimeException {

	private static final long serialVersionUID = -7423815637949825141L;
	
	private int code;

	public RestException(int code, String message) {
		super(message);
		this.code = code;
	}

	public RestException(int code, String message, Throwable t) {
		super(message, t);
		this.code = code;
	}

	public RestException(int code, Throwable t) {
		super(t);
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
