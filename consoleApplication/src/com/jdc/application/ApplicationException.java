package com.jdc.application;

public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public enum Type {
		EXIT, BLANK, NAN, IVALID, EXEED_MAX_MISSING_COUNT
	}

	private Type type;
	private String field;

	public ApplicationException(Type type) {
		super();
		this.type = type;
	}

	public ApplicationException(Type type, String field) {
		super();
		this.type = type;
		this.field = field;
	}

	public Type getType() {
		return type;
	}

	public String getField() {
		return field;
	}
}
