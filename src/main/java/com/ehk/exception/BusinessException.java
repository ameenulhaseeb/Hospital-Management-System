package com.ehk.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	protected String errorCode;

	public BusinessException(String errorCode, String message, Throwable throwable) {

		super(message, throwable);
	}
	
	public BusinessException( String message, Throwable throwable) {

		super(message, throwable);
	}
}
