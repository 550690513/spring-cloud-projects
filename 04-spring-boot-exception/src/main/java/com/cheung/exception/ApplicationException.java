package com.cheung.exception;

/**
 * 自定义异常
 *
 * @author Cheung
 */
public class ApplicationException extends RuntimeException {

	public ApplicationException() {
		super();
	}

	public ApplicationException(String message) {
		super(message);
	}

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}
}
