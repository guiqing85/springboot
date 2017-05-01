package com.glv.exception;

public class AppException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6426262375012447340L;

	public AppException(String message, Throwable cause) {
		super(message, cause);
	}

	public AppException(String message) {
		super(message);
	}

	public AppException(Throwable cause) {
		super(cause);
	}

}
